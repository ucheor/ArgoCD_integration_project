package com.restaurant.ordering;

import java.util.List;
import java.util.ArrayList;

public class Receipt {
    private List<OrderItem> items;
    private double taxRate;
    private double serviceCharge;
    private double tip;

    public Receipt() {
        this.items = new ArrayList<>();
        this.taxRate = 0.13; // 13% default
        this.serviceCharge = 0.0;
        this.tip = 0.0;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getSubtotal() {
        return items.stream()
                .mapToDouble(OrderItem::getLineTotal)
                .sum();
    }

    public double getTaxAmount() {
        return getSubtotal() * taxRate;
    }

    public double getTotal() {
        return getSubtotal() + getTaxAmount() + serviceCharge + tip;
    }
}