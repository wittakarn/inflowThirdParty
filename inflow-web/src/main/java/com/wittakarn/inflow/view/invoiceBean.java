/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.view;

import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.interfaces.InvoiceServiceable;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wittakarn
 */
@Named
@ConversationScoped
public class invoiceBean implements Serializable{

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
    
    public void manipolateData(ActionEvent event){
        try{
            logger.info("baseCustomer.getCustomerId : " + baseCustomer.getCustomerId());
            
            baseCustomer = invoiceServiceable.serchCustomer(baseCustomer);
            
            logger.info("baseCustomer.getName : " + baseCustomer.getName());
        }catch(Exception ex){
            logger.log(Level.SEVERE, "", ex);
        }
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
