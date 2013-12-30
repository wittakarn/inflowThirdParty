/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.ejb;

import com.wittakarn.inflow.entity.BASECustomer;
import com.wittakarn.inflow.interfaces.InvoiceServiceable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wittakarn
 */
@Stateless(mappedName="invoiceService", name="InvoiceService")
public class InvoiceService implements InvoiceServiceable {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "inflowUnit")
    EntityManager em;

    @Override
    public BASECustomer serchCustomer(BASECustomer bc) throws Exception{
        return em.find(BASECustomer.class, bc.getCustomerId());
    }
}
