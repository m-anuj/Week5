package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass()+": DOING MY DB WORK : ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public void goTOSleep() {
        System.out.println(getClass()+": GO TO SLEEP");
    }
}
