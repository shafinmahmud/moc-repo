/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package we.codered.rokomari.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */
@Entity
@Table(name = "carts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carts.findAll", query = "SELECT c FROM Carts c"),
    @NamedQuery(name = "Carts.findByCartId", query = "SELECT c FROM Carts c WHERE c.cartId = :cartId"),
    @NamedQuery(name = "Carts.findByQuantity", query = "SELECT c FROM Carts c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "Carts.findByCreatedAt", query = "SELECT c FROM Carts c WHERE c.createdAt = :createdAt")})
public class Carts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cart_id")
    private Integer cartId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "book_id_fk", referencedColumnName = "books_id")
    @ManyToOne
    private Books bookIdFk;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private Users userIdFk;

    public Carts() {
    }

    public Carts(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Books getBookIdFk() {
        return bookIdFk;
    }

    public void setBookIdFk(Books bookIdFk) {
        this.bookIdFk = bookIdFk;
    }

    public Users getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(Users userIdFk) {
        this.userIdFk = userIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carts)) {
            return false;
        }
        Carts other = (Carts) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "we.codered.rokomari.entity.Carts[ cartId=" + cartId + " ]";
    }
    
}
