package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.controller;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service.OrderService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<OrderDTO> listAll() {
        return orderService.listAll();
    }

    @GetMapping("/list-order-by-customer")
    public List<OrderDTO> listAllByCustomer(@RequestParam Long idCustomer) {
        return orderService.listAllOrderByCustomer(idCustomer);
    }

    @GetMapping("get-order")
    public OrderDTO getOrder(@RequestParam Long idOrder) {
        return orderService.getOrder(idOrder);
    }

    @PostMapping()
    @ResponseBody
    public Long save(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    @DeleteMapping()
    @ResponseBody
    public void eliminarOrder(@RequestParam Long idOrder) {
        orderService.deleteOrder(idOrder);
    }
}
