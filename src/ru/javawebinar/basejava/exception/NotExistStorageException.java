package ru.javawebinar.basejava.exception;

/**
 * Created by Ksu on 31.01.2018.
 */
public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
