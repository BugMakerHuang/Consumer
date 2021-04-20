package com.trade.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Cloneable{
    private int id;
    private String username;
    private String password;
    private Timestamp createTime;
    public Agent agent;

    @Override
    public UserEntity clone() throws CloneNotSupportedException{
        return (UserEntity) super.clone();
    }

    public UserEntity(int id,String username,String password,Timestamp createTime){
        this.id = id;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.agent  = new Agent();
    }

    public void setAgent(String province,String city){
        agent.setAgent(province,city);
    }
}
