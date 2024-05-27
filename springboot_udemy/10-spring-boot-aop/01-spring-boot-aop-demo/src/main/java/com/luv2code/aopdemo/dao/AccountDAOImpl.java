package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account,boolean vip) {
        System.out.println(getClass()+ " doing my add account method with parameters with vip");
    }

    @Override
    public void addSilly() {
        System.out.println(getClass()+ " doing my silly method  ");
    }
}
