public class LinkedListDeque<Bleep> {

    public int size; /*size of list */
    public OneNode sentinel;

    public class OneNode {
        public Bleep item;
        public OneNode prev = null;
        public OneNode next = null;

        public OneNode(Bleep item0, OneNode prev0, OneNode next0) {
            item = item0;
            prev = prev0;
            next = next0;
        }
    }

    public LinkedListDeque() {
        sentinel = OneNode(null, null, null);
        size = 0;
        sentinel.next = prev;
        sentinel.prev = next;
    }
//    public OneNode(null, front, back) {
//
//
//        public Bleep item;
//        public OneNode next = null;
//        public OneNode prev = null;
////        prev.next.item = item;
//    }
//
//
//    public LinkedListDeque() {
//        size = 0;
//        sentinel = new OneNode();
//        sentinel.next = prev;
//        sentinel.prev = next;
//    }

    public void addFirst(Item) {
        first = this.OneNode(); /* Is this the whole deque or one node? */
        first.item = Item;
        sentinel.next = first;
        first.prev = sentinel;
        size ++;
    }

    public void addLast(Item) {
        last = this.OneNode();
        last.item = Item;
        sentinel.prev = last;
        last.next = sentinel;
        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public Item removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        firstitem = sentinel.next.item; /* will the node you're removing go into the garbage
        or will it stay because of this pointer? */
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return firstitem;
    }

    public Item removeLast () {
        if (this.isEmpty()) {
            return null;
        }
        lastitem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return lastitem;
    }

    public Item get(int index) {

    }
}

/* point of sentinel node, is you disregard the special cases like tail == null, instead you can say while you're not on the sentinel,
 keep going through list and do what you want to do on each item, sentinel node that points to front and back */

/* gonna have a front and back sentinel that can keep track, when you go through items of list,
easy to move from front to back by having pointers */

/* sentinel nodes don't actually have items, use them to get to front and back to the list
*
*
* prev and next pointers are pointing to nodes and not prev and next*/

/* sentinel node, prev is back of list and next is front

deque is a way to arrange them and access them

nodes is what hold the data
 */