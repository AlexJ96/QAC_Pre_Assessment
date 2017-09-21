package tickets;

public class Child extends Ticket {
	
	private String ticketType;
	private double price;
	private int amount;

	public Child(String ticketType, double price) {
		super(ticketType, price);
		this.ticketType = ticketType;
		this.price = price;
	}
	
	public Child(String ticketType, double price, int amount) {
		super(ticketType, price);
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
