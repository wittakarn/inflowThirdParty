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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "BASE_Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASECategory.findAll", query = "SELECT b FROM BASECategory b"),
    @NamedQuery(name = "BASECategory.findByCategoryId", query = "SELECT b FROM BASECategory b WHERE b.categoryId = :categoryId"),
    @NamedQuery(name = "BASECategory.findByName", query = "SELECT b FROM BASECategory b WHERE b.name = :name"),
    @NamedQuery(name = "BASECategory.findByIsActive", query = "SELECT b FROM BASECategory b WHERE b.isActive = :isActive")})
public class BASECategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CategoryId")
    private Integer categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
    @OneToMany(mappedBy = "parentCategoryId")
    private List<BASECategory> bASECategoryList;
    @JoinColumn(name = "ParentCategoryId", referencedColumnName = "CategoryId")
    @ManyToOne
    private BASECategory parentCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<BASEProduct> bASEProductList;

    public BASECategory() {
    }

    public BASECategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BASECategory(Integer categoryId, String name, byte[] timestamp, boolean isActive) {
        this.categoryId = categoryId;
        this.name = name;
        this.timestamp = timestamp;
        this.isActive = isActive;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public List<BASECategory> getBASECategoryList() {
        return bASECategoryList;
    }

    public void setBASECategoryList(List<BASECategory> bASECategoryList) {
        this.bASECategoryList = bASECategoryList;
    }

    public BASECategory getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(BASECategory parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASECategory)) {
            return false;
        }
        BASECategory other = (BASECategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASECategory[ categoryId=" + categoryId + " ]";
    }
    
}
