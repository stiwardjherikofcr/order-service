package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.repository;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
