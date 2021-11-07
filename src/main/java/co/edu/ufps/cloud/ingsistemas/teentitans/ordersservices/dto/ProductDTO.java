package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String description;
    private int quantity;
    private double price;

}
