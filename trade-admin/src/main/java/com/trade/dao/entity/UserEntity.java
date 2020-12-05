package com.trade.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private Timestamp createTime;
}
