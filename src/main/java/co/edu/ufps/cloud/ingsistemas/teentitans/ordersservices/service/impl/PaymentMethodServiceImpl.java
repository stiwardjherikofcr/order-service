package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service.impl;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.convertidores.PaymentMethodMapper;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.PaymentMethodDto;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.PaymentMethodEntity;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionDuplicidad;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.repository.PaymentMethodRepository;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethodDto> listAll() {
        List<PaymentMethodEntity> paymentMethodEntities = paymentMethodRepository.findAll();
        return paymentMethodMapper.entityToDto(paymentMethodEntities);
    }

    @Override
    public Long save(PaymentMethodDto paymentMethodDto) {
        PaymentMethodEntity paymentMethodEntity = paymentMethodRepository.findById(paymentMethodDto.getId()).orElse(null);
        if (Objects.nonNull(paymentMethodEntity)) {
            throw new ExcepcionDuplicidad("Metodo de pago " + paymentMethodDto.getName() + " ya existe");
        }
        paymentMethodEntity = paymentMethodMapper.dtoToEntity(paymentMethodDto);
        paymentMethodEntity = paymentMethodRepository.save(paymentMethodEntity);
        return paymentMethodEntity.getId();
    }

    @Override
    public void delete(Long id) {
        boolean paymentMethodEntity = paymentMethodRepository.findById(id).isPresent();
        if (!paymentMethodEntity) {
            throw new ExcepcionDuplicidad("Metodo de pago " + id + " no existe");
        }
        paymentMethodRepository.deleteById(id);
    }
}
