package com.moreno.tryclean.prices.api.dto;


import java.math.BigDecimal;

public class ItemRequest {

    private String itemDescription;
    private BigDecimal itemPrice;
    private Integer numberOfItems;
    private String state;

    public ItemRequest(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.numberOfItems = numberOfItems;
        this.state = state;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
