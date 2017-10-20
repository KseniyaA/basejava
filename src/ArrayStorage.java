import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.sort(storage, Comparator.<Resume>nullsLast(Comparator.naturalOrder()));
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                return;
            }
        }
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
        System.out.println("Невозможно добавить элемент, т.к. массив заполнен.");
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
                break;
            }
        }
        Arrays.sort(storage, Comparator.<Resume>nullsLast(Comparator.naturalOrder()));
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Arrays.sort(storage, Comparator.<Resume>nullsLast(Comparator.naturalOrder()));
        int indexFrom = 0;
        int indexTo = 0;
        for(int i = 0; i < storage.length; i++) {
            indexTo = i;
            if (storage[i] == null) {
                break;
            }
        }
        return Arrays.copyOfRange(storage, indexFrom, indexTo);
    }

    int size() {
        return getAll().length;
    }
}
