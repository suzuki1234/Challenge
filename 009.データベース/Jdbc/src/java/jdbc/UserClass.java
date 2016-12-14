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
public class UserClass implements Serializable{
    String name;
    String pass;

    public UserClass(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public UserClass() {
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
