/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.query;

import com.summitthai.sdd.sys.util.StringUtils;
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
public class BASECustomerQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(BASECustomerQuery.class.getName());

    public static List<Object[]> customerListQuery(EntityManager em, String name, Date date) {
        logger.info("Begin SOSalesOrderQuery.customerListQuery...");
        StringBuffer sb = null;
        Query query = null;
        try {
            sb = new StringBuffer();
            sb.append("SELECT bc, ss ");
            sb.append("FROM BASECustomer bc, SOSalesOrder ss ");
            sb.append("WHERE bc.customerId = ss.customerId.customerId ");
            if (!StringUtils.isNullOrEmpty(name)) {
                sb.append("AND bc.name LIKE '%").append(name).append("%' ");
            }
            if (date != null) {
                sb.append("AND ss.orderDate = :date ");
            }
            logger.info("SOSalesOrderQuery.customerListQuery :".concat(sb.toString()));
            query = em.createQuery(sb.toString());

            if (date != null) {
                date.setYear(113);
                query.setParameter("date", date);
                logger.info("date :".concat(date.toString()));
            }

            return query.getResultList();
        } finally {
            sb = null;
            query = null;
            logger.info("End SOSalesOrderQuery.customerListQuery...");
        }
    }
}
