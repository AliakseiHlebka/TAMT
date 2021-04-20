package com.epam.task.TAMT.taxiPark.exception;
//ошибка выводится при попытке удаления автомобиля по заданным параметрам, если в парке нет автомобиля, отвечающего таким параметрам
public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFoundException(Throwable cause) {
        super(cause);
    }

    public CarNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
