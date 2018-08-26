package com.snow;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PrintTreeByLayer {

    private Entry root;

    public static void main(String[] args) {
        PrintTreeByLayer printTree = new PrintTreeByLayer();
        printTree.init();
        Queue<Entry> queue = new ConcurrentLinkedQueue<>();
        queue.offer(printTree.root);
        printTree.printByLayer(queue);
        System.out.println();
    }

    public void printByLayer(Queue<Entry> queue) {
        Entry entry = queue.poll();
        if (entry == null) {
            return;
        }
        System.out.print(entry.value + ",");
        if (entry.left != null) {
            queue.offer(entry.left);
        }
        if (entry.right != null) {
            queue.offer(entry.right);
        }
        printByLayer(queue);
    }

    private void init() {
        this.root = new Entry(2);
        this.root.left = new Entry(8);
        this.root.right = new Entry(9);
        this.root.left.right = new Entry(5);
        this.root.right.left = new Entry(3);
        this.root.right.right = new Entry(7);
    }

}

class Entry {
    Entry left;
    Entry right;
    int value;

    public Entry(int value) {
        this.value = value;
    }

    public Entry(Entry left, Entry right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
