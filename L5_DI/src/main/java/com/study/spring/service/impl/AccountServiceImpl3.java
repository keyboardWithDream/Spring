package com.study.spring.service.impl;

import com.study.spring.service.IAccountService;

import java.util.*;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] myArray;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void save() {
        System.out.println("Service中Save方法执行了...\n{" +
                "myArray=" + Arrays.toString(myArray) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                "}"
        );
    }

}
