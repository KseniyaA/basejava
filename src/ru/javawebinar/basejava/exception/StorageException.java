package ru.javawebinar.basejava.exception;

/**
 * Created by Ksu on 31.01.2018.
 */
public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
