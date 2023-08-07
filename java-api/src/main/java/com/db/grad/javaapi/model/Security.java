package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    
    private String isin;
    private String cusip;
    private String issuer_name;
    private java.sql.Date maturity_date;
    private float coupon;
    private String type;
    private float face_value;
    private String currency;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }
    
    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public java.sql.Date getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(java.sql.Date maturity_date) {
        this.maturity_date = maturity_date;
    }

    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getFace_value() {
        return face_value;
    }

    public void setFace_value(float face_value) {
        this.face_value = face_value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
