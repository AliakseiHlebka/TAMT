package com.epam.task.taxiPark.exception;
//ошибка выводится при попытке добавления в парк автомобиля с расходом топлива выше заданного
public class TooBigConsumptionException extends RuntimeException {

    public TooBigConsumptionException() {
    }

    public TooBigConsumptionException(String message) {
        super(message);
    }

    public TooBigConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooBigConsumptionException(Throwable cause) {
        super(cause);
    }

    public TooBigConsumptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
