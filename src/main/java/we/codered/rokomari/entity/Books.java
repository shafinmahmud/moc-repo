/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package we.codered.rokomari.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.stereotype.Component;

/**
 *
 * @author sss
 */
@Component
@Entity
@Table(name = "books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByBooksId", query = "SELECT b FROM Books b WHERE b.booksId = :booksId"),
    @NamedQuery(name = "Books.findByTitle", query = "SELECT b FROM Books b WHERE b.title = :title"),
    @NamedQuery(name = "Books.findByCategories", query = "SELECT b FROM Books b WHERE b.categories = :categories"),
    @NamedQuery(name = "Books.findByIsbn", query = "SELECT b FROM Books b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Books.findByEdition", query = "SELECT b FROM Books b WHERE b.edition = :edition"),
    @NamedQuery(name = "Books.findByNoOfPages", query = "SELECT b FROM Books b WHERE b.noOfPages = :noOfPages"),
    @NamedQuery(name = "Books.findByCountry", query = "SELECT b FROM Books b WHERE b.country = :country"),
    @NamedQuery(name = "Books.findByLanguage", query = "SELECT b FROM Books b WHERE b.language = :language"),
    @NamedQuery(name = "Books.findByPreviousPrice", query = "SELECT b FROM Books b WHERE b.previousPrice = :previousPrice"),
    @NamedQuery(name = "Books.findByCurrentPrice", query = "SELECT b FROM Books b WHERE b.currentPrice = :currentPrice"),
    @NamedQuery(name = "Books.findByAvailability", query = "SELECT b FROM Books b WHERE b.availability = :availability"),
    @NamedQuery(name = "Books.findByCreatedAt", query = "SELECT b FROM Books b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Books.findByUpdatedAt", query = "SELECT b FROM Books b WHERE b.updatedAt = :updatedAt"),
    @NamedQuery(name = "Books.findByImageUrl", query = "SELECT b FROM Books b WHERE b.imageUrl = :imageUrl"),
    @NamedQuery(name = "Books.findByBookSummary", query = "SELECT b FROM Books b WHERE b.bookSummary = :bookSummary")})
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "books_id")
    private Integer booksId;
    @Column(name = "title")
    private String title;
    @Column(name = "categories")
    private String categories;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "edition")
    private String edition;
    @Column(name = "no_of_pages")
    private Integer noOfPages;
    @Column(name = "country")
    private String country;
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
    @Column(name = "image_url")
    private String imageUrl;
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
    private List<Carts> cartsList;

    public Books() {
    }

    public Books(Integer booksId) {
        this.booksId = booksId;
    }

    public Books(Integer booksId, String isbn) {
        this.booksId = booksId;
        this.isbn = isbn;
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
    public List<Carts> getCartsList() {
        return cartsList;
    }

    public void setCartsList(List<Carts> cartsList) {
        this.cartsList = cartsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (booksId != null ? booksId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.booksId == null && other.booksId != null) || (this.booksId != null && !this.booksId.equals(other.booksId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "we.codered.rokomari.entity.Books[ booksId=" + booksId + " ]";
    }
    
}
