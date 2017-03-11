/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatreservations;

/**
 *
 * @author dyanek
 */
public class Reservation {
    
    private boolean[][] economy;
    private boolean[][] firstClass;
    
    //constructor
    public Reservation()
    {
        economy=new boolean[6][20];
        firstClass = new boolean[4][2];
    }
    
    public int getLetterRow(char letter, int jetRow)
    {
        // System.out.println("letter check= " + letter);
        int seat = -1; 
        if((jetRow == 1)||(jetRow==2))
         {
             if(letter == 'A')
             {
                 seat=0;
             }
             else if(letter == 'C')
             {
                 seat=1;
             }
             else if(letter == 'J')
             {
                 seat=2;
             }
             else
             {
                 
                 seat = 3;
             }
             
         }
        if((jetRow>=11) && (jetRow<=30))
         {
             if(letter == 'A')
             {
                 seat=0;
             }
             else if(letter == 'B')
             {
                 seat=1;
             }
             else if(letter == 'C')
             {
                 seat=2;
             }
             else if(letter == 'J')
             {
                 seat=3;
             }
             else if(letter == 'K')
             {
                 seat=4;
             }
             else if(letter == 'L')
             {
                 seat=5;
             }
             else
             {
                 //out of bounds
                 seat = 6;
             }  
             
        }
        return seat;
    }
    
    //returns true if seat is already taken
    //returns false if seat is not taken
    public boolean isReserved(char letter, int jetRow)
    {
        //System.out.println("letter check= " + letter);
        int seat = this.getLetterRow(letter, jetRow); 
        //System.out.println("seat check" + seat);
        if((jetRow == 1)||(jetRow==2))
         {
             
             return firstClass[seat][jetRow-1];
             
         }
         if((jetRow>=11) && (jetRow<=30))
         {
             
             return economy[seat][jetRow -11];
         }
         return false;   
   
    }
    
    //if seat is not taken, reserves seat by setting value to true
    //returns true if seat was successfully reserved. 
    //returns false if seat has not been reserved because location
    //is taken
    public boolean reserveSeat(char letter, int jetRow)
    {
        if(this.isReserved(letter, jetRow)==false)
        {
           int seat = this.getLetterRow(letter, jetRow); 
            if((jetRow == 1)||(jetRow==2))
            {
             
             firstClass[seat][jetRow-1]=true;
             return true;
             
            }
            if((jetRow>=11) && (jetRow<=30))
            {
             
             economy[seat][jetRow -11]=true;
             return true;
            }
         return false;   
        }
        return false;
    }  

    //returns the total number of seats that are not reserved
    public int getEmptySeatCount( )
    {
        int count =0;
        
        //count first class empty seats
        for(int row =0; row < firstClass.length; row++)
        {
            for(int col=0; col< firstClass[row].length; col++)
            {
                if(firstClass[row][col]==false)
                {
                    count++;
                }
            }
        }
        
        //count economy class empty seats
         for(int row =0; row < economy.length; row++)
        {
            for(int col=0; col< economy[row].length; col++)
            {
                if(economy[row][col]==false)
                {
                    count++;
                }
            }
        }
    
         return count;
    }        

    
}
