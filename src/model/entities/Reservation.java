
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exception.DomainException;

/**
 *
 * @author Iara
 */
public class Reservation {
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //static pq sempre será usado quando chamar Reservation
    
    public Reservation(){
        
    }

    public Reservation(int roomNumber, Date checkIn, Date checkOut) {
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Reservation dates must be future dates");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }   

    public Date getCheckOut() {
        return checkOut;
    }    
    
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void updateDate(Date in, Date out) {       
        Date now = new Date();
        if(in.before(now) || out.before(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if(!out.after(in)){
            throw new DomainException("Check-out must be after check-in date");
        }
        this.checkIn = in;
        this.checkOut = out;  
                
    }
    

    @Override
    public String toString() {
        return  
                "room: " + roomNumber 
                + ", checkIn: " 
                + sdf.format(checkIn)
                + ", checkOut: " + sdf.format(checkOut) 
                + ", "
                + duration()
                + " nights";
    }
    
    
    
}
