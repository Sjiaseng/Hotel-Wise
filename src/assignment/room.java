package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class room {
    public String room_id;
    public String room_level;
    public String room_size;
    
    //constructors
    public room(String room_id){
        this.room_id = room_id;
    }
    
    public room(String room_id, String room_level){
        this.room_id = room_id;
        this.room_level = room_level;
    }
    
    public room(String room_id, String room_level, String room_size){
        this.room_id = room_id;
        this.room_level = room_level;
        this.room_size = room_size;
    }
    
    
    //number to iterate in Room.txt
    static int countlines() throws FileNotFoundException {
        File file = new File("Room.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }

        scanner.close();

        return count / 4 + 1; // Divide by 4 since each room consists of 4 lines
    }

    
    public static String[] myRoom = new String[3];

    //get room data and place it into myroom array
    public String searchroomdata() throws FileNotFoundException, IOException {
        String roomid, roomlevel, roomsize, roomspace;
        
        RandomAccessFile raf = new RandomAccessFile("Room.txt", "r");
        
        for (int i = 1; i <= countlines(); i++) {
            roomid = raf.readLine();
            roomlevel = raf.readLine();
            roomsize = raf.readLine();
            roomspace = raf.readLine();

        if (roomid.substring(9).equals(room_id)) {
            roomid = roomid.substring(9);
            roomlevel = roomlevel.substring(12);
            roomsize = roomsize.substring(11);

            myRoom[0] = roomid;
            myRoom[1] = roomlevel;
            myRoom[2] = roomsize;
        }
    }

    return "Success";
}



}





