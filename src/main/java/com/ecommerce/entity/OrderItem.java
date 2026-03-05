package com.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Double unitPrice;
    private Integer quantity;
    private Double subTotal;

    public OrderItem() {
    }

    public OrderItem(Product product, Double unitPrice, Integer quantity, Double subTotal) {
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
