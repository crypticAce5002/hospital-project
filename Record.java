package hospital;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;
import java.time.*;
import hospital.Access_logins;
import java.util.Iterator;

/**
 * InnerRecord
 */
 interface standard {
   int check_record();
   void update_record(HashSet hs, HashMap hm);
   
   
    
}

public class Record {
  transient public Integer RecordNumber=-1;
 
 public HashMap<String,Object> patientRecords=new HashMap<>();
 //header for user to provide input to be recorded.
 transient public  String [] header1={"FULL NAME","DATE OF BIRTH","GENDER","CONTACT DETAILS","EMERGENCY CONTACT","MEDICAL RECORD NUMBER"}
 ,header2={"PAST CONDITIONS","SURGICAL PROCEDURES","ALLERGIES","FAMILY HISTORY"}
 ,header3={"NAME OF MEDICATION AND DOSAGE","FREQUENCY","PRESCRIBING PHYSICIAN"};

transient public HashMap<String,Object> RecordsArray=new HashMap<>(){{put("PATIENT INFORMATION",header1);put("MEDICAL HISTORY",header2);put("CURRENT MEDICATION",header3);}};
transient public  String []RecordSections={"*********PATIENT INFORMATION********".indent(2),"*********MEDICAL HISTORY*********".indent(2),"*********CURRENT MEDICATION**********".indent(2)};
// public Object[] hs={header1,header2,header3};
public Access_logins al=new Access_logins();
    public Record(String administratorName,String password){
     
    this.RecordNumber++;
    al.add_login();
    
    }
    public  void add_records()throws IOException{
      Scanner ri=top.genInput;
      String tempPatientName;
      al.add_login();
      patient patientRecord =new patient();
      System.out.println("\n"+RecordSections[0]);
      for(String h1:header1){
         
         String hs;
         System.out.print("\t"+h1+"::\t");
         hs=ri.nextLine();
         if(h1.equals("FULL NAME")){patientRecord.patients.add(hs);tempPatientName=hs;}
          patientRecord.patientInfo.put(h1,hs);
      }
      System.out.println("\n"+RecordSections[1]);
      for(String h2:header2){
         String hs2;
         System.out.print("\t"+h2+"::\t");
         hs2=ri.nextLine();
         patientRecord.medicalHistory.put(h2,hs2);

      }
      System.out.println("\n"+RecordSections[2]);
      for(String h3:header3){
         String hs3;
         System.out.print("\t"+h3+"::\t");
         hs3=ri.nextLine();
         patientRecord.currentMedication.put(h3,hs3);
      }
      // ri.close();
      this.patientRecords.put(patientRecord.patients.get(this.RecordNumber),patientRecord);
      al.add_login();
      // patient s=(patient)patientRecords.get("charles");
      // out.printf("patients dob %s",s.patientInfo.get("DATE OF BIRTH"));
      // out.printf(patients.toString());
   }  
      }
    
    

class patient extends Record implements Serializable{
   public  ArrayList<String> patients=new ArrayList<>();
   HashMap<String,Object> patientInfo=new HashMap<>();
   HashMap<String,Object>medicalHistory=new HashMap<>();
   HashMap<String,Object> currentMedication=new HashMap<>();
   HashMap<String,Object> patients_record=new HashMap<>(){{put("PATIENT INFORMATION",patientInfo);put("MEDICAL HISTORY", medicalHistory);put("CURRENT MEDICATION",currentMedication);}};
   patient(){
      super(null, null);
   }
}
