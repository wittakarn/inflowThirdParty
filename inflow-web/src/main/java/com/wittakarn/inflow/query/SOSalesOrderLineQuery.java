/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.query;

import com.wittakarn.inflow.entity.SOSalesOrderLine;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wittakarn
 */
public class SOSalesOrderLineQuery implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(SOSalesOrderLineQuery.class.getName());
    
    public static List<SOSalesOrderLine> getOrderLineList(EntityManager em, Integer salesOrderId){
        logger.info("Begin SOSalesOrderLineQuery.getOrderLineList...");
        StringBuffer sb = null;
        Query query = null;
        try {
            sb = new StringBuffer();
            sb.append("SELECT ssl ");
            sb.append("FROM SOSalesOrderLine ssl ");
            sb.append("WHERE ssl.salesOrderId.salesOrderId = :salesOrderId");

            query = em.createQuery(sb.toString());
            query.setParameter("salesOrderId", salesOrderId);
            return query.getResultList();
        } finally {
            sb = null;
            query = null;
            logger.info("End SOSalesOrderLineQuery.getOrderLineList...");
        }
    }
}
