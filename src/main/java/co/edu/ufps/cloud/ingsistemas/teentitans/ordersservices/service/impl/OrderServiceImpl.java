package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service.impl;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.convertidores.OrderMapper;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.OrderDTO;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.OrderEntity;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionDuplicidad;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionSinDatos;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.repository.OrderRepository;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDTO> listAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderMapper.listOrderEntityToListOrderDto(orderEntities);
    }

    @Override
    public OrderDTO getOrder(Long id) {
        OrderEntity existo = orderRepository.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la order #" + id)
        );
        OrderDTO dto = orderMapper.orderEntityToOrderDto(existo);
        return dto;
    }

    @Override
    public Long saveOrder(OrderDTO orderDTO) {
        existo(orderDTO.getId());
        OrderEntity entity = orderMapper.orderDtoToOrderEntoty(orderDTO);
        entity = orderRepository.save(entity);
        return entity.getId();
    }

    @Override
    public void deleteOrder(Long id) {
        noExisto(id);
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> listAllOrderByCustomer(Long idCustomer) {
        List<OrderEntity> orderEntities = orderRepository.findAllByCustomer(idCustomer);
        if (orderEntities.isEmpty()) {
            return new ArrayList<>();
        }
        List<OrderDTO> orderDTOS = orderMapper.listOrderEntityToListOrderDto(orderEntities);
        return orderDTOS;
    }

    private void existo(Long id) {
        Boolean existo = orderRepository.findById(id).isPresent();
        if (existo) {
            throw new ExcepcionDuplicidad("La orden #" + id + " ya esxiste");
        }
    }

    private void noExisto(Long id) {
        Boolean existo = orderRepository.findById(id).isPresent();
        if (!existo) {
            throw new ExcepcionDuplicidad("La orden #" + id + " no esxiste");
        }
    }
}
