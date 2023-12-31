package unitins.util;

public class ArrayTins<T extends Comparable<T>> {

    private final int SIZE = 10;
    private T[] array = null;
    private int lastPosition = 0;

    public ArrayTins() {
        array = (T[]) new Comparable[SIZE];
    }

    public String toString() {
        String result = "[";

        for (int position = 0; position < lastPosition; position++) {
            if (position == (lastPosition - 1)) {
                result += array[position];
            } else {
                result += array[position] + ", ";
            }
        }

        result += "]";
        return result;
    }

    public boolean isEmpty() {
        return lastPosition == 0 ? true : false;
    }

    public int size() {
        return lastPosition;
    }

    public void add(int position, T newElement) {

        if (position < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (position > lastPosition) {
            throw new ArrayIndexOutOfBoundsException();
        }

        T previousValue = array[position];
        array[position] = newElement;

        if (position == lastPosition) {
            lastPosition++;
            if (lastPosition == array.length) {
                resize();
            }

            return;
        }

        add((++position), previousValue);
    }

    public T remove(int position) {
        if (position < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (position >= lastPosition) {
            throw new ArrayIndexOutOfBoundsException();
        }

        T oldElement = array[position];

        for (int i = position; i < size(); i++) {
            array[i] = array[i + 1];
        }

        lastPosition--;

        return oldElement;
    }

    public void add(T newElemet) {
        if (lastPosition == array.length) {
            resize();
        }

        array[lastPosition] = newElemet;
        lastPosition++;
    }

    public T get(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index >= lastPosition) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];
    }

    private void resize() {
        System.out.println("Mais memória...");
        T[] newArray = (T[]) new Object[array.length + (array.length / 2)];

        for (int position = 0; position < array.length; position++) {
            newArray[position] = array[position];
        }

        array = newArray;
        System.gc();
    }

    private int partition(int head, int tail) {
        T pivot = this.array[tail];

        for (int i = head; i < tail; i++) {
            if (this.get(i).compareTo(pivot) <= 0) {
                swap(head, i);
                head++;
            }
        }

        swap(head, tail);
        return head;
    }

    private void swap(int first, int second) {
        T aux = this.get(first);
        this.array[first] = this.array[second];
        this.array[second] = aux;
    }

    private void quicksort(int head, int tail) {
        if (head >= tail) {
            return;
        }

        int pivotIndex = partition(head, tail);

        quicksort(head, --pivotIndex);
        quicksort(++pivotIndex, tail);
    }

    public void sort() {
        if (size() <= 1) {
            return;
        }
        quicksort(0, (size() - 1));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayTins<?> other = (ArrayTins<?>) obj;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!array[i].equals(other.array[i])) {
                return false;
            }
        }
        return true;
    }

}