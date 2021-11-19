package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.repository;

import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value = "select * from orders where customer = :customer", nativeQuery = true)
    List<OrderEntity> findAllByCustomer(@Param("customer") Long customer);
}
