package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (isAvailableForSave(index, r.getUuid())) {
            saveInIndex(index, r);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (isAvailableForDelete(index, uuid)) {
            deleteInIndex(index);
        }
    }

    /**
     * Проверка на возможно вставлять элемент в массив
     * @return true - возможно вставлять, false - невозможно
     */
    public Boolean isAvailableForSave(int index, String uuid) {
        if (index >= 0) {
            System.out.println("Resume " + uuid + " already exist");
            return Boolean.FALSE;
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * Проверка на возможность удаления элемента  из массива
     * @param index
     * @param uuid
     * @return true - возможно удалить, false - невозможно
     */
    public Boolean isAvailableForDelete(int index, String uuid) {
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int getIndex(String uuid);
    protected abstract void saveInIndex(int index, Resume r);
    protected abstract void deleteInIndex(int index);
}
