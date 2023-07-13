package com.springboot.aspectorientedprogramming.dao;

import com.springboot.aspectorientedprogramming.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    void addAnotherAccount();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
