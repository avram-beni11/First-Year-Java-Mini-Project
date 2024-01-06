
package beniavramproject;
/**
 *
 * @author Iulian Beniamin Avram M00755825
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BeniAvramProject {

    public static void main(String[] args) throws FileNotFoundException {
 
       
        int array = Integer.parseInt(JOptionPane.showInputDialog("How many restaurants would you like to enter?"));
        Restaurant newR[] = new Restaurant [array];
         
        
        String menu =  "**********************************************************************************" + "\n"
                              + "*             *                                                                                                   *                 *" + "\n"
                              + "*          *****                         Welcome to RestReview                     *****              *" + "\n"
                              + "*             *                                                                                                   *                 *" + "\n"
                              + "**********************************************************************************" 
                + "\n* What would you like to do today?                                                                       *"                                                                 
                + "\n* 1) Input Data                                                                                                             *"                                                                                                 
                + "\n* 2) Write to File                                                                                                          *"
                + "\n* 3) Search for Your Restaurant  Review                                                             *" 
                + "\n* 4) Read File                                                                                                                *" 
                + "\n* 5) Close the Program                                                                                             *"
                + "\n**********************************************************************************";

        int choice = 0;
        
     
        do {
            
            try {
            choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
              switch (choice) { // Acts Like an if Statement
                  case 1: InputData (newR);break;
                  case 2: writeData(newR);break;
                  case 3: searchName(newR);break;
                  case 4: fileRead(newR);break;
                  case 5: systExit ();
              }//end switch
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"PLEASE ENTER A NUMBER");
            }
            
        }while (choice != 5);

    }//end Main Method
    
    //=========================================================
    
    public static void InputData(Restaurant newR[]) {

      for (int i = 0; i < newR.length; i++) {
          
              String a = JOptionPane.showInputDialog("Enter Address of the Restaurant: ");  
              String b = JOptionPane.showInputDialog("Enter Type of Restaurant (Chinese, French etc etc)t: ");
         
               double rt = 0;
               do{
                  rt = Double.parseDouble(JOptionPane.showInputDialog("Enter the Rating of the Restaurant(Between 0 and 5): "));
               } while(rt>5);

             
              String c = JOptionPane.showInputDialog("Enter Name of Restaurant: ");
              String d = JOptionPane.showInputDialog("Please Enter a Comment About the Restaurant: ");            
             
     newR[i] = new Restaurant(a,b,rt,c,d);
      }                 
         
    }// End of the Data Input Function
    
    //=========================================================
     
     public static void writeData(Restaurant newR[])  {
       
 String str  =  JOptionPane.showInputDialog("Enter the name of the restaurant you want to write to file: ");
 JOptionPane.showMessageDialog(null, str + " is the restaurant you want to write to file.");
 String fName = JOptionPane.showInputDialog("What would you like to name your file (make sure to add .txt at the end)?");

 for( int i=0;i<3; i++)
    {
     if (newR[i].name.equalsIgnoreCase(str))
     try {
        
            FileWriter myWrite = new FileWriter(fName);
            myWrite.write("**********************" + 
                      "\nLocation: " + newR[i].location +
                      "\nRestaurant Type: " + newR[i].rest_type + 
                      "\nRating: " + newR[i].rate +
                      "\nName: " + newR[i].name +
                       "\nExtra Comment: "+ newR[i].comment +
                      "\n**********************");
            myWrite.close();
            System.out.println("\nWrote in the file!");
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }//end catch
    
     }//for   
     }//end writeData 

     //=========================================================
     
      public static void systExit() {
          
       JOptionPane.showMessageDialog(null,"*************************************" + 
               "\nThank you for using my program!"
                + "\n*************************************"); //A simple message thanking the user for using my program, after exiting the program
       
      }// End of System Exit
      
       //=========================================================
  
      public static void searchName(Restaurant newR[]){

 String str  =  JOptionPane.showInputDialog("Enter the name of the restaurant you are looking for: ");
 JOptionPane.showMessageDialog(null, str + " is the restaurant you are searching for.");

 for( int i=0;i<3; i++) {
     
     if (newR[i].name.equalsIgnoreCase(str))
     JOptionPane.showMessageDialog(null,"Data for restaurant " + str + ":" +
                       "\n**********************" + 
                      "\nLocation: " + newR[i].location +
                      "\nRestaurant Type: " + newR[i].rest_type + 
                      "\nRating: " + newR[i].rate +
                      "\nName: " + newR[i].name +
                       "\nExtra Comment: "+ newR[i].comment +
                      "\n**********************");
     }//for    
}//end searchName
      
      //=========================================================
      
      public static void fileRead(Restaurant newR[]) throws FileNotFoundException {
          
          String fileRead = JOptionPane.showInputDialog("Which restaurant would you like to look at." + 
                  "Currently Available: " + "Manuel & Sons, Eat Seoul, John Adams' Chip Shop, Tokyo Grub and Shino's French(make sure to add .txt at the end of the file name): ");
          File myObj = new File(fileRead);
          Scanner scan = new Scanner(myObj);
          while (scan.hasNextLine()) {
         System.out.println(scan.nextLine());
              
          }
          scan.close(); 
          
      }//end fileRead
}// End Class Project

