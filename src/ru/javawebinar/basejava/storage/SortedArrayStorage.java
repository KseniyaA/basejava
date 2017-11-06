package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void saveInIndex(int index, Resume r) {
        int indexForInsert = -index - 1;
        // Копируем часть элементов массива, от индекса indexForInsert, в этот же массив, начиная с indexForInsert + 1
        System.arraycopy(storage, indexForInsert, storage, indexForInsert + 1, size - indexForInsert);
        storage[indexForInsert] = r;
    }

    @Override
    protected void deleteInIndex(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
