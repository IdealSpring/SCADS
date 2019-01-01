package cn.ccut.learnrecond.day_05;

class Passenger extends Thread {
    private int seats;

    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
}

class Web12306 implements Runnable {
    private int available;

    public Web12306(int available) {
        this.available = available;
    }

    @Override
    public void run() {
        Passenger passenger = (Passenger) Thread.currentThread();
        boolean flag = bookTickets(passenger.getSeats());

        if (flag) {
            System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为:" + passenger.getSeats());
        } else {
            System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
        }
    }

    public synchronized boolean bookTickets(int seats) {
        System.out.println("可用位置为:" + available);
        if (available - seats >= 0) {
            available -= seats;
            return true;
        }

        return false;
    }


}

public class Web12306Demo {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306(10);
        new Passenger(web12306, "小明", 5).start();
        new Passenger(web12306, "小1", 1).start();
    }
}
