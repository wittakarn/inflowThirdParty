/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wittakarn
 */
@Entity
@Table(name = "BASE_User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEUser.findAll", query = "SELECT b FROM BASEUser b"),
    @NamedQuery(name = "BASEUser.findByUserId", query = "SELECT b FROM BASEUser b WHERE b.userId = :userId"),
    @NamedQuery(name = "BASEUser.findByName", query = "SELECT b FROM BASEUser b WHERE b.name = :name"),
    @NamedQuery(name = "BASEUser.findByIsAdministrator", query = "SELECT b FROM BASEUser b WHERE b.isAdministrator = :isAdministrator"),
    @NamedQuery(name = "BASEUser.findByIsActive", query = "SELECT b FROM BASEUser b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BASEUser.findByLocationId", query = "SELECT b FROM BASEUser b WHERE b.locationId = :locationId"),
    @NamedQuery(name = "BASEUser.findByDefaultSalesRep", query = "SELECT b FROM BASEUser b WHERE b.defaultSalesRep = :defaultSalesRep")})
public class BASEUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "PasswordHash")
    private byte[] passwordHash;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "PasswordSalt")
    private byte[] passwordSalt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsAdministrator")
    private boolean isAdministrator;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "LocationId")
    private Integer locationId;
    @Size(max = 2147483647)
    @Column(name = "DefaultSalesRep")
    private String defaultSalesRep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASEPricingScheme> bASEPricingSchemeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASECustomer> bASECustomerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdUserId")
    private List<BASEInventoryLogBatch> bASEInventoryLogBatchList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASEFileAttachment> bASEFileAttachmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASELocation> bASELocationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASEItemTaxCode> bASEItemTaxCodeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASEVendor> bASEVendorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<SOSalesOrder> sOSalesOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastModUserId")
    private List<BASEProduct> bASEProductList;

    public BASEUser() {
    }

    public BASEUser(Integer userId) {
        this.userId = userId;
    }

    public BASEUser(Integer userId, String name, byte[] passwordHash, byte[] passwordSalt, boolean isAdministrator, byte[] timestamp, boolean isActive) {
        this.userId = userId;
        this.name = name;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.isAdministrator = isAdministrator;
        this.timestamp = timestamp;
        this.isActive = isActive;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public boolean getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDefaultSalesRep() {
        return defaultSalesRep;
    }

    public void setDefaultSalesRep(String defaultSalesRep) {
        this.defaultSalesRep = defaultSalesRep;
    }

    @XmlTransient
    public List<BASEPricingScheme> getBASEPricingSchemeList() {
        return bASEPricingSchemeList;
    }

    public void setBASEPricingSchemeList(List<BASEPricingScheme> bASEPricingSchemeList) {
        this.bASEPricingSchemeList = bASEPricingSchemeList;
    }

    @XmlTransient
    public List<BASECustomer> getBASECustomerList() {
        return bASECustomerList;
    }

    public void setBASECustomerList(List<BASECustomer> bASECustomerList) {
        this.bASECustomerList = bASECustomerList;
    }

    @XmlTransient
    public List<BASEInventoryLogBatch> getBASEInventoryLogBatchList() {
        return bASEInventoryLogBatchList;
    }

    public void setBASEInventoryLogBatchList(List<BASEInventoryLogBatch> bASEInventoryLogBatchList) {
        this.bASEInventoryLogBatchList = bASEInventoryLogBatchList;
    }

    @XmlTransient
    public List<BASEFileAttachment> getBASEFileAttachmentList() {
        return bASEFileAttachmentList;
    }

    public void setBASEFileAttachmentList(List<BASEFileAttachment> bASEFileAttachmentList) {
        this.bASEFileAttachmentList = bASEFileAttachmentList;
    }

    @XmlTransient
    public List<BASELocation> getBASELocationList() {
        return bASELocationList;
    }

    public void setBASELocationList(List<BASELocation> bASELocationList) {
        this.bASELocationList = bASELocationList;
    }

    @XmlTransient
    public List<BASEItemTaxCode> getBASEItemTaxCodeList() {
        return bASEItemTaxCodeList;
    }

    public void setBASEItemTaxCodeList(List<BASEItemTaxCode> bASEItemTaxCodeList) {
        this.bASEItemTaxCodeList = bASEItemTaxCodeList;
    }

    @XmlTransient
    public List<BASEVendor> getBASEVendorList() {
        return bASEVendorList;
    }

    public void setBASEVendorList(List<BASEVendor> bASEVendorList) {
        this.bASEVendorList = bASEVendorList;
    }

    @XmlTransient
    public List<SOSalesOrder> getSOSalesOrderList() {
        return sOSalesOrderList;
    }

    public void setSOSalesOrderList(List<SOSalesOrder> sOSalesOrderList) {
        this.sOSalesOrderList = sOSalesOrderList;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEUser)) {
            return false;
        }
        BASEUser other = (BASEUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEUser[ userId=" + userId + " ]";
    }
    
}
