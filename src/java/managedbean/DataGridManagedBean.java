/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.ejb.EJB;
import session.BookinfoFacade;
import entity.Bookinfo;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ZhuMinghu1
 */
@ManagedBean
@SessionScoped
public class DataGridManagedBean implements Serializable {
    @EJB
    private BookinfoFacade bookinfoFacade;
    @PersistenceContext
    private EntityManager eml;
    @ManagedProperty("#{searchManagedBean}")
    private SearchManagedBean searchManagedBean;

    public BookinfoFacade getBookinfoFacade() {
        return bookinfoFacade;
    }

    public void setBookinfoFacade(BookinfoFacade bookinfoFacade) {
        this.bookinfoFacade = bookinfoFacade;
    }

    public EntityManager getEml() {
        return eml;
    }

    public SearchManagedBean getSearchManagedBean() {
        return searchManagedBean;
    }

    public void setSearchManagedBean(SearchManagedBean searchManagedBean) {
        this.searchManagedBean = searchManagedBean;
    }

    public void setEml(EntityManager eml) {
        this.eml = eml;
    }

    private List<Bookinfo> books;
    private Bookinfo selectedBook;
    private List<Bookinfo> recommandations;
    private List<Bookinfo> top3;
    
    public DataGridManagedBean() {
    }
    public List<Bookinfo> getBooks(){
        return books;
    }
    
    public String setBooksBySearch(){
        books = eml.createNamedQuery("Bookinfo.findByBookname").setParameter("bookname", searchManagedBean.getSearch()).getResultList();
        return "search.xhtml";
    }
    
    public void setBooksByCatalogue(String catalogue){
        books = eml.createNamedQuery("Bookinfo.findByBooktype").setParameter("booktype",catalogue).getResultList();
    }
    
    public String setBooksByBreadCrumb(){
        books = eml.createNamedQuery("Bookinfo.findByBooktype").setParameter("booktype",selectedBook.getBooktype()).getResultList();
        return "search.xhtml";
    }

    public List<Bookinfo> getRecommandations() {
        return recommandations;
    } 
    
    public Bookinfo getSelectedBook(){
        return selectedBook;
    }
 
    public void setSelectedBook(Bookinfo selectedBook) {
        this.selectedBook = selectedBook;
        String sql = "select bookinfo from bookinfo where b.booktype = \"" + selectedBook.getBooktype()+"\" and b.bookname != \"" + selectedBook.getBookname() + "\"";
        recommandations = eml.createNamedQuery("Bookinfo.findRecommandations").setParameter("booktype",selectedBook.getBooktype()).setParameter("bookname",selectedBook.getBookname()).getResultList();
    }

    public List<Bookinfo> getTop3() {
        top3 = eml.createNamedQuery("Bookinfo.findTop3").getResultList();
        return top3;
    }

    
}
