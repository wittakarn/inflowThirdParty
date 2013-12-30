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
@Table(name = "BASE_FileAttachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BASEFileAttachment.findAll", query = "SELECT b FROM BASEFileAttachment b"),
    @NamedQuery(name = "BASEFileAttachment.findByFileAttachmentId", query = "SELECT b FROM BASEFileAttachment b WHERE b.fileAttachmentId = :fileAttachmentId"),
    @NamedQuery(name = "BASEFileAttachment.findByFileAttachmentType", query = "SELECT b FROM BASEFileAttachment b WHERE b.fileAttachmentType = :fileAttachmentType"),
    @NamedQuery(name = "BASEFileAttachment.findByFileName", query = "SELECT b FROM BASEFileAttachment b WHERE b.fileName = :fileName"),
    @NamedQuery(name = "BASEFileAttachment.findByLastModDttm", query = "SELECT b FROM BASEFileAttachment b WHERE b.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "BASEFileAttachment.findByRandomGuid", query = "SELECT b FROM BASEFileAttachment b WHERE b.randomGuid = :randomGuid")})
public class BASEFileAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FileAttachmentId")
    private Integer fileAttachmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FileAttachmentType")
    private int fileAttachmentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 260)
    @Column(name = "FileName")
    private String fileName;
    @Lob
    @Column(name = "Data")
    private byte[] data;
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
    @Size(min = 1, max = 36)
    @Column(name = "RandomGuid")
    private String randomGuid;
    @OneToMany(mappedBy = "pictureFileAttachmentId")
    private List<BASECompany> bASECompanyList;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @OneToMany(mappedBy = "pictureFileAttachmentId")
    private List<BASEProduct> bASEProductList;

    public BASEFileAttachment() {
    }

    public BASEFileAttachment(Integer fileAttachmentId) {
        this.fileAttachmentId = fileAttachmentId;
    }

    public BASEFileAttachment(Integer fileAttachmentId, int fileAttachmentType, String fileName, Date lastModDttm, byte[] timestamp, String randomGuid) {
        this.fileAttachmentId = fileAttachmentId;
        this.fileAttachmentType = fileAttachmentType;
        this.fileName = fileName;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.randomGuid = randomGuid;
    }

    public Integer getFileAttachmentId() {
        return fileAttachmentId;
    }

    public void setFileAttachmentId(Integer fileAttachmentId) {
        this.fileAttachmentId = fileAttachmentId;
    }

    public int getFileAttachmentType() {
        return fileAttachmentType;
    }

    public void setFileAttachmentType(int fileAttachmentType) {
        this.fileAttachmentType = fileAttachmentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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

    public String getRandomGuid() {
        return randomGuid;
    }

    public void setRandomGuid(String randomGuid) {
        this.randomGuid = randomGuid;
    }

    @XmlTransient
    public List<BASECompany> getBASECompanyList() {
        return bASECompanyList;
    }

    public void setBASECompanyList(List<BASECompany> bASECompanyList) {
        this.bASECompanyList = bASECompanyList;
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
        hash += (fileAttachmentId != null ? fileAttachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BASEFileAttachment)) {
            return false;
        }
        BASEFileAttachment other = (BASEFileAttachment) object;
        if ((this.fileAttachmentId == null && other.fileAttachmentId != null) || (this.fileAttachmentId != null && !this.fileAttachmentId.equals(other.fileAttachmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.BASEFileAttachment[ fileAttachmentId=" + fileAttachmentId + " ]";
    }
    
}
