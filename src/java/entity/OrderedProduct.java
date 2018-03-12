/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZhuMinghu1
 */
@Entity
@Table(name = "ordered_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderedProduct.findAll", query = "SELECT o FROM OrderedProduct o"),
    @NamedQuery(name = "OrderedProduct.findByCustomerOrderId", query = "SELECT o FROM OrderedProduct o WHERE o.orderedProductPK.customerOrderId = :customerOrderId"),
    @NamedQuery(name = "OrderedProduct.findByBookinfoId", query = "SELECT o FROM OrderedProduct o WHERE o.orderedProductPK.bookinfoId = :bookinfoId"),
    @NamedQuery(name = "OrderedProduct.findByQuantity", query = "SELECT o FROM OrderedProduct o WHERE o.quantity = :quantity")})
public class OrderedProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderedProductPK orderedProductPK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "customer_order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerOrder customerOrder;
    @JoinColumn(name = "bookinfo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bookinfo bookinfo;

    public OrderedProduct() {
    }

    public OrderedProduct(OrderedProductPK orderedProductPK) {
        this.orderedProductPK = orderedProductPK;
    }

    public OrderedProduct(int customerOrderId, int bookinfoId) {
        this.orderedProductPK = new OrderedProductPK(customerOrderId, bookinfoId);
    }

    public OrderedProductPK getOrderedProductPK() {
        return orderedProductPK;
    }

    public void setOrderedProductPK(OrderedProductPK orderedProductPK) {
        this.orderedProductPK = orderedProductPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Bookinfo getBookinfo() {
        return bookinfo;
    }

    public void setBookinfo(Bookinfo bookinfo) {
        this.bookinfo = bookinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderedProductPK != null ? orderedProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedProduct)) {
            return false;
        }
        OrderedProduct other = (OrderedProduct) object;
        if ((this.orderedProductPK == null && other.orderedProductPK != null) || (this.orderedProductPK != null && !this.orderedProductPK.equals(other.orderedProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedProduct[ orderedProductPK=" + orderedProductPK + " ]";
    }
    
}
