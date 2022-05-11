package pl.sterniczuk.conference.api.exception;

import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorMessage {

    private final int statusCode;
    private final Date timestamp;
    private final String message;

    public ErrorMessage(int statusCode, Date timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }
}