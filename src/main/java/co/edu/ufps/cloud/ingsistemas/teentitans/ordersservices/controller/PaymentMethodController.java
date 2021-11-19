package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.controller;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.dto.PaymentMethodDto;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping()
    public List<PaymentMethodDto> listAll() {
        return paymentMethodService.listAll();
    }

    @PostMapping()
    public  Long save(@RequestBody PaymentMethodDto paymentMethodDto) {
        return paymentMethodService.save(paymentMethodDto);
    }

    @DeleteMapping()
    public void delete(@RequestParam Long id) {
        paymentMethodService.delete(id);
    }
}
