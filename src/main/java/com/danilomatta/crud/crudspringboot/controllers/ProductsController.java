package com.danilomatta.crud.crudspringboot.controllers;

import com.danilomatta.crud.crudspringboot.DTO.ProductDTO;
import com.danilomatta.crud.crudspringboot.entity.ProductEntityJPA;
import com.danilomatta.crud.crudspringboot.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProduct(){
        List listProduct = productRepository.findAll();
        if(listProduct.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A lista de produtos está vazia");
        }
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }

    @GetMapping("listar-id/{id}")
    public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Long id){
        Optional<ProductEntityJPA> optionalProductEntityJPA = productRepository.findById(id);
        ProductEntityJPA productEntityJPA = productRepository.getReferenceById(id);
        if(optionalProductEntityJPA.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não localizado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productEntityJPA);
    }

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity cadastrarProduct(@RequestBody @Valid ProductDTO produtoDTO){
        ProductEntityJPA productEntityJPA = new ProductEntityJPA(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productEntityJPA));
    }
}
