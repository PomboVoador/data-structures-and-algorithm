package com.changxu.list;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {


    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    private AnyType[] theItems;


    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimSize() {
        ensureCapacity(size());
    }

    public AnyType get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        return theItems[index];
    }

    public AnyType set(int index, AnyType newValue) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        AnyType old = theItems[index];
        theItems[index] = newValue;
        return old;
    }


    public void add(AnyType value) {
        add(size(), value);
    }

    private void add(int index, AnyType value) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i + 1] = theItems[i];
        }
        theItems[index] = value;

        theSize ++;
    }


    public AnyType remove(int index) {
        AnyType removedItem = theItems[index];
        for (int i = index; i < theSize; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize --;
        return removedItem;
    }














    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new IllegalArgumentException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(-- current);
        }
    }
}
