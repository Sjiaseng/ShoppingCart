package com.myWebApp.myWebApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myWebApp.myWebApp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    //public List<Product> findByBrand(String brand);

    //JPQL - JPA Query Language

    @Query("SELECT p FROM Product p WHERE " + 
    "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + 
    "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);


}
