/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summitthai.inflow.view;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author Wittakarn
 */
@Named
@ConversationScoped
public class InputBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(InputBean.class.getName());
    
    private String name;
    private String surname;

    public InputBean() {
        name = "Wittakarn";
        surname = "Keeratichayakorn";
    }

    @PostConstruct
    public void init() {
        logger.info("Begin init...");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
