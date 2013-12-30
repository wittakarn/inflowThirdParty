/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.summitthai.inflow.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wittakarn
 */
@Entity
@Table(name = "BASE_Vendor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEVendor.findAll", query = "SELECT b FROM BASEVendor b"),
    @NamedQuery(name = "BASEVendor.findByVendorId", query = "SELECT b FROM BASEVendor b WHERE b.vendorId = :vendorId"),
    @NamedQuery(name = "BASEVendor.findByVersion", query = "SELECT b FROM BASEVendor b WHERE b.version = :version"),
    @NamedQuery(name = "BASEVendor.findByName", query = "SELECT b FROM BASEVendor b WHERE b.name = :name"),
    @NamedQuery(name = "BASEVendor.findByRemarks", query = "SELECT b FROM BASEVendor b WHERE b.remarks = :remarks"),
    @NamedQuery(name = "BASEVendor.findByDefaultCarrier", query = "SELECT b FROM BASEVendor b WHERE b.defaultCarrier = :defaultCarrier"),
    @NamedQuery(name = "BASEVendor.findByAddress1", query = "SELECT b FROM BASEVendor b WHERE b.address1 = :address1"),
    @NamedQuery(name = "BASEVendor.findByAddress2", query = "SELECT b FROM BASEVendor b WHERE b.address2 = :address2"),
    @NamedQuery(name = "BASEVendor.findByCity", query = "SELECT b FROM BASEVendor b WHERE b.city = :city"),
    @NamedQuery(name = "BASEVendor.findByState", query = "SELECT b FROM BASEVendor b WHERE b.state = :state"),
    @NamedQuery(name = "BASEVendor.findByCountry", query = "SELECT b FROM BASEVendor b WHERE b.country = :country"),
    @NamedQuery(name = "BASEVendor.findByPostalCode", query = "SELECT b FROM BASEVendor b WHERE b.postalCode = :postalCode"),
    @NamedQuery(name = "BASEVendor.findByAddressRemarks", query = "SELECT b FROM BASEVendor b WHERE b.addressRemarks = :addressRemarks"),
    @NamedQuery(name = "BASEVendor.findByAddressType", query = "SELECT b FROM BASEVendor b WHERE b.addressType = :addressType"),
    @NamedQuery(name = "BASEVendor.findByContactName", query = "SELECT b FROM BASEVendor b WHERE b.contactName = :contactName"),
    @NamedQuery(name = "BASEVendor.findByPhone", query = "SELECT b FROM BASEVendor b WHERE b.phone = :phone"),
    @NamedQuery(name = "BASEVendor.findByFax", query = "SELECT b FROM BASEVendor b WHERE b.fax = :fax"),
    @NamedQuery(name = "BASEVendor.findByEmail", query = "SELECT b FROM BASEVendor b WHERE b.email = :email"),
    @NamedQuery(name = "BASEVendor.findByCustom1", query = "SELECT b FROM BASEVendor b WHERE b.custom1 = :custom1"),
    @NamedQuery(name = "BASEVendor.findByCustom2", query = "SELECT b FROM BASEVendor b WHERE b.custom2 = :custom2"),
    @NamedQuery(name = "BASEVendor.findByCustom3", query = "SELECT b FROM BASEVendor b WHERE b.custom3 = :custom3"),
    @NamedQuery(name = "BASEVendor.findByCustom4", query = "SELECT b FROM BASEVendor b WHERE b.custom4 = :custom4"),
    @NamedQuery(name = "BASEVendor.findByCustom5", query = "SELECT b FROM BASEVendor b WHERE b.custom5 = :custom5"),
    @NamedQuery(name = "BASEVendor.findByLastModDttm", query = "SELECT b FROM BASEVendor b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASEVendor.findByIsActive", query = "SELECT b FROM BASEVendor b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BASEVendor.findByCustom6", query = "SELECT b FROM BASEVendor b WHERE b.custom6 = :custom6"),
    @NamedQuery(name = "BASEVendor.findByCustom7", query = "SELECT b FROM BASEVendor b WHERE b.custom7 = :custom7"),
    @NamedQuery(name = "BASEVendor.findByCustom8", query = "SELECT b FROM BASEVendor b WHERE b.custom8 = :custom8"),
    @NamedQuery(name = "BASEVendor.findByCustom9", query = "SELECT b FROM BASEVendor b WHERE b.custom9 = :custom9"),
    @NamedQuery(name = "BASEVendor.findByCustom10", query = "SELECT b FROM BASEVendor b WHERE b.custom10 = :custom10"),
    @NamedQuery(name = "BASEVendor.findByWebsite", query = "SELECT b FROM BASEVendor b WHERE b.website = :website")})
