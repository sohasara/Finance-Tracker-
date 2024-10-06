/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author nadiaislam
 */
public class IncomeEntity {

    public int income_id;
    public int user_id;
    public double amount;
    public String category;
    public String date;

    public IncomeEntity(int income_id, int user_id, double amount, String category, String date) {
        this.income_id = income_id;
        this.user_id = user_id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public IncomeEntity(int user_id, double amount, String category, String date) {

        this.user_id = user_id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

}
