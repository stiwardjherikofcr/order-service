package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.repository;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity , Long> {
}
