
package beniavramproject;

import javax.swing.JOptionPane;

/**
 *
 * @author beni_
 */
public class Restaurant {
    
    String location;
    String rest_type; 
    double rate;
    String name;
    String comment;
    
    public Restaurant () {
        
        location = " ";
        rest_type = " ";
        rate = 0;
        name = " ";
        comment = " ";
       
    }// End of the Default Constructor
    
    public Restaurant (String loc, String type, double rt, String nm, String com) {
        
        location = loc;
        rest_type = type;
        rate = rt; 
        name = nm;
        comment = com;
        
         
    }// End of Second Constructor
    
    public void dataPrint () {
     
        JOptionPane.showMessageDialog(null,"**********************" + 
                      "\nLocation: " + location +
                      "\nRestaurant Type: " + rest_type + 
                      "\nRating: " + rate +
                      "\nName: " + name +
                       "\nExtra Comment: "+ comment +
                      "\n**********************");

    }// End of dataPrint Constructor
    

    
}// End Class Restaurant 
