package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.PaymentMethodDto;

import java.util.List;

public interface PaymentMethodService {

    List<PaymentMethodDto> listAll();

    Long save(PaymentMethodDto paymentMethodDto);

    void delete(Long id);
}
