package com.epam.task.taxiPark.exception;
//ошибка выводится при попытке удаления списка автомобилей, удовлетворяющих заданым параметрам, если в этот список попали все автомобили парка
public class DeleteAllParkException extends RuntimeException {

    public DeleteAllParkException() {
    }

    public DeleteAllParkException(String message) {
        super(message);
    }

    public DeleteAllParkException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteAllParkException(Throwable cause) {
        super(cause);
    }

    public DeleteAllParkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
