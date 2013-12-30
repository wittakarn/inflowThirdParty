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
@Table(name = "BASE_PricingScheme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEPricingScheme.findAll", query = "SELECT b FROM BASEPricingScheme b"),
    @NamedQuery(name = "BASEPricingScheme.findByPricingSchemeId", query = "SELECT b FROM BASEPricingScheme b WHERE b.pricingSchemeId = :pricingSchemeId"),
    @NamedQuery(name = "BASEPricingScheme.findByName", query = "SELECT b FROM BASEPricingScheme b WHERE b.name = :name"),
    @NamedQuery(name = "BASEPricingScheme.findByLastModDttm", query = "SELECT b FROM BASEPricingScheme b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASEPricingScheme.findByIsActive", query = "SELECT b FROM BASEPricingScheme b WHERE b.isActive = :isActive")})
public class BASEPricingScheme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PricingSchemeId")
    private Integer pricingSchemeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
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
    @JoinColumn(name = "CurrencyId", referencedColumnName = "CurrencyId")
    @ManyToOne(optional = false)
    private GLOBALCurrency currencyId;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @OneToMany(mappedBy = "defaultPricingSchemeId")
    private List<BASECustomer> bASECustomerList;
    @OneToMany(mappedBy = "pricingSchemeId")
    private List<SOSalesOrder> sOSalesOrderList;

    public BASEPricingScheme() {
    }

    public BASEPricingScheme(Integer pricingSchemeId) {
        this.pricingSchemeId = pricingSchemeId;
    }

    public BASEPricingScheme(Integer pricingSchemeId, String name, Date lastModDttm, byte[] timestamp, boolean isActive) {
        this.pricingSchemeId = pricingSchemeId;
        this.name = name;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.isActive = isActive;
    }

    public Integer getPricingSchemeId() {
        return pricingSchemeId;
    }

    public void setPricingSchemeId(Integer pricingSchemeId) {
        this.pricingSchemeId = pricingSchemeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public List<BASECustomer> getBASECustomerList() {
        return bASECustomerList;
    }

    public void setBASECustomerList(List<BASECustomer> bASECustomerList) {
        this.bASECustomerList = bASECustomerList;
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
        hash += (pricingSchemeId != null ? pricingSchemeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEPricingScheme)) {
            return false;
        }
        BASEPricingScheme other = (BASEPricingScheme) object;
        if ((this.pricingSchemeId == null && other.pricingSchemeId != null) || (this.pricingSchemeId != null && !this.pricingSchemeId.equals(other.pricingSchemeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEPricingScheme[ pricingSchemeId=" + pricingSchemeId + " ]";
    }
    
}
