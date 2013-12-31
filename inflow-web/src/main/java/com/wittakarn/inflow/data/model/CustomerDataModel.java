/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wittakarn.inflow.data.model;

import com.wittakarn.inflow.model.CustomerForm;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Wittakarn
 */
public class CustomerDataModel extends ListDataModel<CustomerForm> implements SelectableDataModel<CustomerForm>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(CustomerDataModel.class.getName());

    public CustomerDataModel() {
    }

    public CustomerDataModel(List<CustomerForm> data) {
        super(data);
    }

    @Override
    public CustomerForm getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
        logger.info("rowKey = " + rowKey);
        List<CustomerForm> objects = (List<CustomerForm>) getWrappedData();

        for (CustomerForm c : objects) {
            if (c.getSoSalesOrder().getOrderNumber().equals(rowKey)) {
                return c;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(CustomerForm customerForm) {
        logger.info("customerForm.getSoSalesOrder().getOrderNumber() = " + customerForm.getSoSalesOrder().getOrderNumber());
        return customerForm.getSoSalesOrder().getOrderNumber();
    }

}
