/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.jasper;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Wittakarn
 */
public class JasperContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(JasperContext.class.getName());

    public static JasperPrint initJasper(String path, HashMap<String, Object> param, List<?> list) throws JRException {
        if (list == null) {
            return initJasperContext(path, param);
        } else {
            return initJasperContext(path, param, list);
        }
    }

    public static JasperPrint initJasperContext(String path, HashMap<String, Object> param) throws JRException {
        logger.info("Call initJasperContext without list");
        return JasperFillManager.fillReport(path, param, new JREmptyDataSource());
    }

    public static JasperPrint initJasperContext(String path, HashMap<String, Object> param, List<?> list) throws JRException {
        logger.info("Call initJasperContext have a list");
        JRBeanCollectionDataSource jcDataSource = new JRBeanCollectionDataSource(list);
        return JasperFillManager.fillReport(path, param, jcDataSource);
    }

    public static void printPDF(JasperPrint print, OutputStream out) throws JRException {
        JasperExportManager.exportReportToPdfStream(print, out);
    }
}
