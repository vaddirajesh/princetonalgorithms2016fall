package week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * Created by rajesh.vaddi on 9/17/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;
    private int current;

    public RandomizedQueue() {
        items = null;
        size = 0;
        current = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(Item item) {
        if (items == null) {
            Item[] newItems = (Item[]) new Object[1];
            newItems[current++] = item;
            size++;
            items = newItems;
        } else {
            if (size == items.length) {
                resize(items.length * 2);
            }
            items[current++] = item;
            ++size;
        }
    }

    public Item dequeue() {
        if (size <= (items.length / 4)) {
            resize(items.length / 2);
        }
        int nonNullIndex = getNonNullIndex();
        Item item = items[nonNullIndex];
        items[nonNullIndex] = null;
        size--;
        return item;
    }

    public Item sample() {
        return items[getNonNullIndex()];
    }

    private int getNonNullIndex() {
        int index = StdRandom.uniform(items.length - 1);
        while (items[index] == null) {
            index = StdRandom.uniform(items.length - 1);
        }
        return index;
    }

    private void resize(int newSize) {
        Item[] oldItem = items;
        Item[] newItems = (Item[]) new Object[newSize];

        for (int i = 0, j = 0; i < oldItem.length; i++) {
            if (oldItem[i] != null) {
                newItems[j] = oldItem[i];
                j++;
            }
        }
        items = newItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int currentIndex = 0;
        private int currentNumberOfItems = size;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return currentNumberOfItems != 0;
        }

        @Override
        public Item next() {
            while (items[currentIndex] == null && currentIndex < items.length) {
                currentIndex++;
            }
            currentNumberOfItems--;
            return items[currentIndex++];
        }
    }

    public static void main(String[] args) {

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        randomizedQueue.enqueue("move");
        randomizedQueue.enqueue("cautious");
        randomizedQueue.enqueue("used");
        randomizedQueue.enqueue("hope");
        randomizedQueue.enqueue("scarf");
        randomizedQueue.enqueue("rhyme");
        randomizedQueue.enqueue("milky");
        randomizedQueue.enqueue("cows");
        randomizedQueue.enqueue("lively");
        randomizedQueue.enqueue("plant");

        System.out.println("Number of Items: " + randomizedQueue.size);
        System.out.println(randomizedQueue.toString());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println("Number of Items: " + randomizedQueue.size);
    }
}
