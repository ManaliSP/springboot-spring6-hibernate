package com.springboot.aspectorientedprogramming.dao;

import com.springboot.aspectorientedprogramming.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl  implements AccountDAO{

    @Override
    public void addAccount(Account account) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void addAnotherAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A NEW ACCOUNT");
    }
}
