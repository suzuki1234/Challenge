/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *フォームから受け取ったデータ自体を格納できるJavaBeans
 * これを利用して表示や分岐などを行う。
 * @author suzuki
 */
public class UserDataBeans implements Serializable{
    private String name="";
    private String year="";
    private String month="";
    private String day="";
    private String type="";
    private String tell="";
    private String comment="";
    public UserDataBeans() {
    }

    public UserDataBeans(String name, String year, String month, String day, String type, String tell, String comment) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.type = type;
        this.tell = tell;
        this.comment = comment;
    }
    
    //入力のチェックの際に使用。
    //返り値として配列型ですべてのデータを渡す。
    public String[][] getallData(){
        String[][] data={{"氏名",name},{"年",year},{"月",month},{"日",day},{"種別",type},{"電話番号",tell},{"自己紹介文",comment}};
        return data; 
    }
    
    public UserDataDTO makeUD(){
        UserDataDTO ud = new UserDataDTO();
        
        ud.setName(name);
        Calendar birthday = Calendar.getInstance();
        birthday.set(Integer.parseInt(year)+1,Integer.parseInt(month)-1,Integer.parseInt(day));
        ud.setBirthday(birthday.getTime());
        ud.setType(Integer.parseInt(type));
        ud.setTell(tell);
        ud.setComment(comment);
        
        return ud;
    }
    
    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }




    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public String getTell() {
        return tell;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

 
    
    
    
}
