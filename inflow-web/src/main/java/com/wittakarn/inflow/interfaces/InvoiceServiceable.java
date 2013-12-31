/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.interfaces;

import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.entity.SOSalesOrder;
import com.wittakarn.inflow.entity.SOSalesOrderLine;
import com.wittakarn.inflow.model.CustomerForm;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Wittakarn
 */
@Remote
public interface InvoiceServiceable extends Serializable{
    public BASECustomer serchCustomer(BASECustomer bc) throws Exception;
    public List<CustomerForm> getCustomerOrder(String name, Date date) throws Exception;
    public List<SOSalesOrderLine> getOrderList(Integer salesOrderId) throws Exception;
}
