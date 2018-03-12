/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ZhuMinghu1
 */
@Embeddable
public class OrderedProductPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_order_id")
    private int customerOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bookinfo_id")
    private int bookinfoId;

    public OrderedProductPK() {
    }

    public OrderedProductPK(int customerOrderId, int bookinfoId) {
        this.customerOrderId = customerOrderId;
        this.bookinfoId = bookinfoId;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public int getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(int bookinfoId) {
        this.bookinfoId = bookinfoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customerOrderId;
        hash += (int) bookinfoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedProductPK)) {
            return false;
        }
        OrderedProductPK other = (OrderedProductPK) object;
        if (this.customerOrderId != other.customerOrderId) {
            return false;
        }
        if (this.bookinfoId != other.bookinfoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedProductPK[ customerOrderId=" + customerOrderId + ", bookinfoId=" + bookinfoId + " ]";
    }
    
}
