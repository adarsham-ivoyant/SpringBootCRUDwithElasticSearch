package com.example.SpringBootCRUDwithElasticSearchOnDocker.controller;

import com.example.SpringBootCRUDwithElasticSearchOnDocker.entity.Product;
import com.example.SpringBootCRUDwithElasticSearchOnDocker.repository.ProductRepo;
import com.example.SpringBootCRUDwithElasticSearchOnDocker.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return  productService.insertProduct(product);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails){
        try{
            Product product = productRepo.findById(productId).get();
            product.setPName(productDetails.getPName());
            final Product updatedProduct = productRepo.save(product);
            return ResponseEntity.ok(updatedProduct);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "deleted Successfully";
    }
}
