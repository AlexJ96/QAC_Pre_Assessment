package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tickets.Child;
import tickets.OAP;
import tickets.Standard;
import tickets.Student;
import tickets.Ticket;

public class Main {
	
	private static String[] days = { "mon", "monday", "tues", "tuesday", "wed", "wednesday", "thurs", "thursday", "fri", "friday", "sat", "saturday", "sun", "sunday" };
	private static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public static String[] getDays() {
		return days;
	}
	
	private static boolean discount = false;
	
	public static boolean hasDiscount() {
		return discount;
	}
	
	public static void setDiscount(boolean discountType) {
		discount = discountType;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean stillOrdering = true;
		
		try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("What day would you like to purchase tickets for?\n");
            String day = reader.readLine();
            
            if (day.equalsIgnoreCase(getDays()[4]) || day.equalsIgnoreCase(getDays()[5])) {
        	   setDiscount(true);
            }
            System.out.println("Your chosen day is: " + day + ", you are " + (hasDiscount() == true ? "valid" : "not valid") + " for discounted prices.");
            
            while (stillOrdering) {
            	if (hasDiscount())
            		System.out.println("What ticket would you like? (Discounted)(Standard £6, Student £4, OAP £4, Child £2) \n");
            	else 
            		System.out.println("What ticket would you like? (Standard £8, Student £6, OAP £6, Child £4) \n");
         
            	String ticketType = reader.readLine();
            	System.out.println("How many would you like?");
            	int ticketAmount = Integer.parseInt(reader.readLine());
            	
            	Ticket ticket = new Ticket();
            	
            	switch(ticketType.toLowerCase()) {
            	case "standard":
            		ticket = new Standard("Standard", 8);
            		break;
            	case "student":
            		ticket = new Student("Student", 6);
            		break;
            	case "oap":
            		ticket = new OAP("OAP", 6);
            		break;
            	case "child":
            		ticket = new Child("Child", 4);
            		break;
            	}
            	

        		boolean none = true;
            	if (getTickets().size() > 0) {
	            	for (int i = 0; i < getTickets().size(); i++) {
	                	if (getTickets().get(i).getTicketType().equalsIgnoreCase(ticket.getTicketType())) {
	                		Ticket currentInstanceTicket = getTickets().get(i);
	                		currentInstanceTicket.setAmount(currentInstanceTicket.getAmount() + ticketAmount);
	                		getTickets().set(i, currentInstanceTicket);
	                		none = false;
	                		break;
	                	}
	            	}	
            	} else {
            		ticket.setAmount(ticketAmount);
            		getTickets().add(ticket);
            		none = false;
            	}
            	
            	if (none) {
            		ticket.setAmount(ticketAmount);
            		getTickets().add(ticket);
            	}
            	
            	String currentTicketsString = "Current Tickets: ";
            	for (int i = 0; i < getTickets().size(); i++) {
            		String currentTicketType = getTickets().get(i).getTicketType();
            		int currentTicketAmount = getTickets().get(i).getAmount();
            		double currentTicketPrice = getTickets().get(i).getPrice() * currentTicketAmount;
            		if (hasDiscount()) {
            			currentTicketPrice -= currentTicketAmount * 2;
            		}
            		currentTicketsString += "" + currentTicketAmount + "x " + currentTicketType + " costing: £" + currentTicketPrice + (i == getTickets().size()-1 ? ". " : ", ");
            	}
            	System.out.println(currentTicketsString);
            }
		} catch (IOException ioe) {
            ioe.printStackTrace();
        }
		
		Standard standard = new Standard("Standard", 8);
		OAP oap = new OAP("OAP", 6);
		Student student = new Student("Student", 6);
		Child child = new Child("Child", 4);
		
		System.out.println(standard.getPrice() + " " + oap.getPrice() + " " + student.getPrice() + " " + child.getPrice() + " ");
		

	}

}
