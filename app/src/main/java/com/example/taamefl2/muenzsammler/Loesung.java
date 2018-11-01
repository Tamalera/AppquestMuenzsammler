package com.example.taamefl2.muenzsammler;


import java.util.ArrayList;

public class Loesung {
    private String task;
    private ArrayList<Coin> coins;

    public Loesung(ArrayList<Coin> coins){
        this.task = "Muenzensammler";
        this.coins = coins;
    }
}
