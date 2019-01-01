package cn.ccut.learnrecond.day_05;

class Cinema {
    private int ticketNum;
    private String name;

    public Cinema(int ticketNum, String name) {
        this.ticketNum = ticketNum;
        this.name = name;
    }

    public boolean isSaleTickets(int seats) {
        System.out.println("可用位置为:" + ticketNum);
        if (ticketNum - seats >= 0) {
            ticketNum -= seats;
            return true;
        }

        return false;
    }

    public int getTicketNum() {
        return ticketNum;
    }
}

class Customer implements Runnable {
    private Cinema cinema;
    private int seat;

    public Customer(Cinema cinema, int seat) {
        this.cinema = cinema;
        this.seat = seat;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean saleTickets = cinema.isSaleTickets(this.seat);
            if (saleTickets)
                System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为：" + seat);
            else
                System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不足");
        }
    }
}

public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(10, "Happy Cinema");
        new Thread(new Customer(cinema, 2), "小明").start();
        new Thread(new Customer(cinema, 10), "刘德华").start();
    }
}

