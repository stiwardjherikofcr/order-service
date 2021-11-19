package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.convertidores;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.PaymentMethodDto;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.PaymentMethodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethodMapper INSTANCIA = Mappers.getMapper(PaymentMethodMapper.class);

    PaymentMethodDto entityToDto (PaymentMethodEntity entity);

    PaymentMethodEntity dtoToEntity (PaymentMethodDto paymentMethodDto);

    List<PaymentMethodDto> entityToDto (List<PaymentMethodEntity> entity);

    List<PaymentMethodEntity> dtoToEntity (List<PaymentMethodDto> paymentMethodDto);

}
