package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
            Arrays.sort(storage);
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println(String.format("Resume with uid = [%s] already exist", r.getUuid()));
            return;
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        }
        int indexForInsert = -index - 1;
        // Копируем часть элементов массива, от индекса indexForInsert, в этот же массив, начиная с indexForInsert + 1
        System.arraycopy(storage, indexForInsert, storage, indexForInsert + 1, size - indexForInsert);
        storage[indexForInsert] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println(String.format("Resume with uid = [%s] does not exist", uuid));
            return;
        }
        System.arraycopy(storage, index+1, storage, index , size - index);
        storage[size] = null;
        size--;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
