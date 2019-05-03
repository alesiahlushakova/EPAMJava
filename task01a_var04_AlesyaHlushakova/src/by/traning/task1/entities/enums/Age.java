package by.traning.task1.entities.enums;

public enum Age {
    BABY(2), CHILD(10), TEENAGER(16);
    int limit;
    Age(int limit) {
       this.limit=limit;
    }

    /**
     *
     * @return age limit
     */
    public int getLimit() {
        return limit;
    }
}
