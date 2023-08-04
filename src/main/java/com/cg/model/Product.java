package com.cg.model;

import java.math.BigDecimal;



public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private String unit;
    private String categoryTitle;

    public Product() {
    }

    public Product(Long id, String title, BigDecimal price, String unit, String categoryTitle) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.unit = unit;
        this.categoryTitle = categoryTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}
