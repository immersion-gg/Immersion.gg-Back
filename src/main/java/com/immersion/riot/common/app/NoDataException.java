package com.immersion.riot.common.app;

public class NoDataException extends RuntimeException {
    public NoDataException() {
        super();
    }

    public NoDataException(String message) {
        super(message);
    }
}
