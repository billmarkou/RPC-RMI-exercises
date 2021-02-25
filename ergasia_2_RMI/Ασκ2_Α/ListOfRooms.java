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
public class ListOfRooms 
{

    public Room roomList[];

    public ListOfRooms() 
    {
        this.roomList = new Room[5];
        this.roomList[0] = new Room("A", 30, 50);
        this.roomList[1] = new Room("B", 45, 70);
        this.roomList[2] = new Room("C", 25, 80);
        this.roomList[3] = new Room("D", 10, 120);
        this.roomList[4] = new Room("E", 5, 150);
    }
    
    public String printList()
    {
        String result = "";
        for(int i=0; i<5; i++)
        {
            result += roomList[i].printRoom();
        }
        return result;
    }
}
