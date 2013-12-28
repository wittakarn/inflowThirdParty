/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summitthai.inflow.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Wittakarn
 */
@Data
@Slf4j
@Named
@ConversationScoped
public class InputBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String surname;

    public InputBean() {
        name = "Wittakarn";
        surname = "Keeratichayakorn";
    }

    @PostConstruct
    public void init() {
    }
}
