import java.util.*;
import java.lang.*;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bill
 */
public class HRImpl extends java.rmi.server.UnicastRemoteObject 
implements HRInterface
{
    public HRImpl() throws java.rmi.RemoteException
    {
       super();
       ListOfBookers LB = new ListOfBookers();
       ListOfRooms LR = new ListOfRooms();
    }

    
    @Override
    public String printAllRooms() throws RemoteException 
    {
        return LR.printList();
    }

    @Override
    public String book(String bookersName, String roomType, int numOfRooms) 
    throws RemoteException 
    {
        boolean flag = false;
        boolean outOf = false;
        int cost = 0;
        int roomsLeft = 0 ;
        for (int i=0; i<5; i++)
        {
            if (LR.roomList[i].type.equals(roomType))
            {
                if (LR.roomList[i].checkAvail(numOfRooms))
                {
                    LR.roomList[i].bookRoom(numOfRooms);
                    LB.bookerList.add
                    (new Booker(bookersName, roomType, numOfRooms));
                    flag = true;
                    cost = LR.roomList[i].price * numOfRooms;
                }
                else
                {
                    outOf = true;
                    roomsLeft =  LR.roomList[i].roomsAvailable;
                }
                
            }
        }
        if (flag)
        {
            return "Book completed with total cost "+cost+"$\n";
        }
        else if (outOf)
        {
            return"Book failed due to availability\n"
                + " rooms available left : "+roomsLeft;
        }
        else 
        {
            return "Cant find the room you typed";
        }
    }

    
    @Override
    public String unbook(String bookersName, int numOfRooms, String roomType) 
    throws RemoteException
    {
        boolean flag = false;
        for (Booker i : LB.bookerList)
        {
            if (bookersName.equals(i.name) && numOfRooms <= i.numberOfRooms)
            {
                for (int j=0; j<5; j++)
                {
                    if (LR.roomList[j].type.equals(roomType))
                    {
                        LR.roomList[j].unbookRoom(numOfRooms);
                        i.setNumOfRooms(numOfRooms);
                        flag = true;
                    }
                }
                if (numOfRooms == i.numberOfRooms)
                {
                    LB.bookerList.remove(i);
                }
            }
        }
        if (flag)
        {
            return "Cancel succesfull";
        }
        else
        {
            return "Cancel failed";
        }
        
    }

    
    @Override
    public String printAllQuests() throws RemoteException 
    {
        return LB.printList();
    }
}

