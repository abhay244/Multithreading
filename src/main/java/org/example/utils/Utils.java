package org.example.utils;

public class Utils {
    public Integer addFunction(Integer a){
        return a++;
    }
    public Integer subFunction(Integer a){
        return a--;
    }
    public static void main(String[] args) {
        SharedNumber shared = new SharedNumber();

        Thread addThread = new Thread(new AddTask(shared), "Adder");
        Thread subThread = new Thread(new SubtractTask(shared), "Subtractor");

        addThread.start();
        subThread.start();
    }
}

class SharedNumber {
    private int number = 0;

    public  synchronized void add(int value) {
        number += value;
        System.out.println(Thread.currentThread().getName() + " added " + value + ", current value: " + number);
    }

    public  synchronized void subtract(int value) {
        number -= value;
        System.out.println(Thread.currentThread().getName() + " subtracted " + value + ", current value: " + number);
    }
}

class AddTask implements Runnable {
    private final SharedNumber shared;

    public AddTask(SharedNumber shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shared.add(5);

        }
    }
}

class SubtractTask implements Runnable {
    private final SharedNumber shared;

    public SubtractTask(SharedNumber shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shared.subtract(5);

        }
    }
}



