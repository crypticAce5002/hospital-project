package hospital;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import hospital.Record;
import java.util.Scanner;
import java.time.*;


public class Access_logins{
   
    public HashMap<String,Object> user_logins=new HashMap<>();
    public Access_logins(){
        
    }
    public void get_login(){
        System.out.println(top.logins.toString());
        // for(String el:logins.keySet()){
        //     System.out.println(el+logins.get(el));
        // }

    }
    public void add_login(){
        LocalDate dt=LocalDate.now();
        String fn=String.format(" Records were accessed on[%s] at :",dt.toString());
        LocalTime lt=LocalTime.now();
       top.logins.put(fn,lt.toString());
        //logins.put(dt.toString(), lt);
    }


    
}
class loginDetails implements Serializable{
 

}
