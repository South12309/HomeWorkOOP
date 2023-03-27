package javacore.pingpong;

public class PingPong {
    private static Object lock = new Object();
    private static boolean isPing = true;
    public static void main(String[] args) {
        Thread ping = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isPing) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(PingPongEnum.pong);
                    isPing = false;
                    lock.notifyAll();
                }
            }
        });
        Thread pong = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isPing) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(PingPongEnum.ping);
                    isPing = true;
                    lock.notifyAll();
                }
            }
        });
        ping.start();
        pong.start();
    }
}

