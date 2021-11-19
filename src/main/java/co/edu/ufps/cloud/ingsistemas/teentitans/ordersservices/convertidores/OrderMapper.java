package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.convertidores;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.OrderDTO;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCIA = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderEntityToOrderDto(OrderEntity orderEntity);

    OrderEntity orderDtoToOrderEntoty(OrderDTO orderDTO);

    List<OrderDTO> listOrderEntityToListOrderDto(List<OrderEntity> orderEntity);

    List<OrderEntity> orderDtoToOrderEntoty(List<OrderDTO> orderDTO);
}
