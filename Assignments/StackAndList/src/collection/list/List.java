package collection.list;

import collection.Collection;
import collection.exceptions.FullCollectionException;
import collection.exceptions.ObjectNotFoundException;

public interface List extends Collection {
    void add(Object object) throws FullCollectionException;
    Object get(int index);
    void insertAt(int index, Object object) throws FullCollectionException;
    void remove(int index);
    int indexOf(Object object) throws ObjectNotFoundException;
}
