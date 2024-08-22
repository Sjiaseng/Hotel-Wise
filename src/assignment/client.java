
package assignment;

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
import java.util.Scanner;


public class client{
    private String customername;
    private String customeric;
    private String customergender;
    private String customeremail;
    private String customercontact;
    private String customerdate;
    private String deleteic;
    
    //constructors
    public client(String deleteic){
        this.deleteic = deleteic;
    }
    
    
    public client(String customername, String customeric, String customergender, String customeremail, String customercontact, String customerdate){
        this.customername = customername;
        this.customeric = customeric;
        this.customergender = customergender;
        this.customeremail = customeremail;
        this.customercontact = customercontact;
        this.customerdate = customerdate;
    }
     
    //write new customer record into customer txt
    public String registercustomer(){
        try{
            FileWriter fw = new FileWriter("Customer.txt",true);
                PrintWriter outputFile = new PrintWriter(fw);
                outputFile.println("Full Name: " + customername);
                outputFile.println("Ic/Passport: " + customeric);
                outputFile.println("Gender: " + customergender);
                outputFile.println("Email: " + customeremail);
                outputFile.println("Contact: " + customercontact);
                outputFile.println("Register Date: " + customerdate + "\n");
                outputFile.close();
                return "Success";

        } catch (Exception ex){
            return ex.toString();
        }
    }  
    
    //deleting the existing customer data
    public String deletecustomer() throws FileNotFoundException, IOException{
        String customername, customeric, customergender, customeremail, customercontact, customerdate, customerspace;
        RandomAccessFile raf = new RandomAccessFile("Customer.txt", "rw");
        
        String[] myArray = new String[7];
        
        for(int i=1; i < countlines3() ; i++){
                customername = raf.readLine();
                customeric = raf.readLine();
                customergender = raf.readLine();
                customeremail = raf.readLine();  
                customercontact = raf.readLine();
                customerdate = raf.readLine();
                customerspace = raf.readLine();
                
                myArray [0] = customername;
                myArray [1] = customeric;
                myArray [2] = customergender;
                myArray [3] = customeremail;
                myArray [4] = customercontact;
                myArray [5] = customerdate;
                myArray [6] = customerspace;
                
                
                if (myArray[1].equals("Ic/Passport: "+ deleteic)){
                    myArray [0] = "";
                    myArray [1] = "";
                    myArray [2] = "";
                    myArray [3] = "";
                    myArray [4] = "";
                    myArray [5] = "";
                    myArray [6] = "";
                    
                }
                
                else{
                    FileWriter writer = new FileWriter("Customer.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    writer.write(myArray[6]+"\n");
                    
                    writer.close();
                }
                    
        }
        Path tempFilePath = Paths.get("Customer.tmp");
        Path originalFilePath = Paths.get("Customer.txt");

        var lines = Files.readAllLines(tempFilePath);


        Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);


        Files.delete(tempFilePath);
        
        
        
        File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Customer.tmp");
        
        if (tempFile.exists()) {
            tempFile.delete();
            tempFile.createNewFile();
            System.out.println("Temp file cleared successfully.");
        }
        
        return "Success";        
    }
    
    //find the number of available data and number of iteration for Customer.txt
    static int countlines3() throws FileNotFoundException{
            File file = new File("Customer.txt");
            Scanner scanner = new Scanner(file);
            int count = 0;
            int line = 0;
            
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();
            
            return count/6+1/2+1;
                   
    }
    
//store the booking data (name,email,contact) - > show in the booking form
    public static String[] myBookingData = new String[3];
    
    public String getCustomerBookingData() throws FileNotFoundException, IOException{
        String customername, customer_ic, customergender, customeremail, customercontact, customerdate, customerspace;
        RandomAccessFile raf = new RandomAccessFile("Customer.txt", "rw");
        
        
        for(int i=1; i < countlines3() ; i++){
                customername = raf.readLine();
                customer_ic = raf.readLine();
                customergender = raf.readLine();
                customeremail = raf.readLine();  
                customercontact = raf.readLine();
                customerdate = raf.readLine();
                customerspace = raf.readLine();
                
                if(customer_ic.substring(13).equals(deleteic)){
                    myBookingData [0] = customername.substring(11);
                    myBookingData [1] = customeremail.substring(7);
                    myBookingData [2] = customercontact.substring(9);
                    return "Success";
                }
        }
        
        
        return "Fail";
    }
    
}
