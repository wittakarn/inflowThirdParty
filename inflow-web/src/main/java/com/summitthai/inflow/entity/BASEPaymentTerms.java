/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.summitthai.inflow.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "BASE_PaymentTerms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEPaymentTerms.findAll", query = "SELECT b FROM BASEPaymentTerms b"),
    @NamedQuery(name = "BASEPaymentTerms.findByPaymentTermsId", query = "SELECT b FROM BASEPaymentTerms b WHERE b.paymentTermsId = :paymentTermsId"),
    @NamedQuery(name = "BASEPaymentTerms.findByName", query = "SELECT b FROM BASEPaymentTerms b WHERE b.name = :name"),
    @NamedQuery(name = "BASEPaymentTerms.findByDaysDue", query = "SELECT b FROM BASEPaymentTerms b WHERE b.daysDue = :daysDue"),
    @NamedQuery(name = "BASEPaymentTerms.findByIsActive", query = "SELECT b FROM BASEPaymentTerms b WHERE b.isActive = :isActive")})
public class BASEPaymentTerms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PaymentTermsId")
    private Integer paymentTermsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DaysDue")
    private int daysDue;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
    @OneToMany(mappedBy = "defaultPaymentTermsId")
    private List<BASECustomer> bASECustomerList;
    @OneToMany(mappedBy = "defaultPaymentTermsId")
    private List<BASEVendor> bASEVendorList;
    @OneToMany(mappedBy = "paymentTermsId")
    private List<SOSalesOrder> sOSalesOrderList;

    public BASEPaymentTerms() {
    }

    public BASEPaymentTerms(Integer paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public BASEPaymentTerms(Integer paymentTermsId, String name, int daysDue, byte[] timestamp, boolean isActive) {
        this.paymentTermsId = paymentTermsId;
        this.name = name;
        this.daysDue = daysDue;
        this.timestamp = timestamp;
        this.isActive = isActive;
    }

    public Integer getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Integer paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysDue() {
        return daysDue;
    }

    public void setDaysDue(int daysDue) {
        this.daysDue = daysDue;
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
        hash += (paymentTermsId != null ? paymentTermsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEPaymentTerms)) {
            return false;
        }
        BASEPaymentTerms other = (BASEPaymentTerms) object;
        if ((this.paymentTermsId == null && other.paymentTermsId != null) || (this.paymentTermsId != null && !this.paymentTermsId.equals(other.paymentTermsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEPaymentTerms[ paymentTermsId=" + paymentTermsId + " ]";
    }
    
}
