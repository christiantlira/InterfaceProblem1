package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalServices;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String car = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(car));
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day:");
		double pricePerDay = sc.nextDouble();

		RentalServices rentalService = new RentalServices(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println();

		System.out.println("Invoice:");
		System.out.println("Basic Payment: R$" + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total Payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

		sc.close();
	}

}
