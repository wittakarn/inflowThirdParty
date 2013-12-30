/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wittakarn
 */
@Entity
@Table(name = "BASE_Company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASECompany.findAll", query = "SELECT b FROM BASECompany b"),
    @NamedQuery(name = "BASECompany.findByCompanyId", query = "SELECT b FROM BASECompany b WHERE b.companyId = :companyId"),
    @NamedQuery(name = "BASECompany.findByName", query = "SELECT b FROM BASECompany b WHERE b.name = :name"),
    @NamedQuery(name = "BASECompany.findByPhone", query = "SELECT b FROM BASECompany b WHERE b.phone = :phone"),
    @NamedQuery(name = "BASECompany.findByFax", query = "SELECT b FROM BASECompany b WHERE b.fax = :fax"),
    @NamedQuery(name = "BASECompany.findByEmail", query = "SELECT b FROM BASECompany b WHERE b.email = :email"),
    @NamedQuery(name = "BASECompany.findByWebsite", query = "SELECT b FROM BASECompany b WHERE b.website = :website"),
    @NamedQuery(name = "BASECompany.findByAddress1", query = "SELECT b FROM BASECompany b WHERE b.address1 = :address1"),
    @NamedQuery(name = "BASECompany.findByAddress2", query = "SELECT b FROM BASECompany b WHERE b.address2 = :address2"),
    @NamedQuery(name = "BASECompany.findByCity", query = "SELECT b FROM BASECompany b WHERE b.city = :city"),
    @NamedQuery(name = "BASECompany.findByState", query = "SELECT b FROM BASECompany b WHERE b.state = :state"),
    @NamedQuery(name = "BASECompany.findByCountry", query = "SELECT b FROM BASECompany b WHERE b.country = :country"),
    @NamedQuery(name = "BASECompany.findByPostalCode", query = "SELECT b FROM BASECompany b WHERE b.postalCode = :postalCode"),
    @NamedQuery(name = "BASECompany.findByTaxNumber", query = "SELECT b FROM BASECompany b WHERE b.taxNumber = :taxNumber")})
public class BASECompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CompanyId")
    private Integer companyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Address2")
    private String address2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PostalCode")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TaxNumber")
    private String taxNumber;
    @JoinColumn(name = "PictureFileAttachmentId", referencedColumnName = "FileAttachmentId")
    @ManyToOne
    private BASEFileAttachment pictureFileAttachmentId;

    public BASECompany() {
    }

    public BASECompany(Integer companyId) {
        this.companyId = companyId;
    }

    public BASECompany(Integer companyId, String name, String phone, String fax, String email, String website, String address1, String address2, String city, String state, String country, String postalCode, byte[] timestamp, String taxNumber) {
        this.companyId = companyId;
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.website = website;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.timestamp = timestamp;
        this.taxNumber = taxNumber;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public BASEFileAttachment getPictureFileAttachmentId() {
        return pictureFileAttachmentId;
    }

    public void setPictureFileAttachmentId(BASEFileAttachment pictureFileAttachmentId) {
        this.pictureFileAttachmentId = pictureFileAttachmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASECompany)) {
            return false;
        }
        BASECompany other = (BASECompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASECompany[ companyId=" + companyId + " ]";
    }
    
}
