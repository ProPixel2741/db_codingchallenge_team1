package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private String currency;
    private int quantity;
    private float unit_price;
    private String buy_sell;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "counter_party_id")
    private CounterParty counterParty;

    @ManyToOne
    @JoinColumn(name = "security_id")
    private Security security;

    private java.sql.Date trade_date;
    private java.sql.Date settlement_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getBuy_sell() {
        return buy_sell;
    }

    public void setBuy_sell(String buy_sell) {
        this.buy_sell = buy_sell;
    }

    public java.sql.Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(java.sql.Date trade_date) {
        this.trade_date = trade_date;
    }

    public java.sql.Date getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(java.sql.Date settlement_date) {
        this.settlement_date = settlement_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CounterParty getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(CounterParty counterParty) {
        this.counterParty = counterParty;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
