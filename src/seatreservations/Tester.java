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
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reservation rv = new Reservation();
        rv.reserveSeat('A', 11);
        rv.reserveSeat('A', 1);
        rv.reserveSeat('C', 20);
        System.out.println("is seat A 1 reserved? " + rv.isReserved('A', 1));
        System.out.println("empty seats = " + rv.getEmptySeatCount());
    }
    
}
