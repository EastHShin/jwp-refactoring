package kitchenpos.application.order;

import java.util.List;

public class OrderRequest {

    private Long orderTableId;
    private List<OrderLineItemRequest> orderLineItems;

    private OrderRequest() {
    }

    OrderRequest(Long orderTableId, List<OrderLineItemRequest> orderLineItems) {
        this.orderTableId = orderTableId;
        this.orderLineItems = orderLineItems;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public List<OrderLineItemRequest> getOrderLineItems() {
        return orderLineItems;
    }
}