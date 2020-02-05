package codingninjas.lecture1.oops1.classesandobjects;

public class DynamicArray {
    private int[] array;
    private int nextIndex;

    public DynamicArray() {
        this.array = new int[5];
        this.nextIndex = 0;
    }

    public void add(int num) {
        if (nextIndex == array.length) {
            refractor();
        }
        array[nextIndex] = num;
        nextIndex++;
    }

    private void refractor() {
        int[] temp = array;
        array = new int[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }

    public int size() {
        return nextIndex;
    }

    public int get(int index) {
        if (index < nextIndex)
            return array[index];
        else return -1;
    }

    public void set(int index, int elem) {
        if (index < nextIndex) {
            array[index] = elem;
        } else if (index > nextIndex) {
            return;
        } else
            add(elem);
    }

    public boolean isEmpty() {
        if (size() == 0)
            return true;
        else return false;
    }

    public int removeLast() {
        if (size() == 0)
            return -1;
        int value = array[nextIndex - 1];
        array[nextIndex-1] = 0;
        nextIndex--;
        return value;
    }
}
