package tickets;

public class Student extends Ticket {
	
	private String ticketType;
	private double price;
	private int amount;

	public Student(String ticketType, double price) {
		super(ticketType, price);
		this.ticketType = ticketType;
		this.price = price;
	}
	
	public Student(String ticketType, double price, int amount) {
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
