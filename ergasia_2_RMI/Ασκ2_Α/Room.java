import java.util.*;
import java.lang.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bill
 */
public class Room 
{
    public final String type;
    public int roomsAvailable;
    public final int price;
    
    public Room(String type, int roomsAvailable, int price){
        this.type = type;
        this.roomsAvailable = roomsAvailable;
        this.price = price;
    }
    
    public boolean checkAvail(int num)
    {
        return (num <= roomsAvailable);
    }
    
    public void bookRoom(int num)
    {
        roomsAvailable -= num;
    }
    
    public void unbookRoom(int num)
    {
        roomsAvailable += num;
    }
    
    public String printRoom()
    {
        return "Room Type: "+type+" Available rooms: "
                           +roomsAvailable+" Pricing at: "+price+
                           " $ each\n";
    }
}
