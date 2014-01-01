/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.view;

import com.wittakarn.inflow.entity.BASECompany;
import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.entity.BASEFileAttachment;
import com.wittakarn.inflow.entity.SOSalesOrder;
import com.wittakarn.inflow.entity.SOSalesOrderLine;
import com.wittakarn.inflow.interfaces.InvoiceServiceable;
import com.wittakarn.inflow.jasper.JasperContext;
import com.wittakarn.inflow.model.CustomerForm;
import com.wittakarn.inflow.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Wittakarn
 */
@ManagedBean(name = "invoiceBean")
@ViewScoped
public class InvoiceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(InvoiceBean.class.getName());

    private String customerName;
    private Date orderDate;
    private List<CustomerForm> customerFormList;

    @EJB
    private InvoiceServiceable invoiceServiceable;

    public InvoiceBean() {
    }

    @PostConstruct
    public void init() {
        logger.info("Begin init...");
    }

    public void searchCustomerOrder(ActionEvent event) {
        BASECustomer baseCustomer;
        SOSalesOrder soSalesOrder;
        List<CustomerForm> cusFormList;
        try {
            logger.info("Begin searchCustomerOrder...");
            cusFormList = invoiceServiceable.getCustomerOrder(getCustomerName(), getOrderDate());
            logger.info("cusFormList.size() : " + cusFormList.size());
            customerFormList = cusFormList;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "", ex);
        } finally {
            baseCustomer = null;
            soSalesOrder = null;
            cusFormList = null;
            logger.info("End searchCustomerOrder...");
        }
    }

    public void manipolateData(ActionEvent event) {
        BASECustomer baseCustomer;
        SOSalesOrder soSalesOrder;
        CustomerForm customerFormSelected;

        try {
            customerFormSelected = (CustomerForm) event.getComponent().getAttributes().get("customerSelected");
            logger.info("Begin manipolateData...");
            baseCustomer = customerFormSelected.getBaseCustomer();
            soSalesOrder = customerFormSelected.getSoSalesOrder();

            JasperPrint print = JasperContext.initJasper("D:\\JavaProjects\\ireportFiles\\reportInvoice.jasper", createParameter(baseCustomer, soSalesOrder), createList(soSalesOrder));
            JasperContext.printPDF(print, getServletOutputStream());
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "", ex);
        } finally {
            baseCustomer = null;
            soSalesOrder = null;
            customerFormSelected = null;
            logger.info("End manipolateData...");
        }
    }

    private List<SOSalesOrderLine> createList(SOSalesOrder soSalesOrder) throws Exception {
        List<SOSalesOrderLine> orderLine = invoiceServiceable.getOrderList(soSalesOrder.getSalesOrderId());
        for (SOSalesOrderLine sOSalesOrderLine : orderLine) {
            sOSalesOrderLine.refreshData();
        }
        return orderLine;
    }

    private HashMap<String, Object> createParameter(BASECustomer baseCustomer, SOSalesOrder soSalesOrder) throws Exception {
        BASECompany company = invoiceServiceable.getCompany(1);
        BASEFileAttachment fileAttachment = company.getPictureFileAttachmentId();
        String[] content = {baseCustomer.getAddress2(), baseCustomer.getCity(), baseCustomer.getState(), baseCustomer.getCountry(), baseCustomer.getPostalCode()};
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("Picture", new ByteArrayInputStream(fileAttachment.getData()));
        parameters.put("Name", baseCustomer.getName());
        parameters.put("Address1", baseCustomer.getAddress1());
        parameters.put("Address2", StringUtils.concatString(content));
        parameters.put("Phone", company.getPhone());
        parameters.put("Fax", baseCustomer.getFax());
        parameters.put("TaxNumber", company.getTaxNumber());
        parameters.put("OrderNumber", soSalesOrder.getOrderNumber());
        parameters.put("OrderDate", soSalesOrder.getOrderDate());
        parameters.put("PaymentName", soSalesOrder.getPaymentTermsId().getName());
        parameters.put("OrderRemarks", soSalesOrder.getOrderRemarks());
        parameters.put("OrderTax1", soSalesOrder.getOrderTax1());

        return parameters;
    }

    private ServletOutputStream getServletOutputStream() throws Exception {
        FacesContext faceContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) faceContext.getExternalContext().getResponse();
        //response.setHeader("Content-disposition", "attachment; filename=invoice.pdf");

        return response.getOutputStream();
    }

    /**
     * @return the customerFormList
     */
    public List<CustomerForm> getCustomerFormList() {
        return customerFormList;
    }

    /**
     * @param customerFormList the customerFormList to set
     */
    public void setCustomerFormList(List<CustomerForm> customerFormList) {
        this.customerFormList = customerFormList;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
