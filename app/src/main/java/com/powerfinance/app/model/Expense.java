package com.powerfinance.app.model;

public class Expense {
    private String description;
    private double amount;
    private String dueDate;
    private boolean isPaid; // Adicionei esta propriedade para o status de pagamento

    public Expense(String description, double amount, String dueDate, boolean isPaid) {
        this.description = description;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    // Setters (opcional, dependendo de como você gerencia seus dados)
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}