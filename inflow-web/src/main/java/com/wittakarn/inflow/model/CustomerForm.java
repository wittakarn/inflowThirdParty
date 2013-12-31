/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.model;

import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.entity.SOSalesOrder;
import java.io.Serializable;

/**
 *
 * @author Wittakarn
 */
public class CustomerForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private BASECustomer baseCustomer;
    private SOSalesOrder soSalesOrder;
    
    public CustomerForm(){
        baseCustomer = new BASECustomer();
        soSalesOrder = new SOSalesOrder();
    }
    
    public CustomerForm(BASECustomer baseCustomer, SOSalesOrder soSalesOrder){
        this.baseCustomer = baseCustomer;
        this.soSalesOrder = soSalesOrder;
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

    /**
     * @return the soSalesOrder
     */
    public SOSalesOrder getSoSalesOrder() {
        return soSalesOrder;
    }

    /**
     * @param soSalesOrder the soSalesOrder to set
     */
    public void setSoSalesOrder(SOSalesOrder soSalesOrder) {
        this.soSalesOrder = soSalesOrder;
    }
}
