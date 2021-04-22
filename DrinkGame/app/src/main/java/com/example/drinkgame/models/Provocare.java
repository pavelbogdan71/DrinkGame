package com.example.drinkgame.models;

import java.io.Serializable;

public class Provocare implements Serializable {
    private String provocare;
    


    public Provocare(String provocare){
        this.provocare=provocare;

    }
    public String getProvocare() {
        return provocare;
    }

    public void setProvocare(String provocare) {
        this.provocare = provocare;
    }

    public String toString(){
        return "Provocare:"+provocare;
    }
}
