package kitchenpos.order.ui;

import java.net.URI;
import java.util.List;
import kitchenpos.order.application.ChangeOrderStatusRequest;
import kitchenpos.order.application.ChangeOrderStatusResponse;
import kitchenpos.order.application.OrderRequest;
import kitchenpos.order.application.OrderResponse;
import kitchenpos.order.application.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private final OrderService orderService;

    public OrderRestController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/orders")
    public ResponseEntity<OrderResponse> create(@RequestBody final OrderRequest orderRequest) {
        final OrderResponse orderResponse = orderService.create(orderRequest);
        final URI uri = URI.create("/api/orders/" + orderResponse.getId());
        return ResponseEntity.created(uri)
                .body(orderResponse)
                ;
    }

    @GetMapping("/api/orders")
    public ResponseEntity<List<OrderResponse>> list() {
        return ResponseEntity.ok()
                .body(orderService.list())
                ;
    }

    @PutMapping("/api/orders/{orderId}/order-status")
    public ResponseEntity<ChangeOrderStatusResponse> changeOrderStatus(
            @PathVariable final Long orderId,
            @RequestBody final ChangeOrderStatusRequest changeOrderStatusRequest
    ) {
        return ResponseEntity.ok(orderService.changeOrderStatus(orderId, changeOrderStatusRequest));
    }
}
