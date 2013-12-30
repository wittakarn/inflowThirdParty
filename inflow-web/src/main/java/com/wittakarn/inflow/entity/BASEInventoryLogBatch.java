/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.entity;

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
@Table(name = "BASE_InventoryLogBatch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEInventoryLogBatch.findAll", query = "SELECT b FROM BASEInventoryLogBatch b"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByInventoryLogBatchId", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.inventoryLogBatchId = :inventoryLogBatchId"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByBatchDate", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.batchDate = :batchDate"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByTransactionDate", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.transactionDate = :transactionDate"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByBatchType", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.batchType = :batchType"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByRecordId", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.recordId = :recordId"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByRemarks", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.remarks = :remarks"),
    @NamedQuery(name = "BASEInventoryLogBatch.findByCreatedDttm", query = "SELECT b FROM BASEInventoryLogBatch b WHERE b.createdDttm = :createdDttm")})
public class BASEInventoryLogBatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "InventoryLogBatchId")
    private Integer inventoryLogBatchId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BatchDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date batchDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TransactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BatchType")
    private int batchType;
    @Column(name = "RecordId")
    private Integer recordId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDttm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDttm;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Timestamp")
    private byte[] timestamp;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser createdUserId;
    @OneToMany(mappedBy = "returnInventoryBatchLogId")
    private List<SOSalesOrder> sOSalesOrderList;

    public BASEInventoryLogBatch() {
    }

    public BASEInventoryLogBatch(Integer inventoryLogBatchId) {
        this.inventoryLogBatchId = inventoryLogBatchId;
    }

    public BASEInventoryLogBatch(Integer inventoryLogBatchId, Date batchDate, Date transactionDate, int batchType, String remarks, Date createdDttm, byte[] timestamp) {
        this.inventoryLogBatchId = inventoryLogBatchId;
        this.batchDate = batchDate;
        this.transactionDate = transactionDate;
        this.batchType = batchType;
        this.remarks = remarks;
        this.createdDttm = createdDttm;
        this.timestamp = timestamp;
    }

    public Integer getInventoryLogBatchId() {
        return inventoryLogBatchId;
    }

    public void setInventoryLogBatchId(Integer inventoryLogBatchId) {
        this.inventoryLogBatchId = inventoryLogBatchId;
    }

    public Date getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getBatchType() {
        return batchType;
    }

    public void setBatchType(int batchType) {
        this.batchType = batchType;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedDttm() {
        return createdDttm;
    }

    public void setCreatedDttm(Date createdDttm) {
        this.createdDttm = createdDttm;
    }

    public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public BASEUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(BASEUser createdUserId) {
        this.createdUserId = createdUserId;
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
        hash += (inventoryLogBatchId != null ? inventoryLogBatchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEInventoryLogBatch)) {
            return false;
        }
        BASEInventoryLogBatch other = (BASEInventoryLogBatch) object;
        if ((this.inventoryLogBatchId == null && other.inventoryLogBatchId != null) || (this.inventoryLogBatchId != null && !this.inventoryLogBatchId.equals(other.inventoryLogBatchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEInventoryLogBatch[ inventoryLogBatchId=" + inventoryLogBatchId + " ]";
    }
    
}
