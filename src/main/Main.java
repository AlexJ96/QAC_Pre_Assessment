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
	private static String[] ticketTypes = { "standard", "student", "oap", "child" };
	
	private static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public static String[] getDays() {
		return days;
	}
	
	public static String[] getTicketTypes() {
		return ticketTypes;
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
    	String currentTicketsString = "Current Tickets: ";
		
		try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            boolean validDay = false;
            while (!validDay) {
	            System.out.print("What day would you like to purchase tickets for?\n");
	            String day = reader.readLine();
	            
	            for (int i = 0; i < getDays().length; i++) {
	            	if (day.equalsIgnoreCase(getDays()[i])) {
	            		validDay = true;
	            	}
	            }
	            
	            if (day.equalsIgnoreCase(getDays()[4]) || day.equalsIgnoreCase(getDays()[5])) {
	         	   setDiscount(true);
	            }
	            
	            if (validDay)
	            	System.out.println("Your chosen day is: " + day + ", you are " + (hasDiscount() == true ? "valid" : "not valid") + " for discounted prices."); 
	            else 
	            	System.out.println("You've not chosen a valid day, please enter a valid day: (Example 'Mon'/'Monday')");
            }
           
            while (stillOrdering) {
            	
            	boolean validTicket = false;
            	String ticketType = "";
            	
            	while (!validTicket) {
	            	if (hasDiscount())
	            		System.out.println("What ticket would you like? (Discounted)(Standard £6, Student £4, OAP £4, Child £2) \n");
	            	else 
	            		System.out.println("What ticket would you like? (Standard £8, Student £6, OAP £6, Child £4) \n");
	         
	            	ticketType = reader.readLine();
	            	for (int i = 0; i < getTicketTypes().length; i++) {
		            	if (ticketType.equalsIgnoreCase(getTicketTypes()[i])) {
		            		validTicket = true;
		            	}
		            }
	            	
	            	if (!validTicket)
	            		System.out.println("That is not a valid ticket type, please try again.");
            	}
            	
            	
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
	                		System.out.println("here");
	                		break;
	                	}
	            	}	
            	} else {
            		ticket.setAmount(ticketAmount);
            		getTickets().add(ticket);
            		none = false;
            		System.out.println("here2");
            	}
            	
            	if (none) {
            		ticket.setAmount(ticketAmount);
            		getTickets().add(ticket);
            		System.out.println("here3");
            	}
            	
            	System.out.println(getTickets().toString());
            	
            	String localTicketString = "Current Tickets: ";
            	for (int i = 0; i < getTickets().size(); i++) {
            		String currentTicketType = getTickets().get(i).getTicketType();
            		int currentTicketAmount = getTickets().get(i).getAmount();
            		double currentTicketPrice = getTickets().get(i).getPrice() * currentTicketAmount;
            		if (hasDiscount()) {
            			currentTicketPrice -= currentTicketAmount * 2;
            		}
            		localTicketString += currentTicketAmount + "x " + currentTicketType + " costing: £" + currentTicketPrice + (i == getTickets().size()-1 ? ". " : ", ");
            	}
            	System.out.println(localTicketString);
            	System.out.println("Would you like anymore tickets? (Yes, No)");
            	String moreTickets = reader.readLine();
            
            	if (moreTickets.equalsIgnoreCase("no"))
            		stillOrdering = false;
            	currentTicketsString = localTicketString;
            }
		} catch (IOException ioe) {
            ioe.printStackTrace();
        }
    	System.out.println(currentTicketsString.replace("Current Tickets: ", "Ticket Overview: "));
    	double ticketPrice = 0;
    	for (int i = 0; i < getTickets().size(); i++) {
    		int currentTicketAmount = getTickets().get(i).getAmount();
    		double currentTicketPrice = getTickets().get(i).getPrice() * currentTicketAmount;
    		if (hasDiscount()) {
    			currentTicketPrice -= currentTicketAmount * 2;
    		}
    		ticketPrice += currentTicketPrice;
    	}
    	
    	System.out.println("Total amount due: £" + ticketPrice);
	}

}
