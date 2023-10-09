package com.example.SpringBootCRUDwithElasticSearchOnDocker.serivce;

import com.example.SpringBootCRUDwithElasticSearchOnDocker.entity.Product;
import com.example.SpringBootCRUDwithElasticSearchOnDocker.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product insertProduct(Product product) {
        return productRepo.save(product);
    }


    public String deleteProduct(int id) {
       try {
           productRepo.deleteById(id);
           return "successfully deleted";
       }catch(Exception e){
           return e.getMessage();
       }

    }
    public Product getProduct(int id) {
        return productRepo.findById(id).get();
    }
}
