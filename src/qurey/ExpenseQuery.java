/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qurey;

import db.*;
import exception.NullException;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nadiaislam
 */
interface Expense {

    public void insert(ExpensesEntity expense, Statement statement) throws Exception;

    public void delete(int expense_id, Statement statement) throws Exception;

    public void update(ExpensesEntity expense, Statement statement) throws Exception;

    public List<ExpensesEntity> read(int user_id, Statement statement) throws NullException;

    public List<ExpensesEntity> bin(int user_id, Statement statement) throws NullException;

    public void deleteAllbin(int user_id, Statement statement) throws Exception;

    public void restoreAll(int user_id, Statement statement);

    public void deletebin(int expense_id, Statement statement) throws Exception;

    public void restore(int expense_id, Statement statement);

}

public class ExpenseQuery implements Expense {

    @Override
    public void insert(ExpensesEntity expense, Statement statement) throws Exception {
        String query = "INSERT INTO expenses (category, amount, date, user_id) VALUES ('" + expense.category + "'," + expense.amount + ",'" + expense.date + "'," + expense.user_id + ")";
        if (expense.expense_id != 0) {
            query = "INSERT INTO expenses (id,category, amount, date, user_id) VALUES (" + expense.expense_id + ",'" + expense.category + "'," + expense.amount + ",'" + expense.date + "'," + expense.user_id + ")";

        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public List<ExpensesEntity> read(int user_id, Statement statement) throws NullException {
        List<ExpensesEntity> results = new ArrayList<>();
        String query = "SELECT * FROM expenses WHERE user_id = " + user_id + " AND YEAR(date) = YEAR(CURDATE()) AND MONTH(date) = MONTH(CURDATE()) ORDER BY id DESC";
        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                results.add(new ExpensesEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                while (result.next()) {
                    results.add(new ExpensesEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                }

            } else {
                throw new NullException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return results;
    }

    @Override
    public void delete(int expense_id, Statement statement) throws Exception {
        String query = "DELETE FROM expenses WHERE id = " + expense_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void update(ExpensesEntity expense, Statement statement) throws Exception {
        String query = "UPDATE expenses SET category ='" + expense.category + "',amount =" + expense.amount + ",date='" + expense.date + "' WHERE id =" + expense.expense_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public List<ExpensesEntity> bin(int user_id, Statement statement) throws NullException {
        List<ExpensesEntity> results = new ArrayList<>();
        String query = "SELECT * FROM expenses_backup WHERE user_id = " + user_id + " ORDER BY id DESC";
        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                results.add(new ExpensesEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                while (result.next()) {
                    results.add(new ExpensesEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")));
                }

            } else {
                throw new NullException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return results;
    }

    @Override
    public void deleteAllbin(int user_id, Statement statement) throws Exception {
        String query = "DELETE FROM expenses_backup WHERE user_id = " + user_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void restoreAll(int user_id, Statement statement) {
        try {
            List<ExpensesEntity> backup = bin(user_id, statement);
            for (ExpensesEntity i : backup) {
                insert(i, statement);
            }

            deleteAllbin(user_id, statement);
        } catch (NullException ex) {

        } catch (Exception ex) {
        }
    }

    @Override
    public void deletebin(int expense_id, Statement statement) throws Exception {
        String query = "DELETE FROM expenses_backup WHERE id = " + expense_id + "";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void restore(int expense_id, Statement statement) {
        String query = "SELECT * FROM expenses_backup WHERE id = " + expense_id + "";

        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                insert(new ExpensesEntity(result.getInt("id"), result.getInt("user_id"), result.getDouble("amount"), result.getString("category"), result.getString("date")), statement);
                deletebin(expense_id, statement);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } catch (Exception ex) {
        }
    }

}
