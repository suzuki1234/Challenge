/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.PrintWriter;

/**
 *
 * @author suzuki
 */
public class Kadai3 {
    public int a=0 , b=0;
    
    
    public void setA(int a){
        this.a=a;
    }

    public void setB(int b){
        this.b=b;
    }
    
    public void prA(PrintWriter out){
        out.print(String.valueOf(this.a));
    }
        
    public void prB(PrintWriter out){
        out.print(String.valueOf(this.b));
    }    
    
}

