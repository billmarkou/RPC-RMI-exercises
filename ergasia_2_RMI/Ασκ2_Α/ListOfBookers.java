import java.util.*;
import java.lang.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bill
 */
public class ListOfBookers 
{
    public ArrayList<Booker> bookerList; 

    public ListOfBookers() {
        this.bookerList = new ArrayList<Booker>();
        bookerList.add(new Booker("No guests", "", 0));
    }
    
    public String printList()
    {
        String result = "";
        for (Booker i : bookerList)
        {
            result += i.printBooker();
        }
        return result;
    }
}
