package kitchenpos.table.application;

import kitchenpos.table.domain.OrderTable;

public class OrderTableResponse {

    private Long id;
    private Long tableGroupId;
    private int numberOfGuests;
    private boolean empty;

    public OrderTableResponse(Long id, Long tableGroupId, int numberOfGuests, boolean empty) {
        this.id = id;
        this.tableGroupId = tableGroupId;
        this.numberOfGuests = numberOfGuests;
        this.empty = empty;
    }

    public static OrderTableResponse createWithoutTableGroup(OrderTable orderTable) {
        return new OrderTableResponse(orderTable.getId(), null, orderTable.getNumberOfGuests(), orderTable.isEmpty());
    }

    public static OrderTableResponse from(OrderTable orderTable) {
        if (orderTable.existsTableGroup()) {
            return new OrderTableResponse(orderTable.getId(), orderTable.getTableGroup().getId(),
                    orderTable.getNumberOfGuests(),
                    orderTable.isEmpty());
        }

        return createWithoutTableGroup(orderTable);
    }

    public Long getId() {
        return id;
    }

    public Long getTableGroupId() {
        return tableGroupId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isEmpty() {
        return empty;
    }
}
