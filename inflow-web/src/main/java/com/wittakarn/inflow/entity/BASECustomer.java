/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "BASE_Customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASECustomer.findAll", query = "SELECT b FROM BASECustomer b"),
    @NamedQuery(name = "BASECustomer.findByCustomerId", query = "SELECT b FROM BASECustomer b WHERE b.customerId = :customerId"),
    @NamedQuery(name = "BASECustomer.findByVersion", query = "SELECT b FROM BASECustomer b WHERE b.version = :version"),
    @NamedQuery(name = "BASECustomer.findByName", query = "SELECT b FROM BASECustomer b WHERE b.name = :name"),
    @NamedQuery(name = "BASECustomer.findByVendorPermitNumber", query = "SELECT b FROM BASECustomer b WHERE b.vendorPermitNumber = :vendorPermitNumber"),
    @NamedQuery(name = "BASECustomer.findByRemarks", query = "SELECT b FROM BASECustomer b WHERE b.remarks = :remarks"),
    @NamedQuery(name = "BASECustomer.findByDiscount", query = "SELECT b FROM BASECustomer b WHERE b.discount = :discount"),
    @NamedQuery(name = "BASECustomer.findByDefaultCarrier", query = "SELECT b FROM BASECustomer b WHERE b.defaultCarrier = :defaultCarrier"),
    @NamedQuery(name = "BASECustomer.findByDefaultPaymentMethod", query = "SELECT b FROM BASECustomer b WHERE b.defaultPaymentMethod = :defaultPaymentMethod"),
    @NamedQuery(name = "BASECustomer.findByContactName", query = "SELECT b FROM BASECustomer b WHERE b.contactName = :contactName"),
    @NamedQuery(name = "BASECustomer.findByPhone", query = "SELECT b FROM BASECustomer b WHERE b.phone = :phone"),
    @NamedQuery(name = "BASECustomer.findByFax", query = "SELECT b FROM BASECustomer b WHERE b.fax = :fax"),
    @NamedQuery(name = "BASECustomer.findByEmail", query = "SELECT b FROM BASECustomer b WHERE b.email = :email"),
    @NamedQuery(name = "BASECustomer.findByAddress1", query = "SELECT b FROM BASECustomer b WHERE b.address1 = :address1"),
    @NamedQuery(name = "BASECustomer.findByAddress2", query = "SELECT b FROM BASECustomer b WHERE b.address2 = :address2"),
    @NamedQuery(name = "BASECustomer.findByCity", query = "SELECT b FROM BASECustomer b WHERE b.city = :city"),
    @NamedQuery(name = "BASECustomer.findByState", query = "SELECT b FROM BASECustomer b WHERE b.state = :state"),
    @NamedQuery(name = "BASECustomer.findByCountry", query = "SELECT b FROM BASECustomer b WHERE b.country = :country"),
    @NamedQuery(name = "BASECustomer.findByPostalCode", query = "SELECT b FROM BASECustomer b WHERE b.postalCode = :postalCode"),
    @NamedQuery(name = "BASECustomer.findByAddressRemarks", query = "SELECT b FROM BASECustomer b WHERE b.addressRemarks = :addressRemarks"),
    @NamedQuery(name = "BASECustomer.findByAddressType", query = "SELECT b FROM BASECustomer b WHERE b.addressType = :addressType"),
    @NamedQuery(name = "BASECustomer.findByUsingBillingAddress", query = "SELECT b FROM BASECustomer b WHERE b.usingBillingAddress = :usingBillingAddress"),
    @NamedQuery(name = "BASECustomer.findByBillingAddress1", query = "SELECT b FROM BASECustomer b WHERE b.billingAddress1 = :billingAddress1"),
    @NamedQuery(name = "BASECustomer.findByBillingAddress2", query = "SELECT b FROM BASECustomer b WHERE b.billingAddress2 = :billingAddress2"),
    @NamedQuery(name = "BASECustomer.findByBillingCity", query = "SELECT b FROM BASECustomer b WHERE b.billingCity = :billingCity"),
    @NamedQuery(name = "BASECustomer.findByBillingState", query = "SELECT b FROM BASECustomer b WHERE b.billingState = :billingState"),
    @NamedQuery(name = "BASECustomer.findByBillingCountry", query = "SELECT b FROM BASECustomer b WHERE b.billingCountry = :billingCountry"),
    @NamedQuery(name = "BASECustomer.findByBillingPostalCode", query = "SELECT b FROM BASECustomer b WHERE b.billingPostalCode = :billingPostalCode"),
    @NamedQuery(name = "BASECustomer.findByBillingAddressRemarks", query = "SELECT b FROM BASECustomer b WHERE b.billingAddressRemarks = :billingAddressRemarks"),
    @NamedQuery(name = "BASECustomer.findByBillingAddressType", query = "SELECT b FROM BASECustomer b WHERE b.billingAddressType = :billingAddressType"),
    @NamedQuery(name = "BASECustomer.findByUsingShippingAddress", query = "SELECT b FROM BASECustomer b WHERE b.usingShippingAddress = :usingShippingAddress"),
    @NamedQuery(name = "BASECustomer.findByShippingAddress1", query = "SELECT b FROM BASECustomer b WHERE b.shippingAddress1 = :shippingAddress1"),
    @NamedQuery(name = "BASECustomer.findByShippingAddress2", query = "SELECT b FROM BASECustomer b WHERE b.shippingAddress2 = :shippingAddress2"),
    @NamedQuery(name = "BASECustomer.findByShippingCity", query = "SELECT b FROM BASECustomer b WHERE b.shippingCity = :shippingCity"),
    @NamedQuery(name = "BASECustomer.findByShippingState", query = "SELECT b FROM BASECustomer b WHERE b.shippingState = :shippingState"),
    @NamedQuery(name = "BASECustomer.findByShippingCountry", query = "SELECT b FROM BASECustomer b WHERE b.shippingCountry = :shippingCountry"),
    @NamedQuery(name = "BASECustomer.findByShippingPostalCode", query = "SELECT b FROM BASECustomer b WHERE b.shippingPostalCode = :shippingPostalCode"),
    @NamedQuery(name = "BASECustomer.findByShippingAddressRemarks", query = "SELECT b FROM BASECustomer b WHERE b.shippingAddressRemarks = :shippingAddressRemarks"),
    @NamedQuery(name = "BASECustomer.findByShippingAddressType", query = "SELECT b FROM BASECustomer b WHERE b.shippingAddressType = :shippingAddressType"),
    @NamedQuery(name = "BASECustomer.findByCustom1", query = "SELECT b FROM BASECustomer b WHERE b.custom1 = :custom1"),
    @NamedQuery(name = "BASECustomer.findByCustom2", query = "SELECT b FROM BASECustomer b WHERE b.custom2 = :custom2"),
    @NamedQuery(name = "BASECustomer.findByCustom3", query = "SELECT b FROM BASECustomer b WHERE b.custom3 = :custom3"),
    @NamedQuery(name = "BASECustomer.findByCustom4", query = "SELECT b FROM BASECustomer b WHERE b.custom4 = :custom4"),
    @NamedQuery(name = "BASECustomer.findByCustom5", query = "SELECT b FROM BASECustomer b WHERE b.custom5 = :custom5"),
    @NamedQuery(name = "BASECustomer.findByCCardType", query = "SELECT b FROM BASECustomer b WHERE b.cCardType = :cCardType"),
    @NamedQuery(name = "BASECustomer.findByCCardNum", query = "SELECT b FROM BASECustomer b WHERE b.cCardNum = :cCardNum"),
    @NamedQuery(name = "BASECustomer.findByCCardSecurityNum", query = "SELECT b FROM BASECustomer b WHERE b.cCardSecurityNum = :cCardSecurityNum"),
    @NamedQuery(name = "BASECustomer.findByCCardExpDate", query = "SELECT b FROM BASECustomer b WHERE b.cCardExpDate = :cCardExpDate"),
    @NamedQuery(name = "BASECustomer.findByLastModDttm", query = "SELECT b FROM BASECustomer b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASECustomer.findByIsActive", query = "SELECT b FROM BASECustomer b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BASECustomer.findByCustom6", query = "SELECT b FROM BASECustomer b WHERE b.custom6 = :custom6"),
    @NamedQuery(name = "BASECustomer.findByCustom7", query = "SELECT b FROM BASECustomer b WHERE b.custom7 = :custom7"),
    @NamedQuery(name = "BASECustomer.findByCustom8", query = "SELECT b FROM BASECustomer b WHERE b.custom8 = :custom8"),
    @NamedQuery(name = "BASECustomer.findByCustom9", query = "SELECT b FROM BASECustomer b WHERE b.custom9 = :custom9"),
    @NamedQuery(name = "BASECustomer.findByCustom10", query = "SELECT b FROM BASECustomer b WHERE b.custom10 = :custom10"),
    @NamedQuery(name = "BASECustomer.findByWebsite", query = "SELECT b FROM BASECustomer b WHERE b.website = :website"),
    @NamedQuery(name = "BASECustomer.findByDefaultSalesRep", query = "SELECT b FROM BASECustomer b WHERE b.defaultSalesRep = :defaultSalesRep")})
