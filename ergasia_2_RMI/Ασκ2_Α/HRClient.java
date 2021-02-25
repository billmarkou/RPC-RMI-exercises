import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bill
 */
public class HRClient
{
    public static void main(String[] args) 
    {
        if (args.length == 0)
        {
                System.out.println("!!!!!!!!!!!!!!!!!!---WELCOME"
                + "---!!!!!!!!!!!!!!!!!!");
                System.out.println("Give argument list <hostname> if you want to "
                +"print a list of our available rooms\nGive argument book "
                + "<hostname> <type> (wich is type of room A ,B ,C ,D or E) "
                + "<number> (how many rooms you want) and <name> (your name)\n "
                + "Give argument cancel <hostname> <type> <number> <name> to "
                + "cancel your reservation\nGive guests <hostname> to print "
                + "a the reservation list");
        }
        else
        {
            try
            {
              	HRInterface HR = (HRInterface) Naming.lookup("rmi://"+args[1]+":1994/HRService");
                
                switch (args[0])
                {
                    case "list":
                        System.out.println(HR.printAllRooms());                                
                        break;
                      
                    case "book":
                        System.out.println(HR.book(args[4], args[2], Integer.parseInt(args[3])));
                        break;
                        
                    case "cancel":
                        System.out.println(HR.unbook(args[4], Integer.parseInt(args[3]), args[2]));
                        break;
                        
                    case "guests":
                        System.out.println(HR.printAllQuests());
                        break;
                        
                    default:
                        System.out.println("!!!!!!!!!!!!!!!!!!---WELCOME"
                        + "---!!!!!!!!!!!!!!!!!!");
                         System.out.println("Give argument list <hostname> if you want to "
                         +"print a list of our available rooms\nGive argument book "
                         + "<hostname> <type> (wich is type of room A ,B ,C ,D or E) "
                         + "<number> (how many rooms you want) and <name> (your name)\n "
                         + "Give argument cancel <hostname> <type> <number> <name> to "
                         + "cancel your reservation\nGive guests <hostname> to print "
                         + "a the reservation list");
                }
            }
            catch (MalformedURLException murle)
            { 
		System.out.println(); 
		System.out.println("MalformedURLException"); 
		System.out.println(murle); 
            } 
            catch (RemoteException re)
            { 
                System.out.println(); 
		System.out.println("RemoteException"); 
		System.out.println(re); 
            } 
            catch (NotBoundException nbe) 
            { 
		System.out.println(); 
		System.out.println("NotBoundException"); 
		System.out.println(nbe); 
            } 
            
        }
    }
}
