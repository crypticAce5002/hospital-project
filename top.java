package hospital;
import hospital.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class top {
  static  public HashMap<String,String> logins =new HashMap<>();
   public static String CompanyMessage="\n\n \t\t \t WELCOME TO KENYATTA NATIONAL HOSPITAL DATABASE SYSTEM \n\n \t Patients health is our first priority \n MOTTO:  Provide better health care to the community\n \n\t\t ********************WELCOME*******************\n\nENTER LOGIN DETAILS\n";
public static String MenuOptions="\n\t*************  THE FOLLOWING ARE SET OF FUNCTIONS YOU CAN PERFORM WITH THIS DATABASE  ************* \n"+
"\t _______________________________________________________________________________________________________\n"+
"\t|                                                                                                       |\n"+
"\t|   [1]-> INPUT PATIENTS RECORDS: TO PERFORM ENTRY TO THE DATABASE INPUT ENTER (input data)             |\n"+
"\t|   [2]-> OUTPUT PATIENTS RECORDS: TO PERFORM OUTPUT OF PATIENTS DATA FROM DATABASE ENTER(output data)  |\n"+
"\t|   [3]-> TRANSFER RECORD TO ANOTHER HOSPITAL DATABASE: TO PERFORM DATA TRANSFER ENTER(transfer data)   |\n"+
"\t|   [4]-> CHECK PATIENTS RECORD ACCESS AND DATABASE LOGINS :TO CHECK LOGINS ENTER(check logins)         |\n"+
"\t|   [5]-> CLOSE ACCESS TO HOSPITAL DATABASE :TO CLOSE ACCESS ENTER(terminate)                           |\n"+
"\t|_______________________________________________________________________________________________________|\n";
    public static Scanner genInput=new Scanner(System.in);
   // public static void Access_logins(Boolean l){}
   public static void Check_logins(Boolean l){
    Access_logins al2=new Access_logins();
    al2.get_login();
  }
    public static void input_record(Boolean l)throws Exception{
      InputRecord ir2=new InputRecord(); 
    }
    public static void close_portal(){
      System.out.println("\nCLOSING PORTAL .............................\n");
      System.out.println("\n***********PORTAL SUCCESSFULLY CLOSED*************\n\n");
      System.exit(1);
    }
    public static void Output_record(Boolean l)throws Exception{
      OutputRecord.show_records();
    }
   
    public static void Transfer_record(Boolean l){}
    public static boolean check_access(){
        System.out.print("\n Enter your administrator name... ");
        String name=genInput.nextLine();
        System.out.print("Enter password... ");
        String password=genInput.nextLine();
        final HashMap<String,String> adminstrator_access=new HashMap<>(){{put("c", "1");put("brenn mwangi", "bmw1234");put("Amley","amq21");}};
        boolean access=(adminstrator_access.containsKey(name)&& adminstrator_access.get(name).equals(password));
        return access;
      }
   
    public HashMap<String,String> kl=new HashMap<String,String>();
    public static void main(String[] args)throws IOException,ClassNotFoundException,Exception {
      
        System.out.print(CompanyMessage);
      
      if(check_access()){
        System.out.print(MenuOptions);
       System.out.print("\n\n WHAT FUNCTION DO YOU WANT TO PERFORM ? ");
       String func=genInput.nextLine();
       while(!func.isEmpty() ||! func.equals("terminate")){
       switch (func) {
        case "input data":input_record(check_access());
          break;
       case "output data":Output_record(check_access());
          break;
          case "check logins":  Check_logins(check_access());
          break;
          case "terminate":close_portal();
          break;
        default:close_portal();
          break;
       } 
       System.out.print("ENTER A FUNCTION TO PERFORM \t IF NONE ENTER(terminate)  ");
       func=genInput.nextLine();
      }    
      }
      else{
        System.out.print("\n!!!!!!! USERNAME IS NOT RECOGNISED AND PASSWORD IS INCORRECT !!!!!!!\n");
        System.exit(1);
      }
    
        
       
    }
}
