/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wittakarn.inflow.interfaces;

import com.wittakarn.inflow.entity.BASECustomer;
import java.io.Serializable;
import javax.ejb.Remote;

/**
 *
 * @author Wittakarn
 */
@Remote
public interface InvoiceServiceable extends Serializable{
    public BASECustomer serchCustomer(BASECustomer bc) throws Exception;
}
