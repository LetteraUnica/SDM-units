package collection.stack;

import collection.Collection;
import collection.exceptions.FullCollectionException;

public interface Stack extends Collection {
    void push(Object object) throws FullCollectionException;
    Object pop();
    Object top();
}
