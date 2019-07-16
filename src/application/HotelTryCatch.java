
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exception.DomainException;

/**
 *
 * @author Iara
 */
public class HotelTryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("Enter Room number: ");
            int room = k.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date in = sdf.parse(k.next());
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date out = sdf.parse(k.next());

            Reservation res = new Reservation(room, in, out);
            System.out.println("Reservation " + res);
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in: ");
            in = sdf.parse(k.next());
            System.out.print("Check-out: ");
            out = sdf.parse(k.next());

            res.updateDate(in, out);        
            System.out.println("Reservation Updates: " + res);

            k.close();
        } 
        catch(ParseException e){
            System.out.println("Invalid date format");
        } 
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        } 
        catch(RuntimeException e){
            System.out.println("Unexpected Error!");
        }
    }
        
    }
    

