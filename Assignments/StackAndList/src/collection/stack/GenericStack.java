package collection.stack;

import collection.exceptions.FullCollectionException;
import collection.GenericCollection;

import java.util.EmptyStackException;

public class GenericStack extends GenericCollection implements Stack {
    public GenericStack(int max_size) {
        super(max_size);
    }

    @Override
    public void push(Object object) throws FullCollectionException {
        super.add(object);
    }

    @Override
    public Object pop() {
        if(current_size == 0) {
            throw new EmptyStackException();
        }

        Object object = top();
        current_size--;
        return object;
    }

    @Override
    public Object top() {
        return values[current_size-1];
    }
}
