/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.query;

import com.summitthai.sdd.sys.util.StringUtils;
import com.wittakarn.inflow.entity.SOSalesOrder;
import com.wittakarn.inflow.entity.SOSalesOrderLine;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wittakarn
 */
public class SOSalesOrderQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(SOSalesOrderQuery.class.getName());

    public static List<SOSalesOrder> customerListQuery(EntityManager em, Integer customerId, Date date) {
        logger.info("Begin SOSalesOrderQuery.customerListQuery...");
        StringBuffer sb = null;
        Query query = null;
        boolean isFirst = true;
        try {
            sb = new StringBuffer();
            sb.append("SELECT ss ");
            sb.append("FROM SOSalesOrder ss");
            if (customerId != null) {
                sb.append((isFirst ? " WHERE " : " AND "));
                isFirst = false;
                sb.append("ss.customerId = :customerId ");
            }
            if (date != null) {
                sb.append((isFirst ? " WHERE " : " AND "));
                isFirst = false;
                sb.append("ss.orderDate = :date ");
            }
            logger.info("SOSalesOrderQuery.customerListQuery :".concat(sb.toString()));
            query = em.createQuery(sb.toString());

            if (customerId != null) {
                query.setParameter("customerId", customerId);
            }
            if (date != null) {
                query.setParameter("date", date);
            }

            return query.getResultList();
        } finally {
            sb = null;
            query = null;
            logger.info("End SOSalesOrderQuery.customerListQuery...");
        }
    }
}
