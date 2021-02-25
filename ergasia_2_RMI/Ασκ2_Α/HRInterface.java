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
public interface HRInterface extends java.rmi.Remote
{
    public ListOfBookers LB = new ListOfBookers();
    public ListOfRooms LR = new ListOfRooms();
    
    public String printAllRooms() throws java.rmi.RemoteException; 
    
    public String book(String bookersName, String type, int numOfRooms)
    throws java.rmi.RemoteException; 
    
    public String unbook(String bookersName, int numOfRooms, String type)
    throws java.rmi.RemoteException;       
    
    public String printAllQuests() throws java.rmi.RemoteException;      
    
    
}
