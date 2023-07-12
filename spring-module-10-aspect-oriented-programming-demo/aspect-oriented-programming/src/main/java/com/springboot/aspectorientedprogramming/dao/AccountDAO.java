package com.springboot.aspectorientedprogramming.dao;

import com.springboot.aspectorientedprogramming.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    void addAnotherAccount();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
