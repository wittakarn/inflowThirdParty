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
import javax.persistence.Lob;
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
@Table(name = "BASE_OrderTaxCode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEOrderTaxCode.findAll", query = "SELECT b FROM BASEOrderTaxCode b"),
    @NamedQuery(name = "BASEOrderTaxCode.findByOrderTaxCodeId", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.orderTaxCodeId = :orderTaxCodeId"),
    @NamedQuery(name = "BASEOrderTaxCode.findByName", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.name = :name"),
    @NamedQuery(name = "BASEOrderTaxCode.findByTax1Rate", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.tax1Rate = :tax1Rate"),
    @NamedQuery(name = "BASEOrderTaxCode.findByTax2Rate", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.tax2Rate = :tax2Rate"),
    @NamedQuery(name = "BASEOrderTaxCode.findByTax1Name", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.tax1Name = :tax1Name"),
    @NamedQuery(name = "BASEOrderTaxCode.findByTax2Name", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.tax2Name = :tax2Name"),
    @NamedQuery(name = "BASEOrderTaxCode.findByCalculateTax2OnTax1", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.calculateTax2OnTax1 = :calculateTax2OnTax1"),
    @NamedQuery(name = "BASEOrderTaxCode.findByLastModUserId", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.lastModUserId = :lastModUserId"),
    @NamedQuery(name = "BASEOrderTaxCode.findByLastModDttm", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASEOrderTaxCode.findByIsActive", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BASEOrderTaxCode.findByTaxOnShipping", query = "SELECT b FROM BASEOrderTaxCode b WHERE b.taxOnShipping = :taxOnShipping")})
public class BASEOrderTaxCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderTaxCodeId")
    private Integer orderTaxCodeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tax1Rate")
    private BigDecimal tax1Rate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tax2Rate")
    private BigDecimal tax2Rate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Tax1Name")
    private String tax1Name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Tax2Name")
    private String tax2Name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CalculateTax2OnTax1")
    private boolean calculateTax2OnTax1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastModUserId")
    private int lastModUserId;
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
    @Column(name = "TaxOnShipping")
    private boolean taxOnShipping;
    @OneToMany(mappedBy = "defaultOrderTaxCodeId")
    private List<BASECustomer> bASECustomerList;
    @OneToMany(mappedBy = "defaultOrderTaxCodeId")
    private List<BASEVendor> bASEVendorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderTaxCodeId")
    private List<SOSalesOrder> sOSalesOrderList;

    public BASEOrderTaxCode() {
    }

    public BASEOrderTaxCode(Integer orderTaxCodeId) {
        this.orderTaxCodeId = orderTaxCodeId;
    }

    public BASEOrderTaxCode(Integer orderTaxCodeId, String name, BigDecimal tax1Rate, BigDecimal tax2Rate, String tax1Name, String tax2Name, boolean calculateTax2OnTax1, int lastModUserId, Date lastModDttm, byte[] timestamp, boolean isActive, boolean taxOnShipping) {
        this.orderTaxCodeId = orderTaxCodeId;
        this.name = name;
        this.tax1Rate = tax1Rate;
        this.tax2Rate = tax2Rate;
        this.tax1Name = tax1Name;
        this.tax2Name = tax2Name;
        this.calculateTax2OnTax1 = calculateTax2OnTax1;
        this.lastModUserId = lastModUserId;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.isActive = isActive;
        this.taxOnShipping = taxOnShipping;
    }

    public Integer getOrderTaxCodeId() {
        return orderTaxCodeId;
    }

    public void setOrderTaxCodeId(Integer orderTaxCodeId) {
        this.orderTaxCodeId = orderTaxCodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTax1Rate() {
        return tax1Rate;
    }

    public void setTax1Rate(BigDecimal tax1Rate) {
        this.tax1Rate = tax1Rate;
    }

    public BigDecimal getTax2Rate() {
        return tax2Rate;
    }

    public void setTax2Rate(BigDecimal tax2Rate) {
        this.tax2Rate = tax2Rate;
    }

    public String getTax1Name() {
        return tax1Name;
    }

    public void setTax1Name(String tax1Name) {
        this.tax1Name = tax1Name;
    }

    public String getTax2Name() {
        return tax2Name;
    }

    public void setTax2Name(String tax2Name) {
        this.tax2Name = tax2Name;
    }

    public boolean getCalculateTax2OnTax1() {
        return calculateTax2OnTax1;
    }

    public void setCalculateTax2OnTax1(boolean calculateTax2OnTax1) {
        this.calculateTax2OnTax1 = calculateTax2OnTax1;
    }

    public int getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(int lastModUserId) {
        this.lastModUserId = lastModUserId;
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

    public boolean getTaxOnShipping() {
        return taxOnShipping;
    }

    public void setTaxOnShipping(boolean taxOnShipping) {
        this.taxOnShipping = taxOnShipping;
    }

    @XmlTransient
    public List<BASECustomer> getBASECustomerList() {
        return bASECustomerList;
    }

    public void setBASECustomerList(List<BASECustomer> bASECustomerList) {
        this.bASECustomerList = bASECustomerList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderTaxCodeId != null ? orderTaxCodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEOrderTaxCode)) {
            return false;
        }
        BASEOrderTaxCode other = (BASEOrderTaxCode) object;
        if ((this.orderTaxCodeId == null && other.orderTaxCodeId != null) || (this.orderTaxCodeId != null && !this.orderTaxCodeId.equals(other.orderTaxCodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEOrderTaxCode[ orderTaxCodeId=" + orderTaxCodeId + " ]";
    }
    
}
