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
import java.util.Arrays;
import java.util.Scanner;


public class staff{
    private String username;
    private String email;
    private String password;
    private String security;
    private String date;
    private String newpassword;
    
    //constructors
    public staff(String email, String password){                   
        this.email = email;
        this.password = password;          
    }
    
    public staff(String email, String security, String newpassword){                   
        this.email = email;
        this.security = security;    
        this.newpassword = newpassword;
    }
    
    public staff(String username, String email, String password, String security ){                   
        this.username = username;
        this.email = email;
        this.password = password;           
        this.security = security;
    }
    
    public staff(String username, String email, String password, String security, String date){                   
        this.username = username;
        this.email = email;
        this.password = password;           
        this.security = security;
        this.date = date;
    }
    
    //write record / register admin into system
    public String writeRecord(){
        try{
                FileWriter fw = new FileWriter("Login.txt",true);
                PrintWriter outputFile = new PrintWriter(fw);
                outputFile.println("Username: " + username);
                outputFile.println("Email: " + email);
                outputFile.println("Password: " + password);
                outputFile.println("Security: " + security);
                outputFile.println("Register Date: " + date + "\n");
                outputFile.close();
                return "Success";

        } catch (Exception ex){
            return ex.toString();
        }
    }
    
    //number to iterate in login file
    static int countlines() throws FileNotFoundException{
            File file = new File("Login.txt");
            Scanner scanner = new Scanner(file);
            int count = 0;
            int line = 0;
            
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();
            
            return count/6+1;
                   
    }
    
    //check if password and email are available
    public String login() throws FileNotFoundException, IOException{
            String myusername, myemail, mypassword, mysecurity, mydate, myspace;
                
            RandomAccessFile raf = new RandomAccessFile("Login.txt", "rw");
            
            for(int i=1; i < countlines() ; i++){
            
                myusername = raf.readLine().substring(10);
                myemail = raf.readLine().substring(7);
                mypassword = raf.readLine().substring(10);
                mysecurity = raf.readLine().substring(10);
                mydate =raf.readLine().substring(15);
                myspace =raf.readLine().substring(0);
                
                if(myemail.equals(email) && mypassword.equals(password)){      
                    return "Success";
                    
                }
                else{
                    continue;
                }
                
            }
            return "Fail";
    }
    
    //check security and email is valid
    public String checkforgetpassword() throws FileNotFoundException, IOException{
        String myusername, myemail, mypassword, mysecurity, mydate, myspace;
        
        RandomAccessFile raf = new RandomAccessFile("Login.txt", "rw");
        
        for(int i=1; i < countlines() ; i++){
            
                myusername = raf.readLine().substring(10);
                myemail = raf.readLine().substring(7);
                mypassword = raf.readLine().substring(10);
                mysecurity = raf.readLine().substring(10);
                mydate =raf.readLine().substring(15);
                myspace =raf.readLine().substring(0);
                
                
                if(myemail.equals(email) && mysecurity.equals(password)){
                    return "Success";
                }
                else{
                    continue;
                }
        }
        
        return "Fail";
    }
    
    static int countlines2() throws FileNotFoundException{
            File file = new File("Login.txt");
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
    
    //modify the password as email and security code matches the data during loops
    public String changepassword() throws FileNotFoundException, IOException{
        String myusername, myemail, mypassword, mysecurity, mydate, myspace;
        RandomAccessFile raf = new RandomAccessFile("Login.txt", "rw");
        
        String[] myArray = new String[6];
        
        for(int i=1; i < countlines2() ; i++){
                myusername = raf.readLine();
                myemail = raf.readLine();
                mypassword = raf.readLine();
                mysecurity = raf.readLine();  
                mydate = raf.readLine();
                myspace = raf.readLine();
                
                myArray [0] = myusername;
                myArray [1] = myemail;
                myArray [2] = mypassword;
                myArray [3] = mysecurity;
                myArray [4] = mydate;
                myArray [5] = myspace;
                
                
                if (myArray[1].equals("Email: "+email)){
                    myArray [2] = "Password: "+ newpassword;
                }
                
                FileWriter writer = new FileWriter("Login.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    
                    writer.close();
                    
        }
        Path tempFilePath = Paths.get("Login.tmp");
        Path originalFilePath = Paths.get("Login.txt");

        var lines = Files.readAllLines(tempFilePath);


        Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);


        Files.delete(tempFilePath);
        
        
        
        File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Login.tmp");
        
        if (tempFile.exists()) {
            tempFile.delete();
            tempFile.createNewFile();
            System.out.println("Temp file cleared successfully.");
        }
        
        return "Success";        
    }

        
    public static String[] myData = new String[4];
    
    //get session data such as username,email,password,security once user login
    public void mySession() throws FileNotFoundException, IOException{
        String myusername, myemail, mypassword, mysecurity, mydate, myspace;
        RandomAccessFile raf = new RandomAccessFile("Login.txt", "rw");
        
        
        for(int i=1; i < countlines() ; i++){
            
                myusername = raf.readLine().substring(10);
                myemail = raf.readLine().substring(7);
                mypassword = raf.readLine().substring(10);
                mysecurity = raf.readLine().substring(10);
                mydate = raf.readLine().substring(15);
                myspace =raf.readLine().substring(0);
                
                if(mypassword.equals(password) && myemail.equals(email)){
                  myData[0] = myusername;
                  myData[1] = myemail;
                  myData[2] = mypassword;
                  myData[3] = mysecurity;


                }
        }
    }
    
    //modify the contents of the lines when data matches
    public String modifyprofile()throws FileNotFoundException, IOException{
        String myusername, myemail, mypassword, mysecurity, mydate, myspace;
        RandomAccessFile raf = new RandomAccessFile("Login.txt", "rw");
        
        String[] myArray = new String[6];
        
        for(int i=1; i < countlines2() ; i++){
                myusername = raf.readLine();
                myemail = raf.readLine();
                mypassword = raf.readLine();
                mysecurity = raf.readLine();  
                mydate = raf.readLine();
                myspace = raf.readLine();
                
                myArray [0] = myusername;
                myArray [1] = myemail;
                myArray [2] = mypassword;
                myArray [3] = mysecurity;
                myArray [4] = mydate;
                myArray [5] = myspace;
                
                
                if (myArray[0].equals("Username: "+ myData[0]) && myArray[1].equals("Email: "+ myData[1]) ){
                    myArray [0] = "Username: " + username;
                    myArray [1] = "Email: " + email;
                    myArray [2] = "Password: "+ password;
                    myArray [3] = "Security: "+ security;
                }
                
                FileWriter writer = new FileWriter("Login.tmp", true);
      
                    writer.write(myArray[0]+"\n");
                    writer.write(myArray[1]+"\n");
                    writer.write(myArray[2]+"\n");
                    writer.write(myArray[3]+"\n");
                    writer.write(myArray[4]+"\n");
                    writer.write(myArray[5]+"\n");
                    
                    writer.close();
                    
        }
        Path tempFilePath = Paths.get("Login.tmp");
        Path originalFilePath = Paths.get("Login.txt");

        var lines = Files.readAllLines(tempFilePath);


        Files.write(originalFilePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);


        Files.delete(tempFilePath);
        
        
        
        File tempFile = new File("C:/Users/user/Desktop/Java/assignment/Login.tmp");
        
        if (tempFile.exists()) {
            tempFile.delete();
            tempFile.createNewFile();
            System.out.println("Temp file cleared successfully.");
        }
        
        return "Success";        
    }
    

}


