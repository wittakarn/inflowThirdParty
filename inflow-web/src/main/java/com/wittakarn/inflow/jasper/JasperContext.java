/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.jasper;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Wittakarn
 */
public class JasperContext {
    public static JasperPrint initJasperContext(String path, HashMap<String, Object> hash,List<?> list) throws JRException{
        JRBeanCollectionDataSource jcDataSource = new JRBeanCollectionDataSource(list);
        return JasperFillManager.fillReport(path, hash, jcDataSource);
    }
    
    public static void printPDF(JasperPrint print, OutputStream out) throws JRException{
        JasperExportManager.exportReportToPdfStream(print, out);
    }
}
