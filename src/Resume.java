/**
 * com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable {

    // Unique identifier
    String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 0;
        } else {
            return 1;
        }
    }
}
