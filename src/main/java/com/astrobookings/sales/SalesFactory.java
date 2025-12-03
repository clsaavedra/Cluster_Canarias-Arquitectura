package com.astrobookings.sales;

import com.astrobookings.sales.domain.ports.BookingRepositoryPort;
import com.astrobookings.sales.infrastructure.BookingAdapterReposioryInMemory;

public class SalesFactory {
    private static BookingRepositoryPort bookinRepositoryInstance = new BookingAdapterReposioryInMemory();

    public static BookingRepositoryPort getBookingInstance() {
        return bookinRepositoryInstance;
    }
}
