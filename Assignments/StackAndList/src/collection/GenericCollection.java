package collection;

import collection.exceptions.FullCollectionException;

public abstract class GenericCollection implements Collection {
    private int size;
    protected int current_size = 0;
    protected Object[] values;

    public GenericCollection(int size) {
        this.size = size;
        values = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return current_size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i<current_size; i++) {
            if (values[i].equals(object)) return true;
        }
        return false;
    }

    @Override
    public Object[] getValues() {
        return null;
    }

    public void add(Object object) throws FullCollectionException {
        if (current_size == size) {
            throw new FullCollectionException("The collection is full");
        }
        values[current_size] = object;
        current_size++;
    }
}
