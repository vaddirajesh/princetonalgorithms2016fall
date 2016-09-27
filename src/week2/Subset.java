package week2;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by rajesh.vaddi on 9/17/16.
 */
public class Subset {

    public static void main(String[] args) {
        int numberOfRandomStringsToPrint = Integer.valueOf(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < numberOfRandomStringsToPrint; i++) {
            System.out.println(randomizedQueue.dequeue());
        }
    }
}
