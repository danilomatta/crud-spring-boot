package com.danilomatta.crud.crudspringboot.repository;

import com.danilomatta.crud.crudspringboot.entity.ProductEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductEntityJPA, Long> {

}
