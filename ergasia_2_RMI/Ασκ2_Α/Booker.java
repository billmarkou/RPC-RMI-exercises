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
public class Booker
{
    public final String name;
    public final String type;
    public int numberOfRooms;
    
    public Booker(String name, String type, int numberOfRooms)
    {
        this.name = name;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
    }
    
    public void setNumOfRooms(int newRoomsNum)
    {
        this.numberOfRooms -= newRoomsNum;
    }
    
    public String printBooker()
    {
        return "Mr/Ms "+name+" has a reservation for "
                +numberOfRooms+" rooms of type : "+type+"\n";
    }
}
