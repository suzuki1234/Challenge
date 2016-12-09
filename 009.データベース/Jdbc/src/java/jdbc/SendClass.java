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
public class SendClass implements Serializable{
    private String name;
    private int age;
    private String tell;
    private String birthday;
    private int id;
    

    
    public SendClass(){}
    
    public SendClass(int id ,String name ,String tell, int age,String birthday){
        
        this.tell=tell;
        this.birthday = birthday;
        this.name=name;
        this.age=age;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getTell() {
        return tell;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    
}
