/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package we.codered.rokomari.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SHAFIN
 */
@Entity
@Table(name = "books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BooksPK booksPK;
    @Size(max = 500)
    @Column(name = "title")
    private String title;
    @Size(max = 2000)
    @Column(name = "categories")
    private String categories;
    @Size(max = 100)
    @Column(name = "edition")
    private String edition;
    @Column(name = "no_of_pages")
    private Integer noOfPages;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "language")
    private String language;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "previous_price")
    private Double previousPrice;
    @Column(name = "current_price")
    private Double currentPrice;
    @Column(name = "availability")
    private Boolean availability;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 500)
    @Column(name = "image_url")
    private String imageUrl;
    @Lob
    @Size(max = 65535)
    @Column(name = "book_summary")
    private String bookSummary;
    @JoinColumn(name = "author_id_fk", referencedColumnName = "author_id")
    @ManyToOne
    private Authors authorIdFk;
    @JoinColumn(name = "publisher_id_fk", referencedColumnName = "publisher_id")
    @ManyToOne
    private Publishers publisherIdFk;
    @JoinColumn(name = "subject_id_fk", referencedColumnName = "subject_id")
    @ManyToOne
    private Subjects subjectIdFk;
    @OneToMany(mappedBy = "bookIdFk")
    private Collection<Carts> cartsCollection;

    public Books() {
    }

    public Books(BooksPK booksPK) {
        this.booksPK = booksPK;
    }

    public Books(int booksId, String isbn) {
        this.booksPK = new BooksPK(booksId, isbn);
    }

    public BooksPK getBooksPK() {
        return booksPK;
    }

    public void setBooksPK(BooksPK booksPK) {
        this.booksPK = booksPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(Double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public Authors getAuthorIdFk() {
        return authorIdFk;
    }

    public void setAuthorIdFk(Authors authorIdFk) {
        this.authorIdFk = authorIdFk;
    }

    public Publishers getPublisherIdFk() {
        return publisherIdFk;
    }

    public void setPublisherIdFk(Publishers publisherIdFk) {
        this.publisherIdFk = publisherIdFk;
    }

    public Subjects getSubjectIdFk() {
        return subjectIdFk;
    }

    public void setSubjectIdFk(Subjects subjectIdFk) {
        this.subjectIdFk = subjectIdFk;
    }

    @XmlTransient
    public Collection<Carts> getCartsCollection() {
        return cartsCollection;
    }

    public void setCartsCollection(Collection<Carts> cartsCollection) {
        this.cartsCollection = cartsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (booksPK != null ? booksPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.booksPK == null && other.booksPK != null) || (this.booksPK != null && !this.booksPK.equals(other.booksPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "we.codered.rokomari.entity.Books[ booksPK=" + booksPK + " ]";
    }
    
}
