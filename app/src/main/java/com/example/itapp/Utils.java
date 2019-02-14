package com.example.itapp;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    List<Pcost> pcostList = new ArrayList<>();

    void create(String name,int price, String type){
        Pcost pcost = new Pcost(idGenerator(),name,price,type);
        pcostList.add(pcost);
    }

    void yearCost(List list){
        int P = 0;
        int K = 0;
        for (int i = 0;i < list.size();i++){
            if (pcostList.get(i).getType().equals("P")){
                P += pcostList.get(i).getPrice();
            } else {
                K += pcostList.get(i).getPrice();
            }
        }
        System.out.println("Прямые затраты " + P * 0.015 + "\nКосвенные затраты " + K);
    }

    void print(){
        System.out.println(pcostList);
    }

    private int idGenerator(){
        int id = pcostList.size();
        if (pcostList.isEmpty()){
            return 0;
        }
        id = pcostList.size();
        return id;
    }
}
