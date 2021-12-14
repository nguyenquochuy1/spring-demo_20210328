package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {


    //this is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    private Long id;
    private String name;
    private String brand;
    private String madeIn;
    private float price;
    private String url;

    public Product(String name, String brand, String madeIn, float price, String url) {
        this.name = name;
        this.brand = brand;
        this.madeIn = madeIn;
        this.price = price;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id" + id + ", " +
                "name" + name + ", " +
                "brand" + brand + ", " +
                "madeIn" + madeIn + "," +
                "gia" + price + "," +
                "url" + url + "}";
    }
}
