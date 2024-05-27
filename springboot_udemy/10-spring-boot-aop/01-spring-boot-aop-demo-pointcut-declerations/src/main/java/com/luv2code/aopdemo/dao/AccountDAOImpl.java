package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account,boolean vip) {
        System.out.println(getClass()+ " doing my add account method with parameters with vip");
    }

    @Override
    public void addSilly() {
        System.out.println(getClass()+ " doing my silly method  ");
    }

    public String getName() {
        System.out.println(getClass()+ " doing my  method getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ " doing my  method setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ " doing my silly method getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ " doing my silly method setServiceCode");
        this.serviceCode = serviceCode;
    }
}
