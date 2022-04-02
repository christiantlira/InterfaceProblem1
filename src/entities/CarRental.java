package entities;

import java.util.Date;

public class CarRental {
	private Vehicle model;
	private Date start;
	private Date finish;
	private Invoice invoice;

	public CarRental() {
	}
	
	public CarRental(Date start, Date finish, Vehicle model) {
		this.model = model;
		this.start = start;
		this.finish = finish;
	}

	public Vehicle getModel() {
		return model;
	}

	public void setModel(Vehicle model) {
		this.model = model;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
