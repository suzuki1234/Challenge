/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author suzuki
 */
public class Dealer extends Human{
    ArrayList<Integer> cards; //持っているカード用
    //持っているカード用
    int index=0;    //カード用のインデックス

    Dealer(){
        //乱数用のListと乱数インスタンス用意
        ArrayList<Integer> r = new ArrayList<>();
        Random rnd = new Random();
        
//        乱数用意
        for (int i = 0 ; i<=51;i++){
            r.add(rnd.nextInt(1000));
        }
        
//        カード用の配列用意
        this.cards = new ArrayList<>();
        
//        カードの1～13を4回格納
        for (int j = 1 ; j<=4;j++){
            for (int i = 1 ; i<=13;i++){
                this.cards.add(i);
            }
        }
        
//        カードシャッフル
        for(int i = 0 ; i < r.size() -1 ; i ++){
            for(int j = i ; j < r.size() -1 ; j ++){
                if(r.get(j) < r.get(j+1)){

                    int t =r.get(j);
                    r.set(j, r.get(j+1));
                    r.set(j+1, t);
                    
                    int s =cards.get(j);
                    cards.set(j, cards.get(j+1));
                    
                    cards.set(j+1, s);
                    
                }
            }
        }
//        デバッグ用
//        cards.set(0,10);
//        cards.set(1,11);
//        cards.set(2,12);
//        cards.set(3,9);
    }
    
    public ArrayList deal(){
        ArrayList<Integer> Rcards=new ArrayList<>();
        
        Rcards.add(cards.get(index));
        index++;
        Rcards.add(cards.get(index));
        index++;
        
        return Rcards;
    }
    public ArrayList hit(){
        ArrayList Rcards = new ArrayList<>();
        
        Rcards.add(cards.get(index));
        index++;
        return Rcards;
    }
 
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
