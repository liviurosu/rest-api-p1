package com.example.restfulservice.controller;

import com.example.restfulservice.controller.model.ProductID;
import com.example.restfulservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {


    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product){
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product("1","Product1",new BigDecimal("258.44")));
        result.add(new Product("2","Product2",new BigDecimal("458.44")));
        result.add(new Product("3","Product3",new BigDecimal("558.44")));
        return result;
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product("888","Random product",new BigDecimal("2128.44"));
    }
    @PatchMapping("/product")
    public void patchProduct(@RequestBody final Product product){
        System.out.println(product);

    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id){
        System.out.println(id);

    }

}
