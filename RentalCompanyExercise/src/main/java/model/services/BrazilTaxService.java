/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

/**
 *
 * @author lucca
 */
public class BrazilTaxService {
    public double tax(double amount){
        if(amount<=100.0){return amount * .2;}else{return amount *0.15;}
    }
}
