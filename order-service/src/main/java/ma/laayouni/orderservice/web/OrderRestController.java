package ma.laayouni.orderservice.web;

import lombok.AllArgsConstructor;
import ma.laayouni.orderservice.Entity.Order;
import ma.laayouni.orderservice.model.Customer;
import ma.laayouni.orderservice.model.Product;
import ma.laayouni.orderservice.repo.OrderRepository;
import ma.laayouni.orderservice.repo.ProductItemRepository;
import ma.laayouni.orderservice.services.CustomerRestClientService;
import ma.laayouni.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
