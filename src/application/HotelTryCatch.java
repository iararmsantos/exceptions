
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author Iara
 */
public class HotelTryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner k = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Enter Room number: ");
        int room = k.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date in = sdf.parse(k.next());
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date out = sdf.parse(k.next());
        
        if(!out.after(in)){
            System.out.println("Error in reservation: Check-out must be after check-in date");
        }else{
            Reservation res = new Reservation(room, in, out);
            System.out.println("Reservation " + res);
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in: ");
            Date inUp = sdf.parse(k.next());
            System.out.print("Check-out: ");
            Date outUp = sdf.parse(k.next());
            
            String error = res.updateDate(inUp, outUp);
            if(error != null){
                System.out.println("Error in reservation: " + error);   
            }else{
                System.out.println("Reservation Update: " + res);
            }
            
        }
        
        
        
        
    }
    
}
