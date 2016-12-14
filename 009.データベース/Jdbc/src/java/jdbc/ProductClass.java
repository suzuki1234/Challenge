/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.Serializable;

/**
 *
 * @author suzuki
 */
public class ProductClass implements Serializable{
    String name;
    int price;
    int amount;
    
    public ProductClass(){}

    public ProductClass(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    

    

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    
}
