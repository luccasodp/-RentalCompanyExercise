
package Application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;
/**
 *
 * @author lucca
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rental details");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.print("withdrawal [dd/mm/yyyy hh:mm]: ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
        System.out.print("return [dd/mm/yyyy hh:mm]: ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);
        
        CarRental cr = new CarRental(start,finish,new Vehicle(carModel));
        
        System.out.print("Enter with a price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter with a price per day: ");
        double pricePerDay = sc.nextDouble();
        
        RentalService rs = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());
        rs.processInvoice(cr);
        System.out.println("INVOICE");
        System.out.println("Basic payment: "+cr.getInvoice().getBasicPayment());
        System.out.println("Tax: "+cr.getInvoice().getTax());
        System.out.println("Total payment: "+cr.getInvoice().getTotalPayment());
    }
}
