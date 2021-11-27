package models;

public class OrderSummary {

    private String orderItemName;
    private double orderItemPrice;
    private  double orderItemTax;
    private double orderItemTotal;



    public OrderSummary(String orderItemName,double orderItemPrice,double orderItemTax,double orderItemTotal){
        this.orderItemName = orderItemName;
        this.orderItemPrice = orderItemPrice;
        this.orderItemTax  = orderItemTax;
        this.orderItemTotal = orderItemTotal;
    }


    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public double getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(double orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public double getOrderItemTax() {
        return orderItemTax;
    }

    public void setOrderItemTax(double orderItemTax) {
        this.orderItemTax = orderItemTax;
    }

    public double getOrderItemTotal() {
        return orderItemTotal;
    }

    public void setOrderItemTotal(double orderItemTotal) {
        this.orderItemTotal = orderItemTotal;
    }
}
