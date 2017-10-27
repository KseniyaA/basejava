import java.util.Arrays;

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

    /**
     * Получение индекса резюме в массиве
     * @param uuid идентификатор резюме
     * @return -1 - если резюме не найдено в массиве, >= 0 - индекс резюме в массиве storage
     */
    private int getIndexInStorageByUuid(String uuid) {
        for(int i = 0; i < factNumber; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void update (Resume r) {
        int indexInStorageByUuid = getIndexInStorageByUuid(r.uuid);
        if (indexInStorageByUuid == -1) {
            System.out.println(String.format("Резюме с id = [%s] не найдено в массивею. Обновление невозможно.", r.uuid));
            return;
        }
        storage[indexInStorageByUuid] = r;
    }

    void save(Resume r) {
        int indexInStorageByUuid = getIndexInStorageByUuid(r.uuid);
        if (indexInStorageByUuid > -1) {
            System.out.println(String.format("Резюме с id = [%s] уже сохранено в базе. Сохранение не возможно.", r.uuid));
            return;
        }
        if (factNumber == 10000) {
            System.out.println("Невозможно добавить элемент, т.к. массив заполнен.");
            return;
        }
        storage[factNumber] = r;
        factNumber++;
    }

    Resume get(String uuid) {
        int indexInStorageByUuid = getIndexInStorageByUuid(uuid);
        if (indexInStorageByUuid == -1) {
            return null;
        }
        return storage[indexInStorageByUuid];
    }

    void delete(String uuid) {
        int indexInStorageByUuid = getIndexInStorageByUuid(uuid);
        if (indexInStorageByUuid == -1) {
            System.out.println(String.format("Резюме с id = [%s] не хранится в storage.", uuid));
            return;
        }
        storage[indexInStorageByUuid] = storage[factNumber-1];
        storage[factNumber-1] = null;
        factNumber--;
        // не нужно сохранять порядок элементов, поэтому закоментировала стркоу с сортировкой
        // Arrays.sort(storage, Comparator.<Resume>nullsLast(Comparator.naturalOrder()));
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
