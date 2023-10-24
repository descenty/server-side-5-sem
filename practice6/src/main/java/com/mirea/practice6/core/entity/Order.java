package com.mirea.practice6.core.entity;

import java.util.List;
import java.util.UUID;

public class Order extends Entity<UUID> {
    protected UUID userId;

    protected List<OrderProduct> products;
}
