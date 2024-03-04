package hospital;
import hospital.Record;
import hospital.top;
import java.io.*;
import java.util.*;
import hospital.patient;
public class OutputRecord {
    public  OutputRecord()throws Exception{
    

    }
    public static boolean record_exists() throws Exception{
        Scanner gen2=top.genInput;
        System.out.println("ENTER PATIENT NAME TO SEARCH");
        String PatientName=gen2.nextLine();
        Boolean c;
       File recordIn=new File("C:\\Users\\USER\\OneDrive\\Desktop\\java practices\\hospital\\database.dat");
       FileInputStream fis2=new FileInputStream(recordIn);
       ObjectInputStream ois2=new ObjectInputStream(fis2);
       patient patientClone=(patient)ois2.readObject();
       c= patientClone.patients.contains(PatientName);
       ois2.close();
        return c;

    }
    public static void show_records()throws Exception{
    if(record_exists()){
        File recordIn=new File("C:\\Users\\USER\\OneDrive\\Desktop\\java practices\\hospital\\database.dat");
        FileInputStream fis2=new FileInputStream(recordIn);
       ObjectInputStream ois2=new ObjectInputStream(fis2);
        patient patientClone2=(patient)ois2.readObject();
        Record r1=new Record(null, null);
        System.out.println("PATIENT INFORMATION");
        for(String sc:r1.header1){
            System.out.printf("\t%s :: %s \n",sc,patientClone2.patientInfo.get(sc));
        }
        System.out.println("MEDICAL HISTORY");
        for(String sc:r1.header2){
            System.out.printf("\t%s :: %s \n",sc,patientClone2.medicalHistory.get(sc));
        }
        System.err.println("CURRENT MEDICATION");
        for(String sc:r1.header3){
            System.out.printf("\t%s :: %s \n",sc,patientClone2.currentMedication.get(sc));
        }
        ois2.close();
    }
    else{
        System.out.println("!! Sorry no such patient exists in this hopital database !!");
        System.exit(1);
    }
        
    }
    
}
