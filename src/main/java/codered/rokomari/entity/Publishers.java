/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codered.rokomari.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sss
 */
@Entity
@Table(name = "publishers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publishers.findAll", query = "SELECT p FROM Publishers p"),
    @NamedQuery(name = "Publishers.findByPublisherId", query = "SELECT p FROM Publishers p WHERE p.publisherId = :publisherId"),
    @NamedQuery(name = "Publishers.findByPublisherName", query = "SELECT p FROM Publishers p WHERE p.publisherName = :publisherName"),
    @NamedQuery(name = "Publishers.findByPublisherAddress", query = "SELECT p FROM Publishers p WHERE p.publisherAddress = :publisherAddress")})
public class Publishers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Basic(optional = false)
    @Column(name = "publisher_name")
    private String publisherName;
    @Column(name = "publisher_address")
    private String publisherAddress;
    @OneToMany(mappedBy = "publisherIdFk")
    private List<Books> booksList;

    public Publishers() {
    }

    public Publishers(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Publishers(Integer publisherId, String publisherName) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    @XmlTransient
    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publisherId != null ? publisherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publishers)) {
            return false;
        }
        Publishers other = (Publishers) object;
        if ((this.publisherId == null && other.publisherId != null) || (this.publisherId != null && !this.publisherId.equals(other.publisherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "we.codered.rokomari.entity.Publishers[ publisherId=" + publisherId + " ]";
    }
    
}
