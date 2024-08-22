package assignment;

import static assignment.staff.countlines2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class booking extends room {
    private String customername;
    public String customeric;
    private String customeremail;
    private String customercontact;
    private String start_date;
    private String end_date;
    private String days_of_stay;
    private String checkin_date;
    private String checkout_date;
    
    
    //use to retrieve two date data when searching for the room
    public static Date[] mySearchingDate = new Date[2];
    
    //constructors overloading
    public booking(String room_id, String room_level, String room_size, String customeric, String customername, String customeremail, String customercontact, String start_date, String end_date, String days_of_stay) {

        super(room_id, room_level, room_size);

        this.customername = customername;
        this.customeric = customeric;
        this.customeremail = customeremail;
        this.customercontact = customercontact;
        this.start_date = start_date;
        this.end_date = end_date;
        this.days_of_stay = days_of_stay;
    }
    
    public booking(String room_id, String customeric, String customername, String start_date, String end_date, String days_of_stay){
        super(room_id);
        this.customeric = customeric;
        this.customername = customername;
        this.start_date = start_date;
        this.end_date = end_date;
        this.days_of_stay = days_of_stay;
    }
    
    public booking(String room_id, String customeric, String checkin_date){
        super(room_id);
        
        this.customeric = customeric;
        this.checkin_date = checkin_date;
        
    } 
    
    public booking(String room_id, String customeric){
        super(room_id);
        this.customeric = customeric;
    }
    
    //writing down the booking data
    public String writeBooking(){
        try{
            FileWriter fw = new FileWriter("Booking.txt",true);
            PrintWriter outputFile = new PrintWriter(fw);
            outputFile.println("Room ID: " + room_id);
            outputFile.println("Room Level: " + room_level);
            outputFile.println("Room Size: " + room_size);
            outputFile.println("IC/Passport: " + customeric);
            outputFile.println("Name: " + customername);
            outputFile.println("Email: " + customeremail);
            outputFile.println("Contact: " + customercontact);
            outputFile.println("Start Date: " + start_date);
            outputFile.println("End Date: " + end_date);
            outputFile.println("Days of Stay: " + days_of_stay);
            outputFile.println("Check In: ");
            outputFile.println("Check Out: " + "\n");
            outputFile.close();
            return "Success";

        } catch (Exception ex){
            return ex.toString();
        }
    }
    
    //count the number to iterate through the booking.txt (find available lines)
    static int countlines() throws FileNotFoundException {
        File file = new File("Booking.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }

        scanner.close();

        return count / 13 + 1; // Divide by 13 since each booking consists of 13 lines and + 1 as lesser than symbol is used "<".
    }
    
    //use room id and customer ic to modify the checkin date column
    public String checkin() throws FileNotFoundException, IOException{
        String id, level, size, ic, name, email, contact, start, end, day, checkin, checkout, space;
        RandomAccessFile raf = new RandomAccessFile("Booking.txt", "rw");
        
        String[] myArray = new String[13];
        
        for(int i=1; i < countlines() ; i++){
                id = raf.readLine();
                level = raf.readLine();
                size = raf.readLine();
                ic = raf.readLine();  
                name = raf.readLine();
                email = raf.readLine();
                contact = raf.readLine();
                start = raf.readLine();
                end = raf.readLine();
                day = raf.readLine();
                checkin = raf.readLine();
                checkout = raf.readLine();
                space = raf.readLine();
                
                myArray [0] = id;
                myArray [1] = level;
                myArray [2] = size;
                myArray [3] = ic;
                myArray [4] = name;
                myArray [5] = email;
                myArray [6] = contact;
                myArray [7] = start;
                myArray [8] = end;
                myArray [9] = day;
                myArray [10] = checkin;
                myArray [11] = checkout;
                myArray [12] = space;
                
                
                if (myArray[0].equals("Room ID: "+ room_id) && myArray[3].equals("IC/Passport: "+ customeric)){
                    myArray[10] = "Check In: "+ checkin_date;
                }
                
                FileWriter writer = new FileWriter("Booking.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    writer.write(myArray[6]+"\n");
                    writer.write(myArray[7]+"\n");
                    writer.write(myArray[8]+"\n");
                    writer.write(myArray[9]+"\n");
                    writer.write(myArray[10]+"\n");
                    writer.write(myArray[11]+"\n");
                    writer.write(myArray[12]+"\n");
                    
                    writer.close();
                    
        }
        Path tempFilePath = Paths.get("Booking.tmp");
        Path originalFilePath = Paths.get("Booking.txt");

        var lines = Files.readAllLines(tempFilePath);


        Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);


        Files.delete(tempFilePath);
        
        
        
        File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Booking.tmp");
        
        if (tempFile.exists()) {
            tempFile.delete();
            tempFile.createNewFile();
            System.out.println("Temp file cleared successfully.");
        }
        
        return "Success";        
    }
    
    //array use to store booking information to be modified
    public static String[] modifybooking = new String[6];
    
    //modifying the content in booking txt
    public String modifycontent() throws FileNotFoundException, FileNotFoundException, IOException{
        String id, level, size, ic, name, email, contact, start, end, day, checkin, checkout, space;
        RandomAccessFile raf = new RandomAccessFile("Booking.txt", "rw");
        
        String[] myArray = new String[13];
        
        //reading through lines
        for(int i=1; i < countlines() ; i++){
                id = raf.readLine();
                level = raf.readLine();
                size = raf.readLine();
                ic = raf.readLine();  
                name = raf.readLine();
                email = raf.readLine();
                contact = raf.readLine();
                start = raf.readLine();
                end = raf.readLine();
                day = raf.readLine();
                checkin = raf.readLine();
                checkout = raf.readLine();
                space = raf.readLine();
                
                //store into array myArray
                myArray [0] = id;
                myArray [1] = level;
                myArray [2] = size;
                myArray [3] = ic;
                myArray [4] = name;
                myArray [5] = email;
                myArray [6] = contact;
                myArray [7] = start;
                myArray [8] = end;
                myArray [9] = day;
                myArray [10] = checkin;
                myArray [11] = checkout;
                myArray [12] = space;
                
                //if data matches (append all data into modify booking array) 
                if (myArray[0].equals("Room ID: "+ room_id) && myArray[3].equals("IC/Passport: "+ customeric)){
                    modifybooking[0] = id.substring(9);
                    modifybooking[1] = ic.substring(13);
                    modifybooking[2] = name.substring(6);
                    modifybooking[3] = start.substring(12);
                    modifybooking[4] = end.substring(10);
                    modifybooking[5] = day.substring(14);
                    
                }

    }
        return "Success";

}
    
    //editing the records
    public String editrecord() throws FileNotFoundException, IOException{
        String id, level, size, ic, name, email, contact, start, end, day, checkin, checkout, space;
        RandomAccessFile raf = new RandomAccessFile("Booking.txt", "rw");
        
        String[] myArray = new String[13];
        
        //iterate through rowes of data
        for(int i=1; i < countlines() ; i++){
                id = raf.readLine();
                level = raf.readLine();
                size = raf.readLine();
                ic = raf.readLine();  
                name = raf.readLine();
                email = raf.readLine();
                contact = raf.readLine();
                start = raf.readLine();
                end = raf.readLine();
                day = raf.readLine();
                checkin = raf.readLine();
                checkout = raf.readLine();
                space = raf.readLine();
                
                myArray [0] = id;
                myArray [1] = level;
                myArray [2] = size;
                myArray [3] = ic;
                myArray [4] = name;
                myArray [5] = email;
                myArray [6] = contact;
                myArray [7] = start;
                myArray [8] = end;
                myArray [9] = day;
                myArray [10] = checkin;
                myArray [11] = checkout;
                myArray [12] = space;
                
                //rewriting the data matched by editing the array
                if (myArray[0].equals("Room ID: "+ room_id) && myArray[3].equals("IC/Passport: "+ customeric)){
                    myArray [0] = "Room ID: " + room_id;
                    myArray [3] = "IC/Passport: " + customeric;
                    myArray [4] = "Name: "+ customername;
                    myArray [7] = "Start Date: "+ start_date;
                    myArray [8] = "End Date: "+ end_date;
                    myArray [9] = "Days of Stay: "+ days_of_stay;
                }
                
                //rewrite array into temp file
                FileWriter writer = new FileWriter("Booking.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    writer.write(myArray[6]+"\n");
                    writer.write(myArray[7]+"\n");
                    writer.write(myArray[8]+"\n");
                    writer.write(myArray[9]+"\n");
                    writer.write(myArray[10]+"\n");
                    writer.write(myArray[11]+"\n");
                    writer.write(myArray[12]+"\n");
                    
                    writer.close();
                    
        }
        Path tempFilePath = Paths.get("Booking.tmp");
        Path originalFilePath = Paths.get("Booking.txt");

        var lines = Files.readAllLines(tempFilePath);


        Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        //delete it after content is moved to original file
        Files.delete(tempFilePath);
        
        
        
        File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Booking.tmp");
        // delete temp file if it existed before
        if (tempFile.exists()) {
            tempFile.delete();
            tempFile.createNewFile();
            System.out.println("Temp file cleared successfully.");
        }
        return "Success";

    }
    
    //deleting the booking record
    public String deleterecord() throws FileNotFoundException, IOException{
        String id, level, size, ic, name, email, contact, start, end, day, checkin, checkout, space;
        RandomAccessFile raf = new RandomAccessFile("Booking.txt", "rw");
        
        String[] myArray = new String[13];
        
        for(int i=1; i < countlines() ; i++){
                id = raf.readLine();
                level = raf.readLine();
                size = raf.readLine();
                ic = raf.readLine();  
                name = raf.readLine();
                email = raf.readLine();
                contact = raf.readLine();
                start = raf.readLine();
                end = raf.readLine();
                day = raf.readLine();
                checkin = raf.readLine();
                checkout = raf.readLine();
                space = raf.readLine();
                
                myArray [0] = id;
                myArray [1] = level;
                myArray [2] = size;
                myArray [3] = ic;
                myArray [4] = name;
                myArray [5] = email;
                myArray [6] = contact;
                myArray [7] = start;
                myArray [8] = end;
                myArray [9] = day;
                myArray [10] = checkin;
                myArray [11] = checkout;
                myArray [12] = space;
                
                //change array into null if data matches
                if (myArray[0].equals("Room ID: "+ room_id) && myArray[3].equals("IC/Passport: "+ customeric)){
                    myArray [0] = "";
                    myArray [1] = "";
                    myArray [2] = "";
                    myArray [3] = "";
                    myArray [4] = "";
                    myArray [5] = "";
                    myArray [6] = "";
                    myArray [7] = "";
                    myArray [8] = "";
                    myArray [9] = "";
                    myArray [10] = "";
                    myArray [11] = "";
                    myArray [12] = "";
                } else{
                    FileWriter writer = new FileWriter("Booking.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    writer.write(myArray[6]+"\n");
                    writer.write(myArray[7]+"\n");
                    writer.write(myArray[8]+"\n");
                    writer.write(myArray[9]+"\n");
                    writer.write(myArray[10]+"\n");
                    writer.write(myArray[11]+"\n");
                    writer.write(myArray[12]+"\n");
                    
                    writer.close();
                }
        }
        
                Path tempFilePath = Paths.get("Booking.tmp");
                Path originalFilePath = Paths.get("Booking.txt");

                var lines = Files.readAllLines(tempFilePath);


                Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);


                Files.delete(tempFilePath);



                File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Booking.tmp");

                if (tempFile.exists()) {
                    tempFile.delete();
                    tempFile.createNewFile();
                    System.out.println("Temp file cleared successfully.");
                }
       return "Success";
    }
    
    //checkout function which update the check out row in booking txt
    public String checkout() throws FileNotFoundException, IOException{
        String id, level, size, ic, name, email, contact, start, end, day, checkin, checkout, space;
        RandomAccessFile raf = new RandomAccessFile("Booking.txt", "rw");
        
        String[] myArray = new String[13];
        
        for(int i=1; i < countlines() ; i++){
                id = raf.readLine();
                level = raf.readLine();
                size = raf.readLine();
                ic = raf.readLine();  
                name = raf.readLine();
                email = raf.readLine();
                contact = raf.readLine();
                start = raf.readLine();
                end = raf.readLine();
                day = raf.readLine();
                checkin = raf.readLine();
                checkout = raf.readLine();
                space = raf.readLine();
                
                myArray [0] = id;
                myArray [1] = level;
                myArray [2] = size;
                myArray [3] = ic;
                myArray [4] = name;
                myArray [5] = email;
                myArray [6] = contact;
                myArray [7] = start;
                myArray [8] = end;
                myArray [9] = day;
                myArray [10] = checkin;
                myArray [11] = checkout;
                myArray [12] = space;
                
                
                if (myArray[0].equals("Room ID: "+ room_id) && myArray[3].equals("IC/Passport: "+ customeric)){
                    myArray[11] = "Check Out: "+ checkin_date;
                }
                
                FileWriter writer = new FileWriter("Booking.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    writer.write(myArray[6]+"\n");
                    writer.write(myArray[7]+"\n");
                    writer.write(myArray[8]+"\n");
                    writer.write(myArray[9]+"\n");
                    writer.write(myArray[10]+"\n");
                    writer.write(myArray[11]+"\n");
                    writer.write(myArray[12]+"\n");
                    
                    writer.close();
                    
        }
        Path tempFilePath = Paths.get("Booking.tmp");
        Path originalFilePath = Paths.get("Booking.txt");

        var lines = Files.readAllLines(tempFilePath);


        Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);


        Files.delete(tempFilePath);
        
        
        
        File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Booking.tmp");
        
        if (tempFile.exists()) {
            tempFile.delete();
            tempFile.createNewFile();
            System.out.println("Temp file cleared successfully.");
        }
        
        return "Success";
    }
    
    //store check out booking data
    public static String[] historydata = new String[13];
    
    //retrieving check out booking data
    public void getData() throws FileNotFoundException, IOException{
        String id, level, size, ic, name, email, contact, start, end, day, checkin, checkout, space;
        RandomAccessFile raf = new RandomAccessFile("Booking.txt", "rw");
        
        String[] myArray = new String[13];
        
        for(int i=1; i < countlines() ; i++){
                id = raf.readLine();
                level = raf.readLine();
                size = raf.readLine();
                ic = raf.readLine();
                name = raf.readLine();
                email = raf.readLine();
                contact = raf.readLine();
                start = raf.readLine();
                end = raf.readLine();
                day = raf.readLine();
                checkin = raf.readLine();
                checkout = raf.readLine();
                space = raf.readLine();
                
                myArray [0] = id.substring(9);
                myArray [1] = level.substring(12);
                myArray [2] = size.substring(11);
                myArray [3] = ic.substring(13);
                myArray [4] = name.substring(6);
                myArray [5] = email.substring(7);
                myArray [6] = contact.substring(9);
                myArray [7] = start.substring(12);
                myArray [8] = end.substring(10);
                myArray [9] = day.substring(14);
                myArray [10] = checkin.substring(10);
                myArray [11] = checkout.substring(11);
                myArray [12] = space;
                
                if (myArray[0].equals(room_id) && myArray[3].equals(customeric)){
                    historydata [0] = myArray[0];
                    historydata [1] = myArray[1];
                    historydata [2] = myArray[2];
                    historydata [3] = myArray[3];
                    historydata [4] = myArray[4];
                    historydata [5] = myArray[5];
                    historydata [6] = myArray[6];
                    historydata [7] = myArray[7];
                    historydata [8] = myArray[8];
                    historydata [9] = myArray[9];
                    historydata [10] = myArray[10];
                    historydata [11] = myArray[11];
                }        
       }
    }
    
    //rewriting the booking information + total amount paid into history file
    public String writeHistory(){
        try{
            FileWriter fw = new FileWriter("History.txt",true);
            PrintWriter outputFile = new PrintWriter(fw);
            outputFile.println("Room ID: " + historydata[0]);
            outputFile.println("Room Level: " + historydata[1]);
            outputFile.println("Room Size: " + historydata[2]);
            outputFile.println("IC/Passport: " + historydata[3]);
            outputFile.println("Name: " + historydata[4]);
            outputFile.println("Email: " + historydata[5]);
            outputFile.println("Contact: " + historydata[6]);
            outputFile.println("Start Date: " + historydata[7]);
            outputFile.println("End Date: " + historydata[8]);
            outputFile.println("Days of Stay: " + historydata[9]);
            outputFile.println("Check In: " + historydata[10]);
            outputFile.println("Check Out: " + historydata[11]);
            outputFile.println("Total Paid: " + historydata[12] + "\n");
            outputFile.close();
            return "Success";

        } catch (Exception ex){
            return ex.toString();
        }
    }
}




