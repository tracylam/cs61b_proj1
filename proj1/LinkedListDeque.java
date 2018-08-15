public class LinkedListDeque<Item> {

    private int size; /*size of list */
    private OneNode sentinel;

    private class OneNode {
        private Item item;
        private OneNode prev = null;
        private OneNode next = null;


        private OneNode(Item item0, OneNode prev0, OneNode next0) {
            item = item0;
            prev = prev0;
            next = next0;
        }
    }

    public LinkedListDeque() {
        sentinel = new OneNode(null, null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }


    public void addFirst(Item i) {
        OneNode newfirst = new OneNode(i, sentinel, sentinel.next);
        sentinel.next.prev = newfirst;
        sentinel.next = newfirst;
        size++;
    }

    public void addLast(Item i) {
        OneNode newlast = new OneNode(i, sentinel.prev, sentinel);
        sentinel.prev.next = newlast;
        sentinel.prev = newlast;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        OneNode n = sentinel.next;
        while (n != sentinel) {
            System.out.print(n.item + " ");
            n = n.next;
        }
    }

    public Item removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Item firstitem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return firstitem;
    }

    public Item removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        Item lastitem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return lastitem;
    }

    public Item get(int index) {

        if (this.size() < index) {
            return null;
        }
        OneNode counter = sentinel;
        while (index > -1) {
            counter = counter.next;
            index--;
        }
        return counter.item;
    }

    private Item helperrecur(OneNode placeholder, int index, int counter) {
        if (index == counter) {
            return placeholder.item; }
        else {
            return helperrecur(placeholder.next, index, counter + 1);
        }
    }

    public Item getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return helperrecur(sentinel.next, index, 0);
    }

}