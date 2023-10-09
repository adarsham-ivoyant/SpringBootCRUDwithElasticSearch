package com.example.SpringBootCRUDwithElasticSearchOnDocker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "product_index")
public class Product {
    private int id;
    private String pName;

    private int qty;

    private double price ;
}
