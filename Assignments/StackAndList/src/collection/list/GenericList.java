package collection.list;

import collection.exceptions.FullCollectionException;
import collection.GenericCollection;
import collection.exceptions.ObjectNotFoundException;

public class GenericList extends GenericCollection implements List {
    GenericList(int max_size) {
        super(max_size);
    }

    @Override
    public Object get(int index) {
        if (index >= current_size) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    private void shiftRight(int index) {
        for (int i = current_size-1; i > index; i--) {
            values[i+1] = values[i];
        }
    }

    @Override
    public void insertAt(int index, Object object) throws FullCollectionException {
        if (current_size == getSize()) {
            throw new FullCollectionException("The stack is full");
        }
        current_size++;
        shiftRight(index);
        values[index] = object;
    }
    
    private void shiftLeft(int index) {
        for (int i = index; i < current_size-1; i++){
            values[i] = values[i+1];
        }
    }
    
    @Override
    public void remove(int index) {
        if (index >= current_size) {
            throw new IndexOutOfBoundsException();
        }
        shiftLeft(index);
        current_size--;
    }
    
    @Override
    public int indexOf(Object object) throws ObjectNotFoundException {
        for(int i = 0; i < current_size; i++) {
            if (values[i].equals(object)) {
                return i;
            }
        }
        throw new ObjectNotFoundException("Object " + object.toString() + " not in the list");
    }
}
