package codingninjas.lecture1.oops1.classesandobjects;

public class Polynomial {
    private int[] array;
    private int nextIndex;

    public Polynomial() {
        this.array = new int[5];
        this.nextIndex = 0;
    }

    public void insert(int index, int num) {
        if (index >= array.length) {
            refractor();
        }
        array[index] = num;
        nextIndex = index + 1;
    }

    private void refractor() {
        int[] temp = array;
        array = new int[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }

    public void setCoefficient(int index, int elem) {
        if (index < array.length) {
            array[index] = elem;
        } else if (index > nextIndex) {
            insert(index, elem);
        } else
            insert(index, elem);
    }

    public void print() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < array.length; i++) {
            if (i < array.length - 1 && array[i] != 0)
                sb.append(array[i]).append("x").append(i).append(" ");
            else if (array[i] != 0)
                sb.append(array[i]).append("x").append(i);
        }
        System.out.println(sb);
    }

    public Polynomial add(Polynomial p2) {
        if (this.array.length > p2.array.length) {
            for (int i = 1; i < p2.array.length; i++) {
                this.array[i] = this.array[i] + p2.array[i];
            }
        } else if (this.array.length < p2.array.length) {
            int lIndex = 0;
            for (int i = 1; i < this.array.length; i++) {
                lIndex = i;
                this.array[i] = this.array[i] + p2.array[i];
            }
            while (lIndex++ < p2.array.length) {
                insert(lIndex, p2.array[nextIndex]);
            }
        } else {
            for (int i = 1; i < this.array.length; i++) {
                this.array[i] = this.array[i] + p2.array[i];
            }
        }
        return this;
    }

    public Polynomial subtract(Polynomial p2) {
        if (this.array.length > p2.array.length) {
            for (int i = 1; i < p2.array.length; i++) {
                this.array[i] = this.array[i] - p2.array[i];
            }
        } else if (this.array.length < p2.array.length) {
            int lIndex = 0;
            for (int i = 1; i < this.array.length; i++) {
                lIndex = i;
                this.array[i] = this.array[i] - p2.array[i];
            }
            while (lIndex++ < p2.array.length) {
                insert(lIndex, p2.array[nextIndex]);
            }
        } else {
            for (int i = 1; i < this.array.length; i++) {
                this.array[i] = this.array[i] - p2.array[i];
            }
        }
        return this;
    }

    public Polynomial multiply(Polynomial p2) {
        int [] temp = this.array;
        this.array = new int[this.array.length + p2.array.length - 1];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < p2.array.length; j++) {
                this.array[i+j] += temp[i] * p2.array[j];
            }
        }
        return this;
    }

    public void printArray() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int size() {
        return nextIndex;
    }
}