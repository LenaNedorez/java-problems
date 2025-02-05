package ru.nedorezova.threadProblems;

public class threadProblem2 {

    public static void main(String[] args) {
        Thread thread = new ThreadCustom("ThreadCustom");
        thread.start();
        thread.run();
        thread.run();
        thread.run();
        thread.run();
        thread.run();
    }
    public static class ThreadCustom extends Thread {
        public ThreadCustom(String name) {
            super(name);
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
