import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int factNumber = 0;

    void clear() {
        for(int i = 0; i < factNumber; i++) {
            storage[i] = null;
        }
        factNumber = 0;
    }

    void save(Resume r) {
        storage[factNumber] = r;
        factNumber++;
        if (factNumber == 10000) {
            System.out.println("Невозможно добавить элемент, т.к. массив заполнен.");
        }
    }

    Resume get(String uuid) {
        for(int i = 0; i < factNumber; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < factNumber; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                break;
            }
        }
        factNumber--;
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
