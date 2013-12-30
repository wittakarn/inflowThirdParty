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
@Table(name = "BASE_Location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASELocation.findAll", query = "SELECT b FROM BASELocation b"),
    @NamedQuery(name = "BASELocation.findByLocationId", query = "SELECT b FROM BASELocation b WHERE b.locationId = :locationId"),
    @NamedQuery(name = "BASELocation.findByName", query = "SELECT b FROM BASELocation b WHERE b.name = :name"),
    @NamedQuery(name = "BASELocation.findByLastModDttm", query = "SELECT b FROM BASELocation b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASELocation.findByIsActive", query = "SELECT b FROM BASELocation b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BASELocation.findByIsSpecialRecord", query = "SELECT b FROM BASELocation b WHERE b.isSpecialRecord = :isSpecialRecord")})
public class BASELocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LocationId")
    private Integer locationId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSpecialRecord")
    private boolean isSpecialRecord;
    @OneToMany(mappedBy = "defaultLocationId")
    private List<BASECustomer> bASECustomerList;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @OneToMany(mappedBy = "defaultLocationId")
    private List<BASEProduct> bASEProductList;

    public BASELocation() {
    }

    public BASELocation(Integer locationId) {
        this.locationId = locationId;
    }

    public BASELocation(Integer locationId, String name, Date lastModDttm, byte[] timestamp, boolean isActive, boolean isSpecialRecord) {
        this.locationId = locationId;
        this.name = name;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.isActive = isActive;
        this.isSpecialRecord = isSpecialRecord;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
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

    public boolean getIsSpecialRecord() {
        return isSpecialRecord;
    }

    public void setIsSpecialRecord(boolean isSpecialRecord) {
        this.isSpecialRecord = isSpecialRecord;
    }

    @XmlTransient
    public List<BASECustomer> getBASECustomerList() {
        return bASECustomerList;
    }

    public void setBASECustomerList(List<BASECustomer> bASECustomerList) {
        this.bASECustomerList = bASECustomerList;
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
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASELocation)) {
            return false;
        }
        BASELocation other = (BASELocation) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASELocation[ locationId=" + locationId + " ]";
    }
    
}
