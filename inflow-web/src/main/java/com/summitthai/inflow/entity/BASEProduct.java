/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.summitthai.inflow.entity;

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
@Table(name = "BASE_Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEProduct.findAll", query = "SELECT b FROM BASEProduct b"),
    @NamedQuery(name = "BASEProduct.findByVersion", query = "SELECT b FROM BASEProduct b WHERE b.version = :version"),
    @NamedQuery(name = "BASEProduct.findByItemType", query = "SELECT b FROM BASEProduct b WHERE b.itemType = :itemType"),
    @NamedQuery(name = "BASEProduct.findByName", query = "SELECT b FROM BASEProduct b WHERE b.name = :name"),
    @NamedQuery(name = "BASEProduct.findByDescription", query = "SELECT b FROM BASEProduct b WHERE b.description = :description"),
    @NamedQuery(name = "BASEProduct.findByRemarks", query = "SELECT b FROM BASEProduct b WHERE b.remarks = :remarks"),
    @NamedQuery(name = "BASEProduct.findByBarCode", query = "SELECT b FROM BASEProduct b WHERE b.barCode = :barCode"),
    @NamedQuery(name = "BASEProduct.findByDefaultSublocation", query = "SELECT b FROM BASEProduct b WHERE b.defaultSublocation = :defaultSublocation"),
    @NamedQuery(name = "BASEProduct.findByReorderPoint", query = "SELECT b FROM BASEProduct b WHERE b.reorderPoint = :reorderPoint"),
    @NamedQuery(name = "BASEProduct.findByReorderQuantity", query = "SELECT b FROM BASEProduct b WHERE b.reorderQuantity = :reorderQuantity"),
    @NamedQuery(name = "BASEProduct.findByUom", query = "SELECT b FROM BASEProduct b WHERE b.uom = :uom"),
    @NamedQuery(name = "BASEProduct.findByMasterPackQty", query = "SELECT b FROM BASEProduct b WHERE b.masterPackQty = :masterPackQty"),
    @NamedQuery(name = "BASEProduct.findByInnerPackQty", query = "SELECT b FROM BASEProduct b WHERE b.innerPackQty = :innerPackQty"),
    @NamedQuery(name = "BASEProduct.findByCaseLength", query = "SELECT b FROM BASEProduct b WHERE b.caseLength = :caseLength"),
    @NamedQuery(name = "BASEProduct.findByCaseWidth", query = "SELECT b FROM BASEProduct b WHERE b.caseWidth = :caseWidth"),
    @NamedQuery(name = "BASEProduct.findByCaseHeight", query = "SELECT b FROM BASEProduct b WHERE b.caseHeight = :caseHeight"),
    @NamedQuery(name = "BASEProduct.findByCaseWeight", query = "SELECT b FROM BASEProduct b WHERE b.caseWeight = :caseWeight"),
    @NamedQuery(name = "BASEProduct.findByProductLength", query = "SELECT b FROM BASEProduct b WHERE b.productLength = :productLength"),
    @NamedQuery(name = "BASEProduct.findByProductWidth", query = "SELECT b FROM BASEProduct b WHERE b.productWidth = :productWidth"),
    @NamedQuery(name = "BASEProduct.findByProductHeight", query = "SELECT b FROM BASEProduct b WHERE b.productHeight = :productHeight"),
    @NamedQuery(name = "BASEProduct.findByProductWeight", query = "SELECT b FROM BASEProduct b WHERE b.productWeight = :productWeight"),
    @NamedQuery(name = "BASEProduct.findByCustom1", query = "SELECT b FROM BASEProduct b WHERE b.custom1 = :custom1"),
    @NamedQuery(name = "BASEProduct.findByCustom2", query = "SELECT b FROM BASEProduct b WHERE b.custom2 = :custom2"),
    @NamedQuery(name = "BASEProduct.findByCustom3", query = "SELECT b FROM BASEProduct b WHERE b.custom3 = :custom3"),
    @NamedQuery(name = "BASEProduct.findByCustom4", query = "SELECT b FROM BASEProduct b WHERE b.custom4 = :custom4"),
    @NamedQuery(name = "BASEProduct.findByCustom5", query = "SELECT b FROM BASEProduct b WHERE b.custom5 = :custom5"),
    @NamedQuery(name = "BASEProduct.findByIsSellable", query = "SELECT b FROM BASEProduct b WHERE b.isSellable = :isSellable"),
    @NamedQuery(name = "BASEProduct.findByIsPurchaseable", query = "SELECT b FROM BASEProduct b WHERE b.isPurchaseable = :isPurchaseable"),
    @NamedQuery(name = "BASEProduct.findByDateIntroduced", query = "SELECT b FROM BASEProduct b WHERE b.dateIntroduced = :dateIntroduced"),
    @NamedQuery(name = "BASEProduct.findByDateUpdated", query = "SELECT b FROM BASEProduct b WHERE b.dateUpdated = :dateUpdated"),
    @NamedQuery(name = "BASEProduct.findByLastModDttm", query = "SELECT b FROM BASEProduct b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASEProduct.findByIsActive", query = "SELECT b FROM BASEProduct b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BASEProduct.findByCustom6", query = "SELECT b FROM BASEProduct b WHERE b.custom6 = :custom6"),
    @NamedQuery(name = "BASEProduct.findByCustom7", query = "SELECT b FROM BASEProduct b WHERE b.custom7 = :custom7"),
    @NamedQuery(name = "BASEProduct.findByCustom8", query = "SELECT b FROM BASEProduct b WHERE b.custom8 = :custom8"),
    @NamedQuery(name = "BASEProduct.findByCustom9", query = "SELECT b FROM BASEProduct b WHERE b.custom9 = :custom9"),
    @NamedQuery(name = "BASEProduct.findByCustom10", query = "SELECT b FROM BASEProduct b WHERE b.custom10 = :custom10"),
    @NamedQuery(name = "BASEProduct.findBySoUomName", query = "SELECT b FROM BASEProduct b WHERE b.soUomName = :soUomName"),
    @NamedQuery(name = "BASEProduct.findBySoUomRatioStd", query = "SELECT b FROM BASEProduct b WHERE b.soUomRatioStd = :soUomRatioStd"),
    @NamedQuery(name = "BASEProduct.findBySoUomRatio", query = "SELECT b FROM BASEProduct b WHERE b.soUomRatio = :soUomRatio"),
    @NamedQuery(name = "BASEProduct.findByPoUomName", query = "SELECT b FROM BASEProduct b WHERE b.poUomName = :poUomName"),
    @NamedQuery(name = "BASEProduct.findByPoUomRatioStd", query = "SELECT b FROM BASEProduct b WHERE b.poUomRatioStd = :poUomRatioStd"),
    @NamedQuery(name = "BASEProduct.findByPoUomRatio", query = "SELECT b FROM BASEProduct b WHERE b.poUomRatio = :poUomRatio"),
    @NamedQuery(name = "BASEProduct.findByProdId", query = "SELECT b FROM BASEProduct b WHERE b.prodId = :prodId")})
