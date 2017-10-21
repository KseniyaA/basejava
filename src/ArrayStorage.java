import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int factNumber = 0;

    void clear() {
        factNumber = 0;
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                return;
            }
        }
    }

    void save(Resume r) {
        factNumber++;
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
        factNumber--;
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
        return Arrays.copyOfRange(storage, 0, factNumber);
    }

    int size() {
        return factNumber;
    }
}
