package com.danilomatta.crud.crudspringboot.entity;

import com.danilomatta.crud.crudspringboot.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductEntityJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;


    public ProductEntityJPA(ProductDTO productDTO){
        this.nome = productDTO.nome();
        this.descricao = productDTO.descricao();
        this.preco = productDTO.preco();
    }

}
