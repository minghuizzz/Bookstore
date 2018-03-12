/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="searchManagedBean")
@SessionScoped
public class SearchManagedBean {
    private String search;
    public SearchManagedBean() {
    }
    
    public String getSearch() {
        return search;
    }

    public void setSearch(String user_search) {
        this.search = user_search;
    }
}