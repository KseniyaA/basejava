package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public class AbstractArrayStorageTest {
    private AbstractArrayStorage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final String UUID_4 = "uuid4";

    @Before
    public void setUp() throws Exception {
        storage = new ArrayStorage();
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());

        Assert.assertEquals(null, storage.storage[0]);
        Assert.assertEquals(null, storage.storage[1]);
        Assert.assertEquals(null, storage.storage[2]);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResume() throws Exception {
        // создаем новое резюме, не помещая его в массив
        Resume resume = new Resume(UUID_4);
        storage.update(resume);
    }

    @Test
    public void updateExistResume() throws Exception {
        Resume resume = storage.storage[0];
        // todo реализовать
        storage.update(resume);
    }

    @Test
    public void getAll() throws Exception {


    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}
