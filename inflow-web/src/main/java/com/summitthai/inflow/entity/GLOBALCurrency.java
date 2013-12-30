/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.summitthai.inflow.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wittakarn
 */
@Entity
@Table(name = "GLOBAL_Currency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GLOBALCurrency.findAll", query = "SELECT g FROM GLOBALCurrency g"),
    @NamedQuery(name = "GLOBALCurrency.findByCurrencyId", query = "SELECT g FROM GLOBALCurrency g WHERE g.currencyId = :currencyId"),
    @NamedQuery(name = "GLOBALCurrency.findByCode", query = "SELECT g FROM GLOBALCurrency g WHERE g.code = :code"),
    @NamedQuery(name = "GLOBALCurrency.findByDescription", query = "SELECT g FROM GLOBALCurrency g WHERE g.description = :description"),
    @NamedQuery(name = "GLOBALCurrency.findBySymbol", query = "SELECT g FROM GLOBALCurrency g WHERE g.symbol = :symbol"),
    @NamedQuery(name = "GLOBALCurrency.findByIsActive", query = "SELECT g FROM GLOBALCurrency g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "GLOBALCurrency.findByDecimalPlaces", query = "SELECT g FROM GLOBALCurrency g WHERE g.decimalPlaces = :decimalPlaces"),
    @NamedQuery(name = "GLOBALCurrency.findByDecimalSeparator", query = "SELECT g FROM GLOBALCurrency g WHERE g.decimalSeparator = :decimalSeparator"),
    @NamedQuery(name = "GLOBALCurrency.findByThousandsSeparator", query = "SELECT g FROM GLOBALCurrency g WHERE g.thousandsSeparator = :thousandsSeparator"),
    @NamedQuery(name = "GLOBALCurrency.findByCRCurrencyPositionType", query = "SELECT g FROM GLOBALCurrency g WHERE g.cRCurrencyPositionType = :cRCurrencyPositionType"),
    @NamedQuery(name = "GLOBALCurrency.findByCRNegativeType", query = "SELECT g FROM GLOBALCurrency g WHERE g.cRNegativeType = :cRNegativeType")})
public class GLOBALCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CurrencyId")
    private Integer currencyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Symbol")
    private String symbol;
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
    @Column(name = "DecimalPlaces")
    private short decimalPlaces;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "DecimalSeparator")
    private String decimalSeparator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ThousandsSeparator")
    private String thousandsSeparator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRCurrencyPositionType")
    private short cRCurrencyPositionType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRNegativeType")
    private short cRNegativeType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private List<BASEPricingScheme> bASEPricingSchemeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private List<BASEVendor> bASEVendorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private List<SOSalesOrder> sOSalesOrderList;

    public GLOBALCurrency() {
    }

    public GLOBALCurrency(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public GLOBALCurrency(Integer currencyId, String code, String description, String symbol, byte[] timestamp, boolean isActive, short decimalPlaces, String decimalSeparator, String thousandsSeparator, short cRCurrencyPositionType, short cRNegativeType) {
        this.currencyId = currencyId;
        this.code = code;
        this.description = description;
        this.symbol = symbol;
        this.timestamp = timestamp;
        this.isActive = isActive;
        this.decimalPlaces = decimalPlaces;
        this.decimalSeparator = decimalSeparator;
        this.thousandsSeparator = thousandsSeparator;
        this.cRCurrencyPositionType = cRCurrencyPositionType;
        this.cRNegativeType = cRNegativeType;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public short getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(short decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public void setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }

    public short getCRCurrencyPositionType() {
        return cRCurrencyPositionType;
    }

    public void setCRCurrencyPositionType(short cRCurrencyPositionType) {
        this.cRCurrencyPositionType = cRCurrencyPositionType;
    }

    public short getCRNegativeType() {
        return cRNegativeType;
    }

    public void setCRNegativeType(short cRNegativeType) {
        this.cRNegativeType = cRNegativeType;
    }

    @XmlTransient
    public List<BASEPricingScheme> getBASEPricingSchemeList() {
        return bASEPricingSchemeList;
    }

    public void setBASEPricingSchemeList(List<BASEPricingScheme> bASEPricingSchemeList) {
        this.bASEPricingSchemeList = bASEPricingSchemeList;
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
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GLOBALCurrency)) {
            return false;
        }
        GLOBALCurrency other = (GLOBALCurrency) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.GLOBALCurrency[ currencyId=" + currencyId + " ]";
    }
    
}
