/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.time.Duration;
import model.entities.CarRental;
import model.entities.Invoice;

/**
 *
 * @author lucca
 */
public class RentalService {
    private double pricePerHour;
    private double pricePerDay;
    private BrazilTaxService taxService;

    public RentalService(double pricePerHour, double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
    public void processInvoice(CarRental cr){
        long minutes = Duration.between(cr.getStart(), cr.getFinish()).toMinutes();
        long hour = minutes/60;
        double basicPayment;
        if (hour>12.0){basicPayment = Math.ceil(hour) * pricePerHour;}
        else{basicPayment = pricePerDay * Math.ceil(hour/24);}
        
        cr.setInvoice(new Invoice(basicPayment,taxService.tax(basicPayment)));
    }
}
