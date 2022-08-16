package com.example.product.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        Product product = list.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return product;
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        Product product = list.stream()
                .filter(t -> s.getId().equals(t.getId()))
                .findFirst()
                .orElse(null);
        if(product != null){
                product.setCode(s.getCode());
                product.setCreatedOne(s.getCreatedOne());
                product.setDescription(s.getDescription());
                product.setPrice(s.getPrice());
                product.setStatus(s.getStatus());
        }
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }
}