public class BASECustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VendorPermitNumber")
    private String vendorPermitNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Remarks")
    private String remarks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount")
    private BigDecimal discount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DefaultCarrier")
    private String defaultCarrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DefaultPaymentMethod")
    private String defaultPaymentMethod;
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
    @Column(name = "UsingBillingAddress")
    private boolean usingBillingAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BillingAddress1")
    private String billingAddress1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BillingAddress2")
    private String billingAddress2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BillingCity")
    private String billingCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BillingState")
    private String billingState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BillingCountry")
    private String billingCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BillingPostalCode")
    private String billingPostalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "BillingAddressRemarks")
    private String billingAddressRemarks;
    @Column(name = "BillingAddressType")
    private Integer billingAddressType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsingShippingAddress")
    private boolean usingShippingAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShippingAddress1")
    private String shippingAddress1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShippingAddress2")
    private String shippingAddress2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShippingCity")
    private String shippingCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ShippingState")
    private String shippingState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShippingCountry")
    private String shippingCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ShippingPostalCode")
    private String shippingPostalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ShippingAddressRemarks")
    private String shippingAddressRemarks;
    @Column(name = "ShippingAddressType")
    private Integer shippingAddressType;
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
    @Column(name = "CCardType")
    private Integer cCardType;
    @Size(max = 25)
    @Column(name = "CCardNum")
    private String cCardNum;
    @Size(max = 5)
    @Column(name = "CCardSecurityNum")
    private String cCardSecurityNum;
    @Size(max = 10)
    @Column(name = "CCardExpDate")
    private String cCardExpDate;
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
    @Size(max = 2147483647)
    @Column(name = "DefaultSalesRep")
    private String defaultSalesRep;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @JoinColumn(name = "DefaultPricingSchemeId", referencedColumnName = "PricingSchemeId")
    @ManyToOne
    private BASEPricingScheme defaultPricingSchemeId;
    @JoinColumn(name = "DefaultPaymentTermsId", referencedColumnName = "PaymentTermsId")
    @ManyToOne
    private BASEPaymentTerms defaultPaymentTermsId;
    @JoinColumn(name = "DefaultOrderTaxCodeId", referencedColumnName = "OrderTaxCodeId")
    @ManyToOne
    private BASEOrderTaxCode defaultOrderTaxCodeId;
    @JoinColumn(name = "DefaultLocationId", referencedColumnName = "LocationId")
    @ManyToOne
    private BASELocation defaultLocationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<SOSalesOrder> sOSalesOrderList;

    public BASECustomer() {
    }

    public BASECustomer(Integer customerId) {
        this.customerId = customerId;
    }

    public BASECustomer(Integer customerId, int version, String name, String vendorPermitNumber, String remarks, BigDecimal discount, String defaultCarrier, String defaultPaymentMethod, String contactName, String phone, String fax, String email, String address1, String address2, String city, String state, String country, String postalCode, String addressRemarks, boolean usingBillingAddress, String billingAddress1, String billingAddress2, String billingCity, String billingState, String billingCountry, String billingPostalCode, String billingAddressRemarks, boolean usingShippingAddress, String shippingAddress1, String shippingAddress2, String shippingCity, String shippingState, String shippingCountry, String shippingPostalCode, String shippingAddressRemarks, String custom1, String custom2, String custom3, String custom4, String custom5, Date lastModDttm, byte[] timestamp, boolean isActive, String custom6, String custom7, String custom8, String custom9, String custom10, String website) {
        this.customerId = customerId;
        this.version = version;
        this.name = name;
        this.vendorPermitNumber = vendorPermitNumber;
        this.remarks = remarks;
        this.discount = discount;
        this.defaultCarrier = defaultCarrier;
        this.defaultPaymentMethod = defaultPaymentMethod;
        this.contactName = contactName;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.addressRemarks = addressRemarks;
        this.usingBillingAddress = usingBillingAddress;
        this.billingAddress1 = billingAddress1;
        this.billingAddress2 = billingAddress2;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.billingAddressRemarks = billingAddressRemarks;
        this.usingShippingAddress = usingShippingAddress;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingCountry = shippingCountry;
        this.shippingPostalCode = shippingPostalCode;
        this.shippingAddressRemarks = shippingAddressRemarks;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getVendorPermitNumber() {
        return vendorPermitNumber;
    }

    public void setVendorPermitNumber(String vendorPermitNumber) {
        this.vendorPermitNumber = vendorPermitNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDefaultCarrier() {
        return defaultCarrier;
    }

    public void setDefaultCarrier(String defaultCarrier) {
        this.defaultCarrier = defaultCarrier;
    }

    public String getDefaultPaymentMethod() {
        return defaultPaymentMethod;
    }

    public void setDefaultPaymentMethod(String defaultPaymentMethod) {
        this.defaultPaymentMethod = defaultPaymentMethod;
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

    public boolean getUsingBillingAddress() {
        return usingBillingAddress;
    }

    public void setUsingBillingAddress(boolean usingBillingAddress) {
        this.usingBillingAddress = usingBillingAddress;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingAddressRemarks() {
        return billingAddressRemarks;
    }

    public void setBillingAddressRemarks(String billingAddressRemarks) {
        this.billingAddressRemarks = billingAddressRemarks;
    }

    public Integer getBillingAddressType() {
        return billingAddressType;
    }

    public void setBillingAddressType(Integer billingAddressType) {
        this.billingAddressType = billingAddressType;
    }

    public boolean getUsingShippingAddress() {
        return usingShippingAddress;
    }

    public void setUsingShippingAddress(boolean usingShippingAddress) {
        this.usingShippingAddress = usingShippingAddress;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingAddressRemarks() {
        return shippingAddressRemarks;
    }

    public void setShippingAddressRemarks(String shippingAddressRemarks) {
        this.shippingAddressRemarks = shippingAddressRemarks;
    }

    public Integer getShippingAddressType() {
        return shippingAddressType;
    }

    public void setShippingAddressType(Integer shippingAddressType) {
        this.shippingAddressType = shippingAddressType;
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

    public Integer getCCardType() {
        return cCardType;
    }

    public void setCCardType(Integer cCardType) {
        this.cCardType = cCardType;
    }

    public String getCCardNum() {
        return cCardNum;
    }

    public void setCCardNum(String cCardNum) {
        this.cCardNum = cCardNum;
    }

    public String getCCardSecurityNum() {
        return cCardSecurityNum;
    }

    public void setCCardSecurityNum(String cCardSecurityNum) {
        this.cCardSecurityNum = cCardSecurityNum;
    }

    public String getCCardExpDate() {
        return cCardExpDate;
    }

    public void setCCardExpDate(String cCardExpDate) {
        this.cCardExpDate = cCardExpDate;
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

    public String getDefaultSalesRep() {
        return defaultSalesRep;
    }

    public void setDefaultSalesRep(String defaultSalesRep) {
        this.defaultSalesRep = defaultSalesRep;
    }

    public BASEUser getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(BASEUser lastModUserId) {
        this.lastModUserId = lastModUserId;
    }

    public BASEPricingScheme getDefaultPricingSchemeId() {
        return defaultPricingSchemeId;
    }

    public void setDefaultPricingSchemeId(BASEPricingScheme defaultPricingSchemeId) {
        this.defaultPricingSchemeId = defaultPricingSchemeId;
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

    public BASELocation getDefaultLocationId() {
        return defaultLocationId;
    }

    public void setDefaultLocationId(BASELocation defaultLocationId) {
        this.defaultLocationId = defaultLocationId;
    }

    @XmlTransient
    public List<SOSalesOrder> getSOSalesOrderList() {
        return sOSalesOrderList;
    }

    public void setSOSalesOrderList(List<SOSalesOrder> sOSalesOrderList) {
        this.sOSalesOrderList = sOSalesOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASECustomer)) {
            return false;
        }
        BASECustomer other = (BASECustomer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASECustomer[ customerId=" + customerId + " ]";
    }
    
}
