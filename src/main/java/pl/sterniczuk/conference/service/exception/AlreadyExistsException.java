package pl.sterniczuk.conference.service.exception;

import lombok.Getter;

@Getter
public class AlreadyExistsException extends Exception {

    public AlreadyExistsException(String message) {
        super(message);
    }
}