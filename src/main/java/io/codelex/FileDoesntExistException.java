package io.codelex;

public class FileDoesntExistException extends Exception {
    FileDoesntExistException(String errorMessage) {
        super(errorMessage);
    }
}
