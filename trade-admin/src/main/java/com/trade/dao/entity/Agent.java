package com.trade.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ben.Huang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
    private String provinces;
    private String city;

    public void setAgent(String provinces,String city){
        this.provinces = provinces;
        this.city      = city;
    }
}
