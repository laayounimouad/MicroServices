package ma.laayouni.orderservice.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.laayouni.orderservice.Enums.OrderStatus;
import ma.laayouni.orderservice.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient // means c'est pas la pein de metre en consideration ceci
    private Customer customer;
    @OneToMany(mappedBy = "order")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// to not have an infinite loop
    private List<ProductItem> productItems;

}
