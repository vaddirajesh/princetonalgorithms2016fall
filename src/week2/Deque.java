package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rajesh.vaddi on 9/15/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;

    private Node<Item> last;

    private int size;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }

    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        checkForNullItem(item);
        if (first == null) {
            Node<Item> firstNode = new Node<>();
            firstNode.item = item;
            first = firstNode;
            last = firstNode;
        } else {
            Node<Item> oldFirst = first;
            Node<Item> newFirst = new Node<>();
            newFirst.item = item;
            newFirst.next = oldFirst;
            newFirst.previous = null;
            oldFirst.previous = newFirst;
            first = newFirst;
        }
        size++;
    }

    public void addLast(Item item) {
        checkForNullItem(item);
        if (last == null) {
            Node<Item> lastNode = new Node<>();
            lastNode.item = item;
            last = lastNode;
            first = lastNode;
        } else {
            Node<Item> oldLast = last;
            Node<Item> newLast = new Node<>();
            newLast.item = item;
            newLast.previous = oldLast;
            newLast.next = null;
            oldLast.next = newLast;
            last = newLast;
        }
        size++;
    }

    public Item removeFirst() {
        checkForNullRemoval();
        Item item = first.item;
        first.item = null;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        checkForNullRemoval();
        Item item = last.item;
        last.item = null;
        if (last.previous == null) {
            last = null;
            first = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return item;
    }

    private void checkForNullRemoval() {
        if (first == null || last == null)
            throw new NoSuchElementException();
    }

    private void checkForNullItem(Item item) {
        if (item == null)
            throw new NullPointerException();
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

        Deque<String> deque = new Deque<>();

        System.out.println("week2.Deque Size: " + deque.size());

        deque.addFirst("move");
        deque.addFirst("cautious");
        deque.addFirst("used");
        deque.addFirst("hope");
        deque.addFirst("scarf");
        deque.removeLast();
        deque.removeFirst();
        deque.removeFirst();
        System.out.println("size: " + deque.size());
        deque.removeLast();
        deque.removeLast();
        deque.addFirst("move");
        deque.addLast("cautious");
        deque.addFirst("used");
        deque.addLast("hope");
        System.out.println("week2.Deque Size: " + deque.size());
    }

}

