/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package we.codered.rokomari.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sss
 */
@Entity
@Table(name = "ordered_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderedItems.findAll", query = "SELECT o FROM OrderedItems o"),
    @NamedQuery(name = "OrderedItems.findByOrderedItemId", query = "SELECT o FROM OrderedItems o WHERE o.orderedItemId = :orderedItemId"),
    @NamedQuery(name = "OrderedItems.findByBookIdFk", query = "SELECT o FROM OrderedItems o WHERE o.bookIdFk = :bookIdFk"),
    @NamedQuery(name = "OrderedItems.findByQuantity", query = "SELECT o FROM OrderedItems o WHERE o.quantity = :quantity")})
public class OrderedItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ordered_item_id")
    private Integer orderedItemId;
    @Column(name = "book_id_fk")
    private Integer bookIdFk;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "order_id_fk", referencedColumnName = "order_id")
    @ManyToOne
    private Orders orderIdFk;

    public OrderedItems() {
    }

    public OrderedItems(Integer orderedItemId) {
        this.orderedItemId = orderedItemId;
    }

    public Integer getOrderedItemId() {
        return orderedItemId;
    }

    public void setOrderedItemId(Integer orderedItemId) {
        this.orderedItemId = orderedItemId;
    }

    public Integer getBookIdFk() {
        return bookIdFk;
    }

    public void setBookIdFk(Integer bookIdFk) {
        this.bookIdFk = bookIdFk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orders getOrderIdFk() {
        return orderIdFk;
    }

    public void setOrderIdFk(Orders orderIdFk) {
        this.orderIdFk = orderIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderedItemId != null ? orderedItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedItems)) {
            return false;
        }
        OrderedItems other = (OrderedItems) object;
        if ((this.orderedItemId == null && other.orderedItemId != null) || (this.orderedItemId != null && !this.orderedItemId.equals(other.orderedItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "we.codered.rokomari.entity.OrderedItems[ orderedItemId=" + orderedItemId + " ]";
    }
    
}
