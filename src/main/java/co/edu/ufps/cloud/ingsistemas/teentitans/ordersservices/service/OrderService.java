package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service;

import java.util.List;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.OrderDTO;


public interface OrderService {

    List<OrderDTO> listAll();

    OrderDTO getOrder(Long id);

    Long saveOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);

    List<OrderDTO> listAllOrderByCustomer(Long idCustomer);
}
