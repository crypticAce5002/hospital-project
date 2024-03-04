package hospital;
import hospital.*;
import java.io.*;
import java.util.*;
public class InputRecord {
    public static Access_logins al2=new Access_logins();
    public Access_logins al=new Access_logins();
    public static void add_data(Object o,boolean f)throws FileNotFoundException,IOException,ClassNotFoundException{
        File n=new File("C:\\Users\\USER\\OneDrive\\Desktop\\java practices\\hospital\\database.dat");
        // FileInputStream fis=new FileInputStream(new File("Record.java"));
        FileOutputStream fos;
        fos=new FileOutputStream(n);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        // ObjectInputStream ois=new ObjectInputStream(fis);
       oos.writeObject(o);
       if(!f){oos.close();fos.close();}
        
    };
    // public static boolean inputFinished(int){}//check if required records are finished being input
    public InputRecord() throws IOException,ClassNotFoundException{
        
       Scanner ir= top.genInput;
       System.out.print("\nEnter number of records to input...\n");
       int rs=0;
       int p=ir.nextInt();
       boolean f=(rs<p);
       ir.nextLine();
       while(rs<p){
        Record r1=new Record("charles ","mwangi");
        al.add_login();
        r1.add_records();
        add_data(r1.patientRecords,f);
        rs++;
        
       }
       System.out.println("\n\n****************************PATIENT RECORD INPUTED TO THE KENYATTA DATABASE SUCCESSFULLY**********************************\n\n");
    }
    
}
