import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
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
public class HRServer 
{
    public HRServer()
    {
        try
        {
            HRInterface HR = new HRImpl();
            Naming.rebind("rmi://127.0.0.1:1994/HRService",HR);
        }
        catch (MalformedURLException | RemoteException e)
        {
            System.out.println("ERROR : " + e);
        }
    }
    public static void main(String args[])
    {
        new HRServer();
    }
}
