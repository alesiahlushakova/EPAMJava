package by.traning.task1.util;
/**
 * @author AlesyaHlushakova
 * enum for age restrictions.
 */
public enum Age {
    BABY(2), CHILD(10), TEENAGER(16);
    private int limit;
    Age(final int limit) {
       this.limit = limit;
    }

    /**
     *
     * @return age limit
     */
    public int getLimit() {
        return limit;
    }
}
