import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestClass {
	
public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
	
        int testCase = s.nextInt();
	
        int numberOfRooms = s.nextInt();
        int numberOfCorridors = s.nextInt();
        
        Map<String,Room> rooms = new HashMap<>();
        Map<Integer,List<Room>> linkedRoom = new HashMap<>();
        
        for(int i=1;i<=numberOfRooms;i++){
            Room room= new Room();
            room.name = "room-"+i;
            rooms.put(room.name,room);
        }
        
        for(int j=1;j<= numberOfCorridors; j++){
            int u= s.nextInt();
            int v= s.nextInt();
            if(linkedRoom.containsKey(u)){
                List<Room> corList =linkedRoom.get(u);
                corList.add(rooms.get("room-"+v));
                
                linkedRoom.put(u,corList);
                
                if(linkedRoom.containsKey(v)){
                     List<Room> coList =linkedRoom.get(v);
                corList.add(rooms.get("room-"+u));
                
                linkedRoom.put(v,coList);
                    
                
                }else{
                     List<Room> adRoom = new ArrayList<>();
                adRoom.add(rooms.get("room-"+v));
                List<Room> seRoom = new ArrayList<>();
                seRoom.add(rooms.get("room-"+u));
                
                linkedRoom.put(u,adRoom);
                linkedRoom.put(v,seRoom);
                }
                
            }else{
                
            	List<Room> addRoom = new ArrayList<>();
                addRoom.add(rooms.get("room-"+v));
                List<Room> secRoom = new ArrayList<>();
                secRoom.add(rooms.get("room-"+u));
                
                linkedRoom.put(u,addRoom);
                linkedRoom.put(v,secRoom);
            }
        }
        
        
        //Need to write the searching logic to identify the link       
        //get the lock
        s.nextInt();
        int scource = s.nextInt();
        int vault = s.nextInt();
        
        //to find the sortest path to reach the vault need to be writter 
        // but as i have lack of time unable to write it
        
        
        //release resources
        s.close();


    }
}

class Room{
    List<String> corridorLinked = new ArrayList<>();
    public String name;
}


