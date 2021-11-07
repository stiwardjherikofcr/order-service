package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long customerId;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private double totalPrice;

    @NotNull()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentmethod_id")
    private PaymentMethodEntity paymentMethod;

    private boolean status;

    private String productIds;

}