public class BASEProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ItemType")
    private int itemType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "BarCode")
    private String barCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DefaultSublocation")
    private String defaultSublocation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ReorderPoint")
    private BigDecimal reorderPoint;
    @Column(name = "ReorderQuantity")
    private BigDecimal reorderQuantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Uom")
    private String uom;
    @Column(name = "MasterPackQty")
    private BigDecimal masterPackQty;
    @Column(name = "InnerPackQty")
    private BigDecimal innerPackQty;
    @Column(name = "CaseLength")
    private BigDecimal caseLength;
    @Column(name = "CaseWidth")
    private BigDecimal caseWidth;
    @Column(name = "CaseHeight")
    private BigDecimal caseHeight;
    @Column(name = "CaseWeight")
    private BigDecimal caseWeight;
    @Column(name = "ProductLength")
    private BigDecimal productLength;
    @Column(name = "ProductWidth")
    private BigDecimal productWidth;
    @Column(name = "ProductHeight")
    private BigDecimal productHeight;
    @Column(name = "ProductWeight")
    private BigDecimal productWeight;
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
    @Column(name = "IsSellable")
    private boolean isSellable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsPurchaseable")
    private boolean isPurchaseable;
    @Column(name = "DateIntroduced")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIntroduced;
    @Column(name = "DateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
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
    @Size(min = 1, max = 10)
    @Column(name = "SoUomName")
    private String soUomName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoUomRatioStd")
    private BigDecimal soUomRatioStd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoUomRatio")
    private BigDecimal soUomRatio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PoUomName")
    private String poUomName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PoUomRatioStd")
    private BigDecimal poUomRatioStd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PoUomRatio")
    private BigDecimal poUomRatio;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdId")
    private Integer prodId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<SOSalesOrderLine> sOSalesOrderLineList;
    @JoinColumn(name = "LastVendorId", referencedColumnName = "VendorId")
    @ManyToOne
    private BASEVendor lastVendorId;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @JoinColumn(name = "DefaultLocationId", referencedColumnName = "LocationId")
    @ManyToOne
    private BASELocation defaultLocationId;
    @JoinColumn(name = "ItemTaxCodeId", referencedColumnName = "ItemTaxCodeId")
    @ManyToOne(optional = false)
    private BASEItemTaxCode itemTaxCodeId;
    @JoinColumn(name = "PictureFileAttachmentId", referencedColumnName = "FileAttachmentId")
    @ManyToOne
    private BASEFileAttachment pictureFileAttachmentId;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne(optional = false)
    private BASECategory categoryId;

    public BASEProduct() {
    }

    public BASEProduct(Integer prodId) {
        this.prodId = prodId;
    }

    public BASEProduct(Integer prodId, int version, int itemType, String name, String description, String remarks, String barCode, String defaultSublocation, String uom, String custom1, String custom2, String custom3, String custom4, String custom5, boolean isSellable, boolean isPurchaseable, Date lastModDttm, byte[] timestamp, boolean isActive, String custom6, String custom7, String custom8, String custom9, String custom10, String soUomName, BigDecimal soUomRatioStd, BigDecimal soUomRatio, String poUomName, BigDecimal poUomRatioStd, BigDecimal poUomRatio) {
        this.prodId = prodId;
        this.version = version;
        this.itemType = itemType;
        this.name = name;
        this.description = description;
        this.remarks = remarks;
        this.barCode = barCode;
        this.defaultSublocation = defaultSublocation;
        this.uom = uom;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
        this.custom4 = custom4;
        this.custom5 = custom5;
        this.isSellable = isSellable;
        this.isPurchaseable = isPurchaseable;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.isActive = isActive;
        this.custom6 = custom6;
        this.custom7 = custom7;
        this.custom8 = custom8;
        this.custom9 = custom9;
        this.custom10 = custom10;
        this.soUomName = soUomName;
        this.soUomRatioStd = soUomRatioStd;
        this.soUomRatio = soUomRatio;
        this.poUomName = poUomName;
        this.poUomRatioStd = poUomRatioStd;
        this.poUomRatio = poUomRatio;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDefaultSublocation() {
        return defaultSublocation;
    }

    public void setDefaultSublocation(String defaultSublocation) {
        this.defaultSublocation = defaultSublocation;
    }

    public BigDecimal getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(BigDecimal reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public BigDecimal getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(BigDecimal reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public BigDecimal getMasterPackQty() {
        return masterPackQty;
    }

    public void setMasterPackQty(BigDecimal masterPackQty) {
        this.masterPackQty = masterPackQty;
    }

    public BigDecimal getInnerPackQty() {
        return innerPackQty;
    }

    public void setInnerPackQty(BigDecimal innerPackQty) {
        this.innerPackQty = innerPackQty;
    }

    public BigDecimal getCaseLength() {
        return caseLength;
    }

    public void setCaseLength(BigDecimal caseLength) {
        this.caseLength = caseLength;
    }

    public BigDecimal getCaseWidth() {
        return caseWidth;
    }

    public void setCaseWidth(BigDecimal caseWidth) {
        this.caseWidth = caseWidth;
    }

    public BigDecimal getCaseHeight() {
        return caseHeight;
    }

    public void setCaseHeight(BigDecimal caseHeight) {
        this.caseHeight = caseHeight;
    }

    public BigDecimal getCaseWeight() {
        return caseWeight;
    }

    public void setCaseWeight(BigDecimal caseWeight) {
        this.caseWeight = caseWeight;
    }

    public BigDecimal getProductLength() {
        return productLength;
    }

    public void setProductLength(BigDecimal productLength) {
        this.productLength = productLength;
    }

    public BigDecimal getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(BigDecimal productWidth) {
        this.productWidth = productWidth;
    }

    public BigDecimal getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(BigDecimal productHeight) {
        this.productHeight = productHeight;
    }

    public BigDecimal getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(BigDecimal productWeight) {
        this.productWeight = productWeight;
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

    public boolean getIsSellable() {
        return isSellable;
    }

    public void setIsSellable(boolean isSellable) {
        this.isSellable = isSellable;
    }

    public boolean getIsPurchaseable() {
        return isPurchaseable;
    }

    public void setIsPurchaseable(boolean isPurchaseable) {
        this.isPurchaseable = isPurchaseable;
    }

    public Date getDateIntroduced() {
        return dateIntroduced;
    }

    public void setDateIntroduced(Date dateIntroduced) {
        this.dateIntroduced = dateIntroduced;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
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

    public String getSoUomName() {
        return soUomName;
    }

    public void setSoUomName(String soUomName) {
        this.soUomName = soUomName;
    }

    public BigDecimal getSoUomRatioStd() {
        return soUomRatioStd;
    }

    public void setSoUomRatioStd(BigDecimal soUomRatioStd) {
        this.soUomRatioStd = soUomRatioStd;
    }

    public BigDecimal getSoUomRatio() {
        return soUomRatio;
    }

    public void setSoUomRatio(BigDecimal soUomRatio) {
        this.soUomRatio = soUomRatio;
    }

    public String getPoUomName() {
        return poUomName;
    }

    public void setPoUomName(String poUomName) {
        this.poUomName = poUomName;
    }

    public BigDecimal getPoUomRatioStd() {
        return poUomRatioStd;
    }

    public void setPoUomRatioStd(BigDecimal poUomRatioStd) {
        this.poUomRatioStd = poUomRatioStd;
    }

    public BigDecimal getPoUomRatio() {
        return poUomRatio;
    }

    public void setPoUomRatio(BigDecimal poUomRatio) {
        this.poUomRatio = poUomRatio;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    @XmlTransient
    public List<SOSalesOrderLine> getSOSalesOrderLineList() {
        return sOSalesOrderLineList;
    }

    public void setSOSalesOrderLineList(List<SOSalesOrderLine> sOSalesOrderLineList) {
        this.sOSalesOrderLineList = sOSalesOrderLineList;
    }

    public BASEVendor getLastVendorId() {
        return lastVendorId;
    }

    public void setLastVendorId(BASEVendor lastVendorId) {
        this.lastVendorId = lastVendorId;
    }

    public BASEUser getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(BASEUser lastModUserId) {
        this.lastModUserId = lastModUserId;
    }

    public BASELocation getDefaultLocationId() {
        return defaultLocationId;
    }

    public void setDefaultLocationId(BASELocation defaultLocationId) {
        this.defaultLocationId = defaultLocationId;
    }

    public BASEItemTaxCode getItemTaxCodeId() {
        return itemTaxCodeId;
    }

    public void setItemTaxCodeId(BASEItemTaxCode itemTaxCodeId) {
        this.itemTaxCodeId = itemTaxCodeId;
    }

    public BASEFileAttachment getPictureFileAttachmentId() {
        return pictureFileAttachmentId;
    }

    public void setPictureFileAttachmentId(BASEFileAttachment pictureFileAttachmentId) {
        this.pictureFileAttachmentId = pictureFileAttachmentId;
    }

    public BASECategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BASECategory categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEProduct)) {
            return false;
        }
        BASEProduct other = (BASEProduct) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEProduct[ prodId=" + prodId + " ]";
    }
    
}
