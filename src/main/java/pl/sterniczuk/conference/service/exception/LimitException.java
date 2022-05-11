package pl.sterniczuk.conference.service.exception;

import lombok.Getter;

@Getter
public class LimitException extends Exception {
    public LimitException(String message) {
        super(message);
    }
}
