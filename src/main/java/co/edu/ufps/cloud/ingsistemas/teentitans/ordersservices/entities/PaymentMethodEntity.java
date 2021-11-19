package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment_methods")
@Data
public class PaymentMethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
