package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Model.entity.ProductModel;
import com.Springpro.Springpro.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/ById")
    public ResponseEntity<ProductModel> getProductById(@RequestParam Integer id) {
        ProductModel product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
        ProductModel createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/updateById")
    public ResponseEntity<ProductModel> updateProduct(@RequestParam Integer id, @RequestBody ProductModel product) {
        ProductModel updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/partiallyUpdatedProduct")
    public ResponseEntity<ProductModel> partiallyUpdateProduct(@RequestParam Integer id, @RequestBody ProductModel updatedProduct) {
        ProductModel partiallyUpdatedProduct = productService.updateProductPartially(id, updatedProduct);
        if (partiallyUpdatedProduct != null) {
            return ResponseEntity.ok(partiallyUpdatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteProduct")
    public ResponseEntity<Void> deleteProduct(@RequestParam Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
