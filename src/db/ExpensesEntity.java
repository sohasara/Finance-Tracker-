/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author nadiaislam
 */
public class ExpensesEntity {

    public int expense_id;
    public int user_id;
    public double amount;
    public String category;
    public String date;

    public ExpensesEntity(int expense_id, int user_id, double amount, String category, String date) {
        this.expense_id = expense_id;
        this.user_id = user_id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public ExpensesEntity(int user_id, double amount, String category, String date) {

        this.user_id = user_id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

}
