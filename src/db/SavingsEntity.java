/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Lenovo
 */
public class SavingsEntity {

    public double total_income;
    public double total_expense;
    public String date;
    public String user_name;

    public SavingsEntity(double total_income, double total_expense, String date, String user_name) {
        this.total_income = total_income;
        this.total_expense = total_expense;
        this.date = date;
        this.user_name = user_name;
    }
    public SavingsEntity(double total_income, double total_expense) {
        this.total_income = total_income;
        this.total_expense = total_expense;
        
    }
    

}
