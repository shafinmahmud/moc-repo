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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "user_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u"),
    @NamedQuery(name = "UserProfile.findByUserProfileId", query = "SELECT u FROM UserProfile u WHERE u.userProfileId = :userProfileId"),
    @NamedQuery(name = "UserProfile.findByFirstName", query = "SELECT u FROM UserProfile u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserProfile.findByLastName", query = "SELECT u FROM UserProfile u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserProfile.findByContact", query = "SELECT u FROM UserProfile u WHERE u.contact = :contact"),
    @NamedQuery(name = "UserProfile.findByAddress", query = "SELECT u FROM UserProfile u WHERE u.address = :address"),
    @NamedQuery(name = "UserProfile.findByUserPhotoUrl", query = "SELECT u FROM UserProfile u WHERE u.userPhotoUrl = :userPhotoUrl")})
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_profile_id")
    private Integer userProfileId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "contact")
    private String contact;
    @Column(name = "address")
    private String address;
    @Column(name = "user_photo_url")
    private String userPhotoUrl;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User userIdFk;

    public UserProfile() {
    }

    public UserProfile(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public User getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(User userIdFk) {
        this.userIdFk = userIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userProfileId != null ? userProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.userProfileId == null && other.userProfileId != null) || (this.userProfileId != null && !this.userProfileId.equals(other.userProfileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "we.codered.rokomari.entity.UserProfile[ userProfileId=" + userProfileId + " ]";
    }
    
}
