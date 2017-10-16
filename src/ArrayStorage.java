import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = new Resume[0];
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
        Resume[] tempStorage;
        tempStorage = storage;
        storage = new Resume[storage.length + 1];
        storage[storage.length - 1] = r;
        for(int i = 0; i < tempStorage.length; i++) {
            storage[i] = tempStorage[i];
        }
    }

    Resume get(String uuid) {
        for(Resume resume: storage) {
            if (resume != null && uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[0];
        Resume[] tempStorage;
        for(Resume resume: storage) {
            if (resume != null) {
                tempStorage = newStorage;
                newStorage = new Resume[newStorage.length + 1];
                newStorage[newStorage.length-1] = resume;
                for(int i = 0; i < tempStorage.length; i++) {
                    newStorage[i] = tempStorage[i];
                }

            }
        }
        return newStorage;
    }

    int size() {
        return storage.length;
    }
}
