public class ArrayDeque<Item> {


    private Item[] items;
    private int nextFirst, nextLast, capacity, size;
    private double usagefactor;

    public ArrayDeque() {
        size = 0;
        items = (Item []) new Object[2];
        capacity = items.length;
        nextFirst = 0;
        nextLast = 1;
        usagefactor = size/capacity;
    }


    private int minusOne(int index) {
        if (index == 0) {
            return capacity - 1;
        }
        return index - 1;
    }

    private int plusOne(int index) {
        if (index == capacity - 1) {
            return 0;
        }
        return index + 1;
    }

    private void resize(int multiplier) {
        Item[] newArray = (Item[]) new Object[multiplier];
        int firstIndex = plusOne(nextFirst); //1
        System.arraycopy(items, firstIndex, newArray, 0, capacity - firstIndex);
        System.arraycopy(items, 0, newArray, capacity - firstIndex, firstIndex);
        items = newArray;
        capacity = items.length;
        nextFirst = capacity - 1;
        nextLast = size;

    }

    public void resizeDown(int oneLess) {
        Item[] newArrayz = (Item[]) new Object[oneLess];
        int newlastItem = minusOne(minusOne(nextLast));
        System.arraycopy(items, newlastItem, newArrayz, 0, capacity - newlastItem);

        items = newArrayz;
        capacity = items.length;

    }

    public double getUsagefactor() {
        double sizedup = (double) size;
        return sizedup/capacity;
    }

    public void addFirst(Item i) {
        if (size < capacity) {
            items[nextFirst] = i;
            size++;
            nextFirst = minusOne(nextFirst);
            usagefactor = getUsagefactor();

        } else {
            resize(size * 10);
            items[nextFirst] = i;
            size++;
            nextFirst = (minusOne(nextFirst));
            usagefactor = getUsagefactor();
        }
    }


//        if (size == capacity) {
//            resize(capacity * 2);
//        }
//        items[nextFirst] = i;
//        size ++;
//        nextFirst = minusOne(nextFirst);
//    }

    public void addLast(Item i) {
        if (size >= capacity) {
            resize(capacity * 10);
            items[nextLast] = i;
            size++;
            nextLast = (plusOne(nextLast));
            usagefactor = getUsagefactor();
            System.out.print(" rsz " + usagefactor);
        } else {
            items[nextLast] = i;
            size++;
            nextLast = plusOne(nextLast);
            usagefactor = getUsagefactor();
            System.out.print(" b4 " + usagefactor);
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
//        while (plusOne(nextFirst) != nextLast) {
//            System.out.print(items[plusOne(nextFirst)]);
//            nextFirst = plusOne(nextFirst);
//        }
        for (int i = 0; i < size; i++) {
            System.out.print(items[plusOne(nextFirst)]);
            nextFirst = plusOne(nextFirst);
        }
    }

    public Item removeFirst() {
        if (items[plusOne(nextFirst)] == null) {
            return null; }
        if (usagefactor < .25) {
            resize(size/2);
        }
        Item temp = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size--;
        usagefactor = getUsagefactor();
        return temp;
    }

    public Item removeLast() {
        if (items[minusOne(nextLast)] == null) {
            return null; }
        if (usagefactor < .25) {
            resize(size/2);
            System.out.print("hello");
        }
        Item temp = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size--;
        usagefactor = getUsagefactor();
        return temp;

        }

    public Item get(int index) {
        if (items[(plusOne(nextFirst) + index) % capacity] == null) {
            return null;
        }
        return items[(plusOne(nextFirst) + index) % capacity];
    }

    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque();
        test.addLast(2);
        test.addLast(3);
        test.addLast(4);
        test.addLast(5);
        test.removeLast();

    }

}


/* nextfirst/nextlast can be integers or pointers, maybe have insert
to insert at where first and last are and decrement and increment numbers
accordingly. */
