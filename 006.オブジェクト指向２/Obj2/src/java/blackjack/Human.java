/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author suzuki
 */
abstract class Human {
    ArrayList<Integer> myCards =new ArrayList<>();
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> List);
    public abstract boolean checkSum();
    
}
