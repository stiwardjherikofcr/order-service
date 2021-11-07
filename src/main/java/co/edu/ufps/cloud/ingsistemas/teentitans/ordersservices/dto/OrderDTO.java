package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private CustomerDTO customer;

    private Long paymentMethodId;

    private List<ProductDTO> products;
}
