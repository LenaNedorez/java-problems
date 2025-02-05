package ru.nedorezova.threadProblems;

public class threadProblem1 {


    public static class Counter{
        int count = 0;

        public synchronized void add(long value){
            this.count += value;
        }
    }

    public static class CounterThread extends Thread{
        protected  Counter counter = null;

        public CounterThread(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run(){
            for(int i = 0; i < 100_000; i++){
                counter.add(1L);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println(counter.count);
    }
}
