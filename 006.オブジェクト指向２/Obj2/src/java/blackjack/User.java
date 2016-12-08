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
public class User extends Human{
    
    
    
    @Override
    public void setCard(ArrayList<Integer> List) {
        for(int i = 0;i<List.size();i++){
            myCards.add(List.get(i));
        }
    }

    @Override
    public boolean checkSum() {
        int sum=0;
        for(int i = 0;i<myCards.size();i++){
            sum = sum + myCards.get(i);
        }
        
        return sum<21;
    }
    
    
    @Override
    public int open() {
        int sum=0;
        for(int i=0;i<myCards.size();i++){
            sum = sum + myCards.get(i);
        }
        return sum;
 
    }
}
