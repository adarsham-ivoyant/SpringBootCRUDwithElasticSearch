package com.example.SpringBootCRUDwithElasticSearchOnDocker.repository;

import com.example.SpringBootCRUDwithElasticSearchOnDocker.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product,Integer> {
}
