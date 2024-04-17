package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Model.entity.ProductModel;
import com.Springpro.Springpro.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel getProductById(Integer id) {
        Optional<ProductModel> productOptional = productRepository.findById(id);
        return productOptional.orElse(new ProductModel());
    }

    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public ProductModel updateProduct(Integer id, ProductModel updatedProduct) {
        Optional<ProductModel> optionalExistingProduct = productRepository.findById(id);

        if (optionalExistingProduct.isPresent()) {
            ProductModel existingProduct = optionalExistingProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setCategory(updatedProduct.getCategory());
            return productRepository.save(existingProduct);
        } else {
            return new ProductModel();
        }
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public ProductModel updateProductPartially(Integer id, ProductModel updatedProduct) {
        Optional<ProductModel> optionalExistingProduct = productRepository.findById(id);

        if (optionalExistingProduct.isPresent()) {
            ProductModel existingProduct = optionalExistingProduct.get();
            if (updatedProduct.getName() != null) {
                existingProduct.setName(updatedProduct.getName());
            }
            if (updatedProduct.getDescription() != null) {
                existingProduct.setDescription(updatedProduct.getDescription());
            }
            if (updatedProduct.getPrice() != 0) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getQuantity() != 0) {
                existingProduct.setQuantity(updatedProduct.getQuantity());
            }
            if (updatedProduct.getCategory() != null) {
                existingProduct.setCategory(updatedProduct.getCategory());
            }

            return productRepository.save(existingProduct);
        } else {
            return new ProductModel();
        }
    }
}
