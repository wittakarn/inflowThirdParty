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
@Table(name = "SO_SalesOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SOSalesOrder.findAll", query = "SELECT s FROM SOSalesOrder s"),
    @NamedQuery(name = "SOSalesOrder.findBySalesOrderId", query = "SELECT s FROM SOSalesOrder s WHERE s.salesOrderId = :salesOrderId"),
    @NamedQuery(name = "SOSalesOrder.findByVersion", query = "SELECT s FROM SOSalesOrder s WHERE s.version = :version"),
    @NamedQuery(name = "SOSalesOrder.findByOrderStatus", query = "SELECT s FROM SOSalesOrder s WHERE s.orderStatus = :orderStatus"),
    @NamedQuery(name = "SOSalesOrder.findByOrderNumber", query = "SELECT s FROM SOSalesOrder s WHERE s.orderNumber = :orderNumber"),
    @NamedQuery(name = "SOSalesOrder.findByOrderDate", query = "SELECT s FROM SOSalesOrder s WHERE s.orderDate = :orderDate"),
    @NamedQuery(name = "SOSalesOrder.findBySalesRep", query = "SELECT s FROM SOSalesOrder s WHERE s.salesRep = :salesRep"),
    @NamedQuery(name = "SOSalesOrder.findByPONumber", query = "SELECT s FROM SOSalesOrder s WHERE s.pONumber = :pONumber"),
    @NamedQuery(name = "SOSalesOrder.findByRequestShipDate", query = "SELECT s FROM SOSalesOrder s WHERE s.requestShipDate = :requestShipDate"),
    @NamedQuery(name = "SOSalesOrder.findByDueDate", query = "SELECT s FROM SOSalesOrder s WHERE s.dueDate = :dueDate"),
    @NamedQuery(name = "SOSalesOrder.findByCalculatedDueDate", query = "SELECT s FROM SOSalesOrder s WHERE s.calculatedDueDate = :calculatedDueDate"),
    @NamedQuery(name = "SOSalesOrder.findByOrderRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.orderRemarks = :orderRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByOrderSubTotal", query = "SELECT s FROM SOSalesOrder s WHERE s.orderSubTotal = :orderSubTotal"),
    @NamedQuery(name = "SOSalesOrder.findByOrderTax1", query = "SELECT s FROM SOSalesOrder s WHERE s.orderTax1 = :orderTax1"),
    @NamedQuery(name = "SOSalesOrder.findByOrderTax2", query = "SELECT s FROM SOSalesOrder s WHERE s.orderTax2 = :orderTax2"),
    @NamedQuery(name = "SOSalesOrder.findByOrderExtra", query = "SELECT s FROM SOSalesOrder s WHERE s.orderExtra = :orderExtra"),
    @NamedQuery(name = "SOSalesOrder.findByOrderTotal", query = "SELECT s FROM SOSalesOrder s WHERE s.orderTotal = :orderTotal"),
    @NamedQuery(name = "SOSalesOrder.findByTax1Rate", query = "SELECT s FROM SOSalesOrder s WHERE s.tax1Rate = :tax1Rate"),
    @NamedQuery(name = "SOSalesOrder.findByTax2Rate", query = "SELECT s FROM SOSalesOrder s WHERE s.tax2Rate = :tax2Rate"),
    @NamedQuery(name = "SOSalesOrder.findByCalculateTax2OnTax1", query = "SELECT s FROM SOSalesOrder s WHERE s.calculateTax2OnTax1 = :calculateTax2OnTax1"),
    @NamedQuery(name = "SOSalesOrder.findByTax1Name", query = "SELECT s FROM SOSalesOrder s WHERE s.tax1Name = :tax1Name"),
    @NamedQuery(name = "SOSalesOrder.findByTax2Name", query = "SELECT s FROM SOSalesOrder s WHERE s.tax2Name = :tax2Name"),
    @NamedQuery(name = "SOSalesOrder.findByEmail", query = "SELECT s FROM SOSalesOrder s WHERE s.email = :email"),
    @NamedQuery(name = "SOSalesOrder.findByPickedDate", query = "SELECT s FROM SOSalesOrder s WHERE s.pickedDate = :pickedDate"),
    @NamedQuery(name = "SOSalesOrder.findByPickingRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.pickingRemarks = :pickingRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByPackedDate", query = "SELECT s FROM SOSalesOrder s WHERE s.packedDate = :packedDate"),
    @NamedQuery(name = "SOSalesOrder.findByPackingRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.packingRemarks = :packingRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByShippingRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingRemarks = :shippingRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByIsStandAloneInvoice", query = "SELECT s FROM SOSalesOrder s WHERE s.isStandAloneInvoice = :isStandAloneInvoice"),
    @NamedQuery(name = "SOSalesOrder.findByInvoicedDate", query = "SELECT s FROM SOSalesOrder s WHERE s.invoicedDate = :invoicedDate"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceRemarks = :invoiceRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceSubTotal", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceSubTotal = :invoiceSubTotal"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceTax1", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceTax1 = :invoiceTax1"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceTax2", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceTax2 = :invoiceTax2"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceExtra", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceExtra = :invoiceExtra"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceTotal", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceTotal = :invoiceTotal"),
    @NamedQuery(name = "SOSalesOrder.findByAmountPaid", query = "SELECT s FROM SOSalesOrder s WHERE s.amountPaid = :amountPaid"),
    @NamedQuery(name = "SOSalesOrder.findByInvoiceBalance", query = "SELECT s FROM SOSalesOrder s WHERE s.invoiceBalance = :invoiceBalance"),
    @NamedQuery(name = "SOSalesOrder.findByReturnDate", query = "SELECT s FROM SOSalesOrder s WHERE s.returnDate = :returnDate"),
    @NamedQuery(name = "SOSalesOrder.findByReturnRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.returnRemarks = :returnRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByReturnSubTotal", query = "SELECT s FROM SOSalesOrder s WHERE s.returnSubTotal = :returnSubTotal"),
    @NamedQuery(name = "SOSalesOrder.findByReturnTax1", query = "SELECT s FROM SOSalesOrder s WHERE s.returnTax1 = :returnTax1"),
    @NamedQuery(name = "SOSalesOrder.findByReturnTax2", query = "SELECT s FROM SOSalesOrder s WHERE s.returnTax2 = :returnTax2"),
    @NamedQuery(name = "SOSalesOrder.findByReturnExtra", query = "SELECT s FROM SOSalesOrder s WHERE s.returnExtra = :returnExtra"),
    @NamedQuery(name = "SOSalesOrder.findByReturnTotal", query = "SELECT s FROM SOSalesOrder s WHERE s.returnTotal = :returnTotal"),
    @NamedQuery(name = "SOSalesOrder.findByReturnFee", query = "SELECT s FROM SOSalesOrder s WHERE s.returnFee = :returnFee"),
    @NamedQuery(name = "SOSalesOrder.findByReturnRefunded", query = "SELECT s FROM SOSalesOrder s WHERE s.returnRefunded = :returnRefunded"),
    @NamedQuery(name = "SOSalesOrder.findByReturnCredit", query = "SELECT s FROM SOSalesOrder s WHERE s.returnCredit = :returnCredit"),
    @NamedQuery(name = "SOSalesOrder.findByRestockRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.restockRemarks = :restockRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByContactName", query = "SELECT s FROM SOSalesOrder s WHERE s.contactName = :contactName"),
    @NamedQuery(name = "SOSalesOrder.findByPhone", query = "SELECT s FROM SOSalesOrder s WHERE s.phone = :phone"),
    @NamedQuery(name = "SOSalesOrder.findByBillingAddress1", query = "SELECT s FROM SOSalesOrder s WHERE s.billingAddress1 = :billingAddress1"),
    @NamedQuery(name = "SOSalesOrder.findByBillingAddress2", query = "SELECT s FROM SOSalesOrder s WHERE s.billingAddress2 = :billingAddress2"),
    @NamedQuery(name = "SOSalesOrder.findByBillingCity", query = "SELECT s FROM SOSalesOrder s WHERE s.billingCity = :billingCity"),
    @NamedQuery(name = "SOSalesOrder.findByBillingState", query = "SELECT s FROM SOSalesOrder s WHERE s.billingState = :billingState"),
    @NamedQuery(name = "SOSalesOrder.findByBillingCountry", query = "SELECT s FROM SOSalesOrder s WHERE s.billingCountry = :billingCountry"),
    @NamedQuery(name = "SOSalesOrder.findByBillingPostalCode", query = "SELECT s FROM SOSalesOrder s WHERE s.billingPostalCode = :billingPostalCode"),
    @NamedQuery(name = "SOSalesOrder.findByBillingAddressRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.billingAddressRemarks = :billingAddressRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByBillingAddressType", query = "SELECT s FROM SOSalesOrder s WHERE s.billingAddressType = :billingAddressType"),
    @NamedQuery(name = "SOSalesOrder.findByShippingAddress1", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingAddress1 = :shippingAddress1"),
    @NamedQuery(name = "SOSalesOrder.findByShippingAddress2", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingAddress2 = :shippingAddress2"),
    @NamedQuery(name = "SOSalesOrder.findByShippingCity", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingCity = :shippingCity"),
    @NamedQuery(name = "SOSalesOrder.findByShippingState", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingState = :shippingState"),
    @NamedQuery(name = "SOSalesOrder.findByShippingCountry", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingCountry = :shippingCountry"),
    @NamedQuery(name = "SOSalesOrder.findByShippingPostalCode", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingPostalCode = :shippingPostalCode"),
    @NamedQuery(name = "SOSalesOrder.findByShippingAddressRemarks", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingAddressRemarks = :shippingAddressRemarks"),
    @NamedQuery(name = "SOSalesOrder.findByShippingAddressType", query = "SELECT s FROM SOSalesOrder s WHERE s.shippingAddressType = :shippingAddressType"),
    @NamedQuery(name = "SOSalesOrder.findByCustom1", query = "SELECT s FROM SOSalesOrder s WHERE s.custom1 = :custom1"),
    @NamedQuery(name = "SOSalesOrder.findByCustom2", query = "SELECT s FROM SOSalesOrder s WHERE s.custom2 = :custom2"),
    @NamedQuery(name = "SOSalesOrder.findByCustom3", query = "SELECT s FROM SOSalesOrder s WHERE s.custom3 = :custom3"),
    @NamedQuery(name = "SOSalesOrder.findByCustom4", query = "SELECT s FROM SOSalesOrder s WHERE s.custom4 = :custom4"),
    @NamedQuery(name = "SOSalesOrder.findByCustom5", query = "SELECT s FROM SOSalesOrder s WHERE s.custom5 = :custom5"),
    @NamedQuery(name = "SOSalesOrder.findByLastModDttm", query = "SELECT s FROM SOSalesOrder s WHERE s.lastModDttm = :lastModDttm"),
    @NamedQuery(name = "SOSalesOrder.findByAutoInvoice", query = "SELECT s FROM SOSalesOrder s WHERE s.autoInvoice = :autoInvoice"),
    @NamedQuery(name = "SOSalesOrder.findBySplitPartNumber", query = "SELECT s FROM SOSalesOrder s WHERE s.splitPartNumber = :splitPartNumber"),
    @NamedQuery(name = "SOSalesOrder.findByTaxOnShipping", query = "SELECT s FROM SOSalesOrder s WHERE s.taxOnShipping = :taxOnShipping"),
    @NamedQuery(name = "SOSalesOrder.findByLocationId", query = "SELECT s FROM SOSalesOrder s WHERE s.locationId = :locationId"),
    @NamedQuery(name = "SOSalesOrder.findByIsFullWorkflow", query = "SELECT s FROM SOSalesOrder s WHERE s.isFullWorkflow = :isFullWorkflow"),
    @NamedQuery(name = "SOSalesOrder.findByShowShipping", query = "SELECT s FROM SOSalesOrder s WHERE s.showShipping = :showShipping"),
    @NamedQuery(name = "SOSalesOrder.findByShipToCompanyName", query = "SELECT s FROM SOSalesOrder s WHERE s.shipToCompanyName = :shipToCompanyName"),
    @NamedQuery(name = "SOSalesOrder.findByExchangeRate", query = "SELECT s FROM SOSalesOrder s WHERE s.exchangeRate = :exchangeRate")})
public class SOSalesOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SalesOrderId")
    private Integer salesOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderStatus")
    private int orderStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "OrderNumber")
    private String orderNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SalesRep")
    private String salesRep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PONumber")
    private String pONumber;
    @Column(name = "RequestShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestShipDate;
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CalculatedDueDate")
    private boolean calculatedDueDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "OrderRemarks")
    private String orderRemarks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderSubTotal")
    private BigDecimal orderSubTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderTax1")
    private BigDecimal orderTax1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderTax2")
    private BigDecimal orderTax2;
    @Column(name = "OrderExtra")
    private BigDecimal orderExtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderTotal")
    private BigDecimal orderTotal;
    @Column(name = "Tax1Rate")
    private BigDecimal tax1Rate;
    @Column(name = "Tax2Rate")
    private BigDecimal tax2Rate;
    @Column(name = "CalculateTax2OnTax1")
    private Boolean calculateTax2OnTax1;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Column(name = "PickedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "PickingRemarks")
    private String pickingRemarks;
    @Column(name = "PackedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date packedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "PackingRemarks")
    private String packingRemarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ShippingRemarks")
    private String shippingRemarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsStandAloneInvoice")
    private boolean isStandAloneInvoice;
    @Column(name = "InvoicedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoicedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "InvoiceRemarks")
    private String invoiceRemarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceSubTotal")
    private BigDecimal invoiceSubTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceTax1")
    private BigDecimal invoiceTax1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceTax2")
    private BigDecimal invoiceTax2;
    @Column(name = "InvoiceExtra")
    private BigDecimal invoiceExtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceTotal")
    private BigDecimal invoiceTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AmountPaid")
    private BigDecimal amountPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceBalance")
    private BigDecimal invoiceBalance;
    @Column(name = "ReturnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ReturnRemarks")
    private String returnRemarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnSubTotal")
    private BigDecimal returnSubTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnTax1")
    private BigDecimal returnTax1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnTax2")
    private BigDecimal returnTax2;
    @Column(name = "ReturnExtra")
    private BigDecimal returnExtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnTotal")
    private BigDecimal returnTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnFee")
    private BigDecimal returnFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnRefunded")
    private BigDecimal returnRefunded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReturnCredit")
    private BigDecimal returnCredit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "RestockRemarks")
    private String restockRemarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ContactName")
    private String contactName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BillingAddress1")
    private String billingAddress1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BillingAddress2")
    private String billingAddress2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BillingCity")
    private String billingCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BillingState")
    private String billingState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BillingCountry")
    private String billingCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BillingPostalCode")
    private String billingPostalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "BillingAddressRemarks")
    private String billingAddressRemarks;
    @Column(name = "BillingAddressType")
    private Integer billingAddressType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShippingAddress1")
    private String shippingAddress1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShippingAddress2")
    private String shippingAddress2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShippingCity")
    private String shippingCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ShippingState")
    private String shippingState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShippingCountry")
    private String shippingCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ShippingPostalCode")
    private String shippingPostalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ShippingAddressRemarks")
    private String shippingAddressRemarks;
    @Column(name = "ShippingAddressType")
    private Integer shippingAddressType;
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
    @Column(name = "AutoInvoice")
    private boolean autoInvoice;
    @Column(name = "SplitPartNumber")
    private Integer splitPartNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TaxOnShipping")
    private boolean taxOnShipping;
    @Column(name = "LocationId")
    private Integer locationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsFullWorkflow")
    private boolean isFullWorkflow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShowShipping")
    private boolean showShipping;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ShipToCompanyName")
    private String shipToCompanyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExchangeRate")
    private BigDecimal exchangeRate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderId")
    private List<SOSalesOrderLine> sOSalesOrderLineList;
    @OneToMany(mappedBy = "parentSalesOrderId")
    private List<SOSalesOrder> sOSalesOrderList;
    @JoinColumn(name = "ParentSalesOrderId", referencedColumnName = "SalesOrderId")
    @ManyToOne
    private SOSalesOrder parentSalesOrderId;
    @JoinColumn(name = "CurrencyId", referencedColumnName = "CurrencyId")
    @ManyToOne(optional = false)
    private GLOBALCurrency currencyId;
    @JoinColumn(name = "LastModUserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private BASEUser lastModUserId;
    @JoinColumn(name = "PricingSchemeId", referencedColumnName = "PricingSchemeId")
    @ManyToOne
    private BASEPricingScheme pricingSchemeId;
    @JoinColumn(name = "PaymentTermsId", referencedColumnName = "PaymentTermsId")
    @ManyToOne
    private BASEPaymentTerms paymentTermsId;
    @JoinColumn(name = "OrderTaxCodeId", referencedColumnName = "OrderTaxCodeId")
    @ManyToOne(optional = false)
    private BASEOrderTaxCode orderTaxCodeId;
    @JoinColumn(name = "ReturnInventoryBatchLogId", referencedColumnName = "InventoryLogBatchId")
    @ManyToOne
    private BASEInventoryLogBatch returnInventoryBatchLogId;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private BASECustomer customerId;

    public SOSalesOrder() {
    }

    public SOSalesOrder(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public SOSalesOrder(Integer salesOrderId, int version, int orderStatus, String orderNumber, Date orderDate, String salesRep, String pONumber, boolean calculatedDueDate, String orderRemarks, BigDecimal orderSubTotal, BigDecimal orderTax1, BigDecimal orderTax2, BigDecimal orderTotal, String tax1Name, String tax2Name, String email, String pickingRemarks, String packingRemarks, String shippingRemarks, boolean isStandAloneInvoice, String invoiceRemarks, BigDecimal invoiceSubTotal, BigDecimal invoiceTax1, BigDecimal invoiceTax2, BigDecimal invoiceTotal, BigDecimal amountPaid, BigDecimal invoiceBalance, String returnRemarks, BigDecimal returnSubTotal, BigDecimal returnTax1, BigDecimal returnTax2, BigDecimal returnTotal, BigDecimal returnFee, BigDecimal returnRefunded, BigDecimal returnCredit, String restockRemarks, String contactName, String phone, String billingAddress1, String billingAddress2, String billingCity, String billingState, String billingCountry, String billingPostalCode, String billingAddressRemarks, String shippingAddress1, String shippingAddress2, String shippingCity, String shippingState, String shippingCountry, String shippingPostalCode, String shippingAddressRemarks, String custom1, String custom2, String custom3, String custom4, String custom5, Date lastModDttm, byte[] timestamp, boolean autoInvoice, boolean taxOnShipping, boolean isFullWorkflow, boolean showShipping, String shipToCompanyName, BigDecimal exchangeRate) {
        this.salesOrderId = salesOrderId;
        this.version = version;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.salesRep = salesRep;
        this.pONumber = pONumber;
        this.calculatedDueDate = calculatedDueDate;
        this.orderRemarks = orderRemarks;
        this.orderSubTotal = orderSubTotal;
        this.orderTax1 = orderTax1;
        this.orderTax2 = orderTax2;
        this.orderTotal = orderTotal;
        this.tax1Name = tax1Name;
        this.tax2Name = tax2Name;
        this.email = email;
        this.pickingRemarks = pickingRemarks;
        this.packingRemarks = packingRemarks;
        this.shippingRemarks = shippingRemarks;
        this.isStandAloneInvoice = isStandAloneInvoice;
        this.invoiceRemarks = invoiceRemarks;
        this.invoiceSubTotal = invoiceSubTotal;
        this.invoiceTax1 = invoiceTax1;
        this.invoiceTax2 = invoiceTax2;
        this.invoiceTotal = invoiceTotal;
        this.amountPaid = amountPaid;
        this.invoiceBalance = invoiceBalance;
        this.returnRemarks = returnRemarks;
        this.returnSubTotal = returnSubTotal;
        this.returnTax1 = returnTax1;
        this.returnTax2 = returnTax2;
        this.returnTotal = returnTotal;
        this.returnFee = returnFee;
        this.returnRefunded = returnRefunded;
        this.returnCredit = returnCredit;
        this.restockRemarks = restockRemarks;
        this.contactName = contactName;
        this.phone = phone;
        this.billingAddress1 = billingAddress1;
        this.billingAddress2 = billingAddress2;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.billingAddressRemarks = billingAddressRemarks;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingCountry = shippingCountry;
        this.shippingPostalCode = shippingPostalCode;
        this.shippingAddressRemarks = shippingAddressRemarks;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
        this.custom4 = custom4;
        this.custom5 = custom5;
        this.lastModDttm = lastModDttm;
        this.timestamp = timestamp;
        this.autoInvoice = autoInvoice;
        this.taxOnShipping = taxOnShipping;
        this.isFullWorkflow = isFullWorkflow;
        this.showShipping = showShipping;
        this.shipToCompanyName = shipToCompanyName;
        this.exchangeRate = exchangeRate;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getPONumber() {
        return pONumber;
    }

    public void setPONumber(String pONumber) {
        this.pONumber = pONumber;
    }

    public Date getRequestShipDate() {
        return requestShipDate;
    }

    public void setRequestShipDate(Date requestShipDate) {
        this.requestShipDate = requestShipDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getCalculatedDueDate() {
        return calculatedDueDate;
    }

    public void setCalculatedDueDate(boolean calculatedDueDate) {
        this.calculatedDueDate = calculatedDueDate;
    }

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    public BigDecimal getOrderSubTotal() {
        return orderSubTotal;
    }

    public void setOrderSubTotal(BigDecimal orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public BigDecimal getOrderTax1() {
        return orderTax1;
    }

    public void setOrderTax1(BigDecimal orderTax1) {
        this.orderTax1 = orderTax1;
    }

    public BigDecimal getOrderTax2() {
        return orderTax2;
    }

    public void setOrderTax2(BigDecimal orderTax2) {
        this.orderTax2 = orderTax2;
    }

    public BigDecimal getOrderExtra() {
        return orderExtra;
    }

    public void setOrderExtra(BigDecimal orderExtra) {
        this.orderExtra = orderExtra;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
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

    public Boolean getCalculateTax2OnTax1() {
        return calculateTax2OnTax1;
    }

    public void setCalculateTax2OnTax1(Boolean calculateTax2OnTax1) {
        this.calculateTax2OnTax1 = calculateTax2OnTax1;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getPickedDate() {
        return pickedDate;
    }

    public void setPickedDate(Date pickedDate) {
        this.pickedDate = pickedDate;
    }

    public String getPickingRemarks() {
        return pickingRemarks;
    }

    public void setPickingRemarks(String pickingRemarks) {
        this.pickingRemarks = pickingRemarks;
    }

    public Date getPackedDate() {
        return packedDate;
    }

    public void setPackedDate(Date packedDate) {
        this.packedDate = packedDate;
    }

    public String getPackingRemarks() {
        return packingRemarks;
    }

    public void setPackingRemarks(String packingRemarks) {
        this.packingRemarks = packingRemarks;
    }

    public String getShippingRemarks() {
        return shippingRemarks;
    }

    public void setShippingRemarks(String shippingRemarks) {
        this.shippingRemarks = shippingRemarks;
    }

    public boolean getIsStandAloneInvoice() {
        return isStandAloneInvoice;
    }

    public void setIsStandAloneInvoice(boolean isStandAloneInvoice) {
        this.isStandAloneInvoice = isStandAloneInvoice;
    }

    public Date getInvoicedDate() {
        return invoicedDate;
    }

    public void setInvoicedDate(Date invoicedDate) {
        this.invoicedDate = invoicedDate;
    }

    public String getInvoiceRemarks() {
        return invoiceRemarks;
    }

    public void setInvoiceRemarks(String invoiceRemarks) {
        this.invoiceRemarks = invoiceRemarks;
    }

    public BigDecimal getInvoiceSubTotal() {
        return invoiceSubTotal;
    }

    public void setInvoiceSubTotal(BigDecimal invoiceSubTotal) {
        this.invoiceSubTotal = invoiceSubTotal;
    }

    public BigDecimal getInvoiceTax1() {
        return invoiceTax1;
    }

    public void setInvoiceTax1(BigDecimal invoiceTax1) {
        this.invoiceTax1 = invoiceTax1;
    }

    public BigDecimal getInvoiceTax2() {
        return invoiceTax2;
    }

    public void setInvoiceTax2(BigDecimal invoiceTax2) {
        this.invoiceTax2 = invoiceTax2;
    }

    public BigDecimal getInvoiceExtra() {
        return invoiceExtra;
    }

    public void setInvoiceExtra(BigDecimal invoiceExtra) {
        this.invoiceExtra = invoiceExtra;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public BigDecimal getInvoiceBalance() {
        return invoiceBalance;
    }

    public void setInvoiceBalance(BigDecimal invoiceBalance) {
        this.invoiceBalance = invoiceBalance;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnRemarks() {
        return returnRemarks;
    }

    public void setReturnRemarks(String returnRemarks) {
        this.returnRemarks = returnRemarks;
    }

    public BigDecimal getReturnSubTotal() {
        return returnSubTotal;
    }

    public void setReturnSubTotal(BigDecimal returnSubTotal) {
        this.returnSubTotal = returnSubTotal;
    }

    public BigDecimal getReturnTax1() {
        return returnTax1;
    }

    public void setReturnTax1(BigDecimal returnTax1) {
        this.returnTax1 = returnTax1;
    }

    public BigDecimal getReturnTax2() {
        return returnTax2;
    }

    public void setReturnTax2(BigDecimal returnTax2) {
        this.returnTax2 = returnTax2;
    }

    public BigDecimal getReturnExtra() {
        return returnExtra;
    }

    public void setReturnExtra(BigDecimal returnExtra) {
        this.returnExtra = returnExtra;
    }

    public BigDecimal getReturnTotal() {
        return returnTotal;
    }

    public void setReturnTotal(BigDecimal returnTotal) {
        this.returnTotal = returnTotal;
    }

    public BigDecimal getReturnFee() {
        return returnFee;
    }

    public void setReturnFee(BigDecimal returnFee) {
        this.returnFee = returnFee;
    }

    public BigDecimal getReturnRefunded() {
        return returnRefunded;
    }

    public void setReturnRefunded(BigDecimal returnRefunded) {
        this.returnRefunded = returnRefunded;
    }

    public BigDecimal getReturnCredit() {
        return returnCredit;
    }

    public void setReturnCredit(BigDecimal returnCredit) {
        this.returnCredit = returnCredit;
    }

    public String getRestockRemarks() {
        return restockRemarks;
    }

    public void setRestockRemarks(String restockRemarks) {
        this.restockRemarks = restockRemarks;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingAddressRemarks() {
        return billingAddressRemarks;
    }

    public void setBillingAddressRemarks(String billingAddressRemarks) {
        this.billingAddressRemarks = billingAddressRemarks;
    }

    public Integer getBillingAddressType() {
        return billingAddressType;
    }

    public void setBillingAddressType(Integer billingAddressType) {
        this.billingAddressType = billingAddressType;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingAddressRemarks() {
        return shippingAddressRemarks;
    }

    public void setShippingAddressRemarks(String shippingAddressRemarks) {
        this.shippingAddressRemarks = shippingAddressRemarks;
    }

    public Integer getShippingAddressType() {
        return shippingAddressType;
    }

    public void setShippingAddressType(Integer shippingAddressType) {
        this.shippingAddressType = shippingAddressType;
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

    public boolean getAutoInvoice() {
        return autoInvoice;
    }

    public void setAutoInvoice(boolean autoInvoice) {
        this.autoInvoice = autoInvoice;
    }

    public Integer getSplitPartNumber() {
        return splitPartNumber;
    }

    public void setSplitPartNumber(Integer splitPartNumber) {
        this.splitPartNumber = splitPartNumber;
    }

    public boolean getTaxOnShipping() {
        return taxOnShipping;
    }

    public void setTaxOnShipping(boolean taxOnShipping) {
        this.taxOnShipping = taxOnShipping;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public boolean getIsFullWorkflow() {
        return isFullWorkflow;
    }

    public void setIsFullWorkflow(boolean isFullWorkflow) {
        this.isFullWorkflow = isFullWorkflow;
    }

    public boolean getShowShipping() {
        return showShipping;
    }

    public void setShowShipping(boolean showShipping) {
        this.showShipping = showShipping;
    }

    public String getShipToCompanyName() {
        return shipToCompanyName;
    }

    public void setShipToCompanyName(String shipToCompanyName) {
        this.shipToCompanyName = shipToCompanyName;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @XmlTransient
    public List<SOSalesOrderLine> getSOSalesOrderLineList() {
        return sOSalesOrderLineList;
    }

    public void setSOSalesOrderLineList(List<SOSalesOrderLine> sOSalesOrderLineList) {
        this.sOSalesOrderLineList = sOSalesOrderLineList;
    }

    @XmlTransient
    public List<SOSalesOrder> getSOSalesOrderList() {
        return sOSalesOrderList;
    }

    public void setSOSalesOrderList(List<SOSalesOrder> sOSalesOrderList) {
        this.sOSalesOrderList = sOSalesOrderList;
    }

    public SOSalesOrder getParentSalesOrderId() {
        return parentSalesOrderId;
    }

    public void setParentSalesOrderId(SOSalesOrder parentSalesOrderId) {
        this.parentSalesOrderId = parentSalesOrderId;
    }

    public GLOBALCurrency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(GLOBALCurrency currencyId) {
        this.currencyId = currencyId;
    }

    public BASEUser getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(BASEUser lastModUserId) {
        this.lastModUserId = lastModUserId;
    }

    public BASEPricingScheme getPricingSchemeId() {
        return pricingSchemeId;
    }

    public void setPricingSchemeId(BASEPricingScheme pricingSchemeId) {
        this.pricingSchemeId = pricingSchemeId;
    }

    public BASEPaymentTerms getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(BASEPaymentTerms paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public BASEOrderTaxCode getOrderTaxCodeId() {
        return orderTaxCodeId;
    }

    public void setOrderTaxCodeId(BASEOrderTaxCode orderTaxCodeId) {
        this.orderTaxCodeId = orderTaxCodeId;
    }

    public BASEInventoryLogBatch getReturnInventoryBatchLogId() {
        return returnInventoryBatchLogId;
    }

    public void setReturnInventoryBatchLogId(BASEInventoryLogBatch returnInventoryBatchLogId) {
        this.returnInventoryBatchLogId = returnInventoryBatchLogId;
    }

    public BASECustomer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BASECustomer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesOrderId != null ? salesOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SOSalesOrder)) {
            return false;
        }
        SOSalesOrder other = (SOSalesOrder) object;
        if ((this.salesOrderId == null && other.salesOrderId != null) || (this.salesOrderId != null && !this.salesOrderId.equals(other.salesOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summitthai.inflow.entity.SOSalesOrder[ salesOrderId=" + salesOrderId + " ]";
    }
    
}
