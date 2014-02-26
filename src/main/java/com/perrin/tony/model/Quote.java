package com.perrin.tony.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 21/02/2014
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public class Quote {
    private String symbol;
    private double price;

    public Quote(){}

    public Quote(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @SpaceId(autoGenerate=false)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}