package ru.nedorezova.threadProblems;

public class PingPong {

    private static final Object lock = new Object();
    private static boolean isPingTurn = true;
    
    public static void main(String[] args) {
        Thread pingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        while (!isPingTurn) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println("Ping");
                        isPingTurn = false;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread pongThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        while (isPingTurn) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println("Pong");
                        isPingTurn = true;
                        lock.notifyAll();
                    }
                }
            }
        });

        pingThread.start();
        pongThread.start();

        try {
            pingThread.join();
            pongThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
