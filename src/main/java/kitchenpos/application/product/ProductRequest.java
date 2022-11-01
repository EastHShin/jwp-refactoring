package kitchenpos.application.product;

import java.math.BigDecimal;

public class ProductRequest {

    private String name;
    private BigDecimal price;

    private ProductRequest() {
    }

    ProductRequest(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
