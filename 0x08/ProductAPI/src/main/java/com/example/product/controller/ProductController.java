package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
    })

    @ApiOperation(value = "Responsável por adicionar um produto")
    @ApiResponse(code = 10, message = "Required fields not informed.")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, produces = "application/json")
    public void Post(Product product) {
        productRepository.addProduct(product);
    }

    @ApiOperation(value = "Responsável por retornar uma lista de produtos")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    @RequestMapping(value = "/allProducts", method = RequestMethod.GET, produces = "application/json")
    public List<Product> Get() {
        return productRepository.getAllProducts();
    }

    @ApiOperation(value = "Responsável um produto pelo id")
    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    @RequestMapping(value = "/findProductById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Product> GetById(@PathVariable(value = "id") long id) {
        Product product = productRepository.getProductById(id);
        if (product != null)
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Responsável por remover um produto")
    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    @RequestMapping(value = "/removeProduct", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            productRepository.removeProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Responsável por atualizar um produto")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Product> Put(@PathVariable(value = "id") long id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            productRepository.updateProduct(product);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Responsável por retornar uma mensagem de boas-vindas")
    @RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json")
    public String Welcome() {
        return "Welcome";
    }
}
