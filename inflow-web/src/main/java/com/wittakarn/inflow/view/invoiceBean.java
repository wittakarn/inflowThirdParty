/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.view;

import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.interfaces.InvoiceServiceable;
import com.wittakarn.inflow.jasper.JasperContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Wittakarn
 */
@Named
@ConversationScoped
public class invoiceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(invoiceBean.class.getName());

    private BASECustomer baseCustomer;

    @EJB
    private InvoiceServiceable invoiceServiceable;

    public invoiceBean() {
        baseCustomer = new BASECustomer();
    }

    @PostConstruct
    public void init() {
        logger.info("Begin init...");
    }

    public void manipolateData(ActionEvent event) {
        List<BASECustomer> bcList = null;
        try {
            logger.info("baseCustomer.getCustomerId : " + baseCustomer.getCustomerId());

            baseCustomer = invoiceServiceable.serchCustomer(baseCustomer);

//            bcList = invoiceServiceable.serchALLCustomer();

            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("Name", baseCustomer.getName());
            parameters.put("Address1", baseCustomer.getAddress1());
            parameters.put("Address2", baseCustomer.getAddress2());
            
            logger.info("parameters.get(\"Name\") : " + parameters.get("Name"));

            JasperPrint print = JasperContext.initJasper("D:\\JavaProjects\\ireportFiles\\reportInvoice.jasper", parameters, bcList);
            JasperContext.printPDF(print, getServletOutputStream());
            FacesContext.getCurrentInstance().responseComplete(); 
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "", ex);
        }
    }

    private ServletOutputStream getServletOutputStream() throws Exception {
        FacesContext faceContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) faceContext.getExternalContext().getResponse();
        //response.setHeader("Content-disposition", "attachment; filename=invoice.pdf");
        
        return response.getOutputStream();
    }

    /**
     * @return the baseCustomer
     */
    public BASECustomer getBaseCustomer() {
        return baseCustomer;
    }

    /**
     * @param baseCustomer the baseCustomer to set
     */
    public void setBaseCustomer(BASECustomer baseCustomer) {
        this.baseCustomer = baseCustomer;
    }

}
