/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.view;

import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.entity.SOSalesOrder;
import com.wittakarn.inflow.entity.SOSalesOrderLine;
import com.wittakarn.inflow.interfaces.InvoiceServiceable;
import com.wittakarn.inflow.jasper.JasperContext;
import com.wittakarn.inflow.model.CustomerForm;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
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
    
    private CustomerForm customerFormSearch;
    private List<CustomerForm> customerFormList;

    @EJB
    private InvoiceServiceable invoiceServiceable;

    public InvoiceBean() {
        customerFormSearch = new CustomerForm();
    }

    @PostConstruct
    public void init() {
        logger.info("Begin init...");
    }
    
    public void searchCustomerOrder(ActionEvent event){
        BASECustomer baseCustomer;
        SOSalesOrder soSalesOrder;
        List<CustomerForm> cusFormList;
        try{
            baseCustomer = getCustomerFormSearch().getBaseCustomer();
            soSalesOrder = getCustomerFormSearch().getSoSalesOrder();
            logger.info("baseCustomer.getCustomerId : " + baseCustomer.getCustomerId());
            
            cusFormList = invoiceServiceable.getCustomerOrder(baseCustomer.getName(), soSalesOrder.getOrderDate());
            logger.info("cusFormList.size() : " + cusFormList.size());
            customerFormList = cusFormList;
        }catch(Exception ex){
            logger.log(Level.SEVERE, "", ex);
        }finally{
            
        }
    }

    public void manipolateData(ActionEvent event) {
        BASECustomer baseCustomer;
        SOSalesOrder soSalesOrder;
        CustomerForm customerFormSelected;
        List<SOSalesOrderLine> orderLine;
        byte[] image;
        try {
            customerFormSelected = (CustomerForm) event.getComponent().getAttributes().get("customerSelected");
            logger.info("Begin manipolateData...");
            baseCustomer = customerFormSelected.getBaseCustomer();
            soSalesOrder = customerFormSelected.getSoSalesOrder();
            
            orderLine = invoiceServiceable.getOrderList(soSalesOrder.getSalesOrderId());
            image = invoiceServiceable.getCompanyImage(1);
            
            for (Iterator<SOSalesOrderLine> it = orderLine.iterator(); it.hasNext();) {
                SOSalesOrderLine sOSalesOrderLine = it.next();
                sOSalesOrderLine.refreshData();
            }
            
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Name", baseCustomer.getName());
            parameters.put("Address1", baseCustomer.getAddress1());
            parameters.put("Address2", baseCustomer.getAddress2());
            parameters.put("Picture", new ByteArrayInputStream(image));
            
            logger.log(Level.INFO, "parameters.get(\"Name\") : {0}", parameters.get("Name"));

            JasperPrint print = JasperContext.initJasper("D:\\JavaProjects\\ireportFiles\\reportInvoice.jasper", parameters, orderLine);
            JasperContext.printPDF(print, getServletOutputStream());
            FacesContext.getCurrentInstance().responseComplete(); 
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "", ex);
        }finally{
            baseCustomer = null;
            soSalesOrder = null;
            customerFormSelected = null;
            orderLine = null;
            image = null;
            logger.info("End manipolateData...");
        }
    }

    private ServletOutputStream getServletOutputStream() throws Exception {
        FacesContext faceContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) faceContext.getExternalContext().getResponse();
        //response.setHeader("Content-disposition", "attachment; filename=invoice.pdf");
        
        return response.getOutputStream();
    }

    /**
     * @return the customerFormSearch
     */
    public CustomerForm getCustomerFormSearch() {
        return customerFormSearch;
    }

    /**
     * @param customerFormSearch the customerFormSearch to set
     */
    public void setCustomerFormSearch(CustomerForm customerFormSearch) {
        this.customerFormSearch = customerFormSearch;
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

}
