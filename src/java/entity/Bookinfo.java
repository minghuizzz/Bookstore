/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZhuMinghu1
 */
@Entity
@Table(name = "bookinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookinfo.findAll", query = "SELECT b FROM Bookinfo b"),
    @NamedQuery(name = "Bookinfo.findById", query = "SELECT b FROM Bookinfo b WHERE b.id = :id"),
    @NamedQuery(name = "Bookinfo.findByIsbn", query = "SELECT b FROM Bookinfo b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Bookinfo.findByAuthor", query = "SELECT b FROM Bookinfo b WHERE b.author = :author"),
    @NamedQuery(name = "Bookinfo.findByBookname", query = "SELECT b FROM Bookinfo b WHERE b.bookname = :bookname"),
    @NamedQuery(name = "Bookinfo.findByPrice", query = "SELECT b FROM Bookinfo b WHERE b.price = :price"),
    @NamedQuery(name = "Bookinfo.findByBooktype", query = "SELECT b FROM Bookinfo b WHERE b.booktype = :booktype"),
    @NamedQuery(name = "Bookinfo.findByBookpicture", query = "SELECT b FROM Bookinfo b WHERE b.bookpicture = :bookpicture"),
    @NamedQuery(name = "Bookinfo.findByDescription", query = "SELECT b FROM Bookinfo b WHERE b.description = :description"),
    @NamedQuery(name = "Bookinfo.findBySellcount", query = "SELECT b FROM Bookinfo b WHERE b.sellcount = :sellcount"),
    @NamedQuery(name = "Bookinfo.findRecommandations", query = "SELECT b FROM Bookinfo b WHERE b.booktype = :booktype AND b.bookname != :bookname"),
    @NamedQuery(name = "Bookinfo.findTop3", query = "SELECT b FROM Bookinfo b ORDER BY b.sellcount")})
public class Bookinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bookname")
    private String bookname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "booktype")
    private String booktype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bookpicture")
    private String bookpicture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sellcount")
    private String sellcount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookinfo")
    private Collection<OrderedProduct> orderedProductCollection;

    public Bookinfo() {
    }

    public Bookinfo(Integer id) {
        this.id = id;
    }

    public Bookinfo(Integer id, String isbn, String author, String bookname, String price, String booktype, String bookpicture, String description, String sellcount) {
        this.id = id;
        this.isbn = isbn;
        this.author = author;
        this.bookname = bookname;
        this.price = price;
        this.booktype = booktype;
        this.bookpicture = bookpicture;
        this.description = description;
        this.sellcount = sellcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getBookpicture() {
        return bookpicture;
    }

    public void setBookpicture(String bookpicture) {
        this.bookpicture = bookpicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellcount() {
        return sellcount;
    }

    public void setSellcount(String sellcount) {
        this.sellcount = sellcount;
    }

    @XmlTransient
    public Collection<OrderedProduct> getOrderedProductCollection() {
        return orderedProductCollection;
    }

    public void setOrderedProductCollection(Collection<OrderedProduct> orderedProductCollection) {
        this.orderedProductCollection = orderedProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookinfo)) {
            return false;
        }
        Bookinfo other = (Bookinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bookinfo[ id=" + id + " ]";
    }

}
