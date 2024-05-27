package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account,boolean vip);
    void addSilly();

    public String getName() ;
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode) ;
}
