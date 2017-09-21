/**
 * 
 */
package tickets;

/**
 * @author Alex
 *
 */
public class Ticket {
	
	private String ticketType;
	private double price;
	private int amount;
	
	public Ticket(String ticketType, double price) {
		this.ticketType = ticketType;
		this.price = price;
	}
	
	public Ticket() {
	}
	
	public Ticket(String ticketType, double price, int amount) {
		this.ticketType = ticketType;
		this.price = price;
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getTicketType() {
		return ticketType;
	}
	
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
}
