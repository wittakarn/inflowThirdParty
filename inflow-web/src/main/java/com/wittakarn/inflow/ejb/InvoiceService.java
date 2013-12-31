/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.ejb;

import com.wittakarn.inflow.entity.BASECompany;
import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.entity.SOSalesOrder;
import com.wittakarn.inflow.entity.SOSalesOrderLine;
import com.wittakarn.inflow.interfaces.InvoiceServiceable;
import com.wittakarn.inflow.model.CustomerForm;
import com.wittakarn.inflow.query.BASECustomerQuery;
import com.wittakarn.inflow.query.SOSalesOrderLineQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wittakarn
 */
@Stateless(mappedName = "invoiceService", name = "InvoiceService")
public class InvoiceService implements InvoiceServiceable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(InvoiceService.class.getName());

    @PersistenceContext(unitName = "inflowUnit")
    EntityManager em;

    @Override
    public BASECustomer serchCustomer(BASECustomer bc) throws Exception {
        return em.find(BASECustomer.class, bc.getCustomerId());
    }

    @Override
    public List<CustomerForm> getCustomerOrder(String name, Date date) throws Exception {
        List<CustomerForm> customerFormList = new ArrayList<CustomerForm>();
        List<Object[]> objList = null;
        try {
            objList = BASECustomerQuery.customerListQuery(em, name, date);
            logger.info("objList.size() = " + objList.size());
            for (Iterator<Object[]> it = objList.iterator(); it.hasNext();) {
                Object[] objects = it.next();
                CustomerForm customerForm = new CustomerForm((BASECustomer) objects[0], (SOSalesOrder) objects[1]);
                customerFormList.add(customerForm);
            }

            return customerFormList;
        } catch (Exception ex) {
            throw ex;
        } finally {
            objList = null;
            customerFormList = null;
        }
    }

    @Override
    public List<SOSalesOrderLine> getOrderList(Integer salesOrderId) throws Exception {
        return SOSalesOrderLineQuery.getOrderLineList(em, salesOrderId);
    }
    
    @Override
    public byte[] getCompanyImage(Integer companyId) throws Exception{
        return em.find(BASECompany.class, companyId).getPictureFileAttachmentId().getData();
    }
}
