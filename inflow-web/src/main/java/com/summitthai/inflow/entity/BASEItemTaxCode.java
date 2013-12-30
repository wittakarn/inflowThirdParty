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
@Table(name = "BASE_ItemTaxCode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEItemTaxCode.findAll", query = "SELECT b FROM BASEItemTaxCode b"),
    @NamedQuery(name = "BASEItemTaxCode.findByItemTaxCodeId", query = "SELECT b FROM BASEItemTaxCode b WHERE b.itemTaxCodeId = :itemTaxCodeId"),
    @NamedQuery(name = "BASEItemTaxCode.findByTax1Applicable", query = "SELECT b FROM BASEItemTaxCode b WHERE b.tax1Applicable = :tax1Applicable"),
    @NamedQuery(name = "BASEItemTaxCode.findByTax2Applicable", query = "SELECT b FROM BASEItemTaxCode b WHERE b.tax2Applicable = :tax2Applicable"),
    @NamedQuery(name = "BASEItemTaxCode.findByName", query = "SELECT b FROM BASEItemTaxCode b WHERE b.name = :name"),
    @NamedQuery(name = "BASEItemTaxCode.findByCode", query = "SELECT b FROM BASEItemTaxCode b WHERE b.code = :code"),
    @NamedQuery(name = "BASEItemTaxCode.findByLastModDttm", query = "SELECT b FROM BASEItemTaxCode b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASEItemTaxCode.findByIsActive", query = "SELECT b FROM BASEItemTaxCode b WHERE b.isActive = :isActive")})
public class BASEItemTaxCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ItemTaxCodeId")
    private Integer itemTaxCodeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tax1Applicable")
    private boolean tax1Applicable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tax2Applicable")
    private boolean tax2Applicable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Code")
    private String code;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemTaxCodeId")
    private List<SOSalesOrderLine> sOSalesOrderLineList;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemTaxCodeId")
    private List<BASEProduct> bASEProductList;

    public BASEItemTaxCode() {
    }

    public BASEItemTaxCode(Integer itemTaxCodeId) {
        this.itemTaxCodeId = itemTaxCodeId;
    }

    public BASEItemTaxCode(Integer itemTaxCodeId, boolean tax1Applicable, boolean tax2Applicable, String name, String code, Date lastModDttm, byte[] timestamp, boolean isActive) {
        this.itemTaxCodeId = itemTaxCodeId;
        this.tax1Applicable = tax1Applicable;
        this.tax2Applicable = tax2Applicable;
        this.name = name;
        this.code = code;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.isActive = isActive;
    }

    public Integer getItemTaxCodeId() {
        return itemTaxCodeId;
    }

    public void setItemTaxCodeId(Integer itemTaxCodeId) {
        this.itemTaxCodeId = itemTaxCodeId;
    }

    public boolean getTax1Applicable() {
        return tax1Applicable;
    }

    public void setTax1Applicable(boolean tax1Applicable) {
        this.tax1Applicable = tax1Applicable;
    }

    public boolean getTax2Applicable() {
        return tax2Applicable;
    }

    public void setTax2Applicable(boolean tax2Applicable) {
        this.tax2Applicable = tax2Applicable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @XmlTransient
    public List<SOSalesOrderLine> getSOSalesOrderLineList() {
        return sOSalesOrderLineList;
    }

    public void setSOSalesOrderLineList(List<SOSalesOrderLine> sOSalesOrderLineList) {
        this.sOSalesOrderLineList = sOSalesOrderLineList;
    }

    public BASEUser getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(BASEUser lastModUserId) {
        this.lastModUserId = lastModUserId;
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
        hash += (itemTaxCodeId != null ? itemTaxCodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEItemTaxCode)) {
            return false;
        }
        BASEItemTaxCode other = (BASEItemTaxCode) object;
        if ((this.itemTaxCodeId == null && other.itemTaxCodeId != null) || (this.itemTaxCodeId != null && !this.itemTaxCodeId.equals(other.itemTaxCodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEItemTaxCode[ itemTaxCodeId=" + itemTaxCodeId + " ]";
    }
    
}
