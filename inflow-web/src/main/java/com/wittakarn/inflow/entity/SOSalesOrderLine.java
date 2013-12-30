/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wittakarn
 */
@Entity
@Table(name = "SO_SalesOrder_Line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SOSalesOrderLine.findAll", query = "SELECT s FROM SOSalesOrderLine s"),
    @NamedQuery(name = "SOSalesOrderLine.findBySalesOrderLineId", query = "SELECT s FROM SOSalesOrderLine s WHERE s.salesOrderLineId = :salesOrderLineId"),
    @NamedQuery(name = "SOSalesOrderLine.findByVersion", query = "SELECT s FROM SOSalesOrderLine s WHERE s.version = :version"),
    @NamedQuery(name = "SOSalesOrderLine.findByLineNum", query = "SELECT s FROM SOSalesOrderLine s WHERE s.lineNum = :lineNum"),
    @NamedQuery(name = "SOSalesOrderLine.findByDescription", query = "SELECT s FROM SOSalesOrderLine s WHERE s.description = :description"),
    @NamedQuery(name = "SOSalesOrderLine.findByQuantity", query = "SELECT s FROM SOSalesOrderLine s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SOSalesOrderLine.findByUnitPrice", query = "SELECT s FROM SOSalesOrderLine s WHERE s.unitPrice = :unitPrice"),
    @NamedQuery(name = "SOSalesOrderLine.findByDiscount", query = "SELECT s FROM SOSalesOrderLine s WHERE s.discount = :discount"),
    @NamedQuery(name = "SOSalesOrderLine.findBySubTotal", query = "SELECT s FROM SOSalesOrderLine s WHERE s.subTotal = :subTotal"),
    @NamedQuery(name = "SOSalesOrderLine.findByQuantityUom", query = "SELECT s FROM SOSalesOrderLine s WHERE s.quantityUom = :quantityUom"),
    @NamedQuery(name = "SOSalesOrderLine.findByQuantityDisplay", query = "SELECT s FROM SOSalesOrderLine s WHERE s.quantityDisplay = :quantityDisplay"),
    @NamedQuery(name = "SOSalesOrderLine.findByDiscountIsPercent", query = "SELECT s FROM SOSalesOrderLine s WHERE s.discountIsPercent = :discountIsPercent")})
public class SOSalesOrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SalesOrderLineId")
    private Integer salesOrderLineId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LineNum")
    private int lineNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private BigDecimal quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount")
    private BigDecimal discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SubTotal")
    private BigDecimal subTotal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "QuantityUom")
    private String quantityUom;
    @Column(name = "QuantityDisplay")
    private BigDecimal quantityDisplay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountIsPercent")
    private boolean discountIsPercent;
    @JoinColumn(name = "SalesOrderId", referencedColumnName = "SalesOrderId")
    @ManyToOne(optional = false)
    private SOSalesOrder salesOrderId;
    @JoinColumn(name = "ProdId", referencedColumnName = "ProdId")
    @ManyToOne(optional = false)
    private BASEProduct prodId;
    @JoinColumn(name = "ItemTaxCodeId", referencedColumnName = "ItemTaxCodeId")
    @ManyToOne(optional = false)
    private BASEItemTaxCode itemTaxCodeId;

    public SOSalesOrderLine() {
    }

    public SOSalesOrderLine(Integer salesOrderLineId) {
        this.salesOrderLineId = salesOrderLineId;
    }

    public SOSalesOrderLine(Integer salesOrderLineId, int version, int lineNum, String description, BigDecimal quantity, BigDecimal unitPrice, BigDecimal discount, BigDecimal subTotal, byte[] timestamp, String quantityUom, boolean discountIsPercent) {
        this.salesOrderLineId = salesOrderLineId;
        this.version = version;
        this.lineNum = lineNum;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.subTotal = subTotal;
        this.timestamp = timestamp;
        this.quantityUom = quantityUom;
        this.discountIsPercent = discountIsPercent;
    }

    public Integer getSalesOrderLineId() {
        return salesOrderLineId;
    }

    public void setSalesOrderLineId(Integer salesOrderLineId) {
        this.salesOrderLineId = salesOrderLineId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public String getQuantityUom() {
        return quantityUom;
    }

    public void setQuantityUom(String quantityUom) {
        this.quantityUom = quantityUom;
    }

    public BigDecimal getQuantityDisplay() {
        return quantityDisplay;
    }

    public void setQuantityDisplay(BigDecimal quantityDisplay) {
        this.quantityDisplay = quantityDisplay;
    }

    public boolean getDiscountIsPercent() {
        return discountIsPercent;
    }

    public void setDiscountIsPercent(boolean discountIsPercent) {
        this.discountIsPercent = discountIsPercent;
    }

    public SOSalesOrder getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(SOSalesOrder salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public BASEProduct getProdId() {
        return prodId;
    }

    public void setProdId(BASEProduct prodId) {
        this.prodId = prodId;
    }

    public BASEItemTaxCode getItemTaxCodeId() {
        return itemTaxCodeId;
    }

    public void setItemTaxCodeId(BASEItemTaxCode itemTaxCodeId) {
        this.itemTaxCodeId = itemTaxCodeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesOrderLineId != null ? salesOrderLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SOSalesOrderLine)) {
            return false;
        }
        SOSalesOrderLine other = (SOSalesOrderLine) object;
        if ((this.salesOrderLineId == null && other.salesOrderLineId != null) || (this.salesOrderLineId != null && !this.salesOrderLineId.equals(other.salesOrderLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.SOSalesOrderLine[ salesOrderLineId=" + salesOrderLineId + " ]";
    }
    
}