public class BASEVendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VendorId")
    private Integer vendorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DefaultCarrier")
    private String defaultCarrier;
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
    @Size(min = 1, max = 20)
    @Column(name = "PostalCode")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "AddressRemarks")
    private String addressRemarks;
    @Column(name = "AddressType")
    private Integer addressType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ContactName")
    private String contactName;
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
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom1")
    private String custom1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom2")
    private String custom2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom3")
    private String custom3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom4")
    private String custom4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom5")
    private String custom5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastModDttm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDttm;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom6")
    private String custom6;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom7")
    private String custom7;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom8")
    private String custom8;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom9")
    private String custom9;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Custom10")
    private String custom10;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Website")
    private String website;
    @JoinColumn(name = "CurrencyId", referencedColumnName = "CurrencyId")
    @ManyToOne(optional = false)
    private GLOBALCurrency currencyId;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @JoinColumn(name = "DefaultPaymentTermsId", referencedColumnName = "PaymentTermsId")
    @ManyToOne
    private BASEPaymentTerms defaultPaymentTermsId;
    @JoinColumn(name = "DefaultOrderTaxCodeId", referencedColumnName = "OrderTaxCodeId")
    @ManyToOne
    private BASEOrderTaxCode defaultOrderTaxCodeId;
    @OneToMany(mappedBy = "lastVendorId")
    private List<BASEProduct> bASEProductList;

    public BASEVendor() {
    }

    public BASEVendor(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public BASEVendor(Integer vendorId, int version, String name, String remarks, String defaultCarrier, String address1, String address2, String city, String state, String country, String postalCode, String addressRemarks, String contactName, String phone, String fax, String email, String custom1, String custom2, String custom3, String custom4, String custom5, Date lastModDttm, byte[] timestamp, boolean isActive, String custom6, String custom7, String custom8, String custom9, String custom10, String website) {
        this.vendorId = vendorId;
        this.version = version;
        this.name = name;
        this.remarks = remarks;
        this.defaultCarrier = defaultCarrier;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.addressRemarks = addressRemarks;
        this.contactName = contactName;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
        this.custom4 = custom4;
        this.custom5 = custom5;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.isActive = isActive;
        this.custom6 = custom6;
        this.custom7 = custom7;
        this.custom8 = custom8;
        this.custom9 = custom9;
        this.custom10 = custom10;
        this.website = website;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDefaultCarrier() {
        return defaultCarrier;
    }

    public void setDefaultCarrier(String defaultCarrier) {
        this.defaultCarrier = defaultCarrier;
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

    public String getAddressRemarks() {
        return addressRemarks;
    }

    public void setAddressRemarks(String addressRemarks) {
        this.addressRemarks = addressRemarks;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public Date getLastModDttm() {
        return lastModDttm;
    }

    public void setLastModDttm(Date lastModDttm) {
        this.lastModDttm = lastModDttm;
    }

    public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCustom6() {
        return custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public String getCustom7() {
        return custom7;
    }

    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }

    public String getCustom8() {
        return custom8;
    }

    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }

    public String getCustom9() {
        return custom9;
    }

    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }

    public String getCustom10() {
        return custom10;
    }

    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public GLOBALCurrency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(GLOBALCurrency currencyId) {
        this.currencyId = currencyId;
    }

    public BASEUser getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(BASEUser lastModUserId) {
        this.lastModUserId = lastModUserId;
    }

    public BASEPaymentTerms getDefaultPaymentTermsId() {
        return defaultPaymentTermsId;
    }

    public void setDefaultPaymentTermsId(BASEPaymentTerms defaultPaymentTermsId) {
        this.defaultPaymentTermsId = defaultPaymentTermsId;
    }

    public BASEOrderTaxCode getDefaultOrderTaxCodeId() {
        return defaultOrderTaxCodeId;
    }

    public void setDefaultOrderTaxCodeId(BASEOrderTaxCode defaultOrderTaxCodeId) {
        this.defaultOrderTaxCodeId = defaultOrderTaxCodeId;
    }

    @XmlTransient
    public List<BASEProduct> getBASEProductList() {
        return bASEProductList;
    }

    public void setBASEProductList(List<BASEProduct> bASEProductList) {
        this.bASEProductList = bASEProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEVendor)) {
            return false;
        }
        BASEVendor other = (BASEVendor) object;
        if ((this.vendorId == null && other.vendorId != null) || (this.vendorId != null && !this.vendorId.equals(other.vendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEVendor[ vendorId=" + vendorId + " ]";
    }
    
}
