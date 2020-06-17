package com.runoob.a09exception;

class MyThreadsException {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        try {
            t.start();
            Thread.sleep(1000);
        } catch (Exception x) {
            System.out.println("Caught it" + x);
        }
        System.out.println("Exiting main");
    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println("Throwing in " + "MyThread");
//            throw new RuntimeException();
            try {
                throw new Exception("abcdefg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}