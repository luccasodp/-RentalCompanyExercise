
package Application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
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
        System.out.print("withdrawal [dd/mm/yyyy hh:mm]: ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);
        
        CarRental cr = new CarRental(start,finish,new Vehicle(carModel));
       
    }
}
