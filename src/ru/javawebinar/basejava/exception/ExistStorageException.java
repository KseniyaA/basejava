package ru.javawebinar.basejava.exception;

/**
 * Created by Ksu on 31.01.2018.
 */
public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
