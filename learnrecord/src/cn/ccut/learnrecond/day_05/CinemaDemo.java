package cn.ccut.learnrecond.day_05;

import java.util.ArrayList;

class CCUTCinema {
    private ArrayList<Integer> available;
    private String name;

    public CCUTCinema(ArrayList<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets(ArrayList<Integer> seats) {
        System.out.print(String.format("%s影院可用位置：", name) + available);
        ArrayList<Integer> copy = new ArrayList<>(available);
        copy.removeAll(seats);

        if (available.size() - copy.size() != seats.size())
            return false;

        available = copy;
        return true;
    }
}

class CCUTStudent implements Runnable {
    private CCUTCinema cinema;
    private ArrayList<Integer> seats;

    public CCUTStudent(CCUTCinema cinema, ArrayList<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean bookTickets = cinema.bookTickets(seats);

            if (bookTickets)
                System.out.println(" " + Thread.currentThread().getName() + " 出票成功 ->" + seats);
            else
                System.out.println(" " + Thread.currentThread().getName() + " 出票失败 ->" + seats);
        }
    }
}

public class CinemaDemo {
    public static void main(String[] args) {
        ArrayList<Integer> availableSeats = new ArrayList<>();
        availableSeats.add(1);
        availableSeats.add(2);
        availableSeats.add(3);
        availableSeats.add(4);
        availableSeats.add(5);
        availableSeats.add(6);

        ArrayList<Integer> student1 = new ArrayList<>();
        student1.add(1);
        student1.add(2);
        student1.add(3);

        ArrayList<Integer> student2 = new ArrayList<>();
        student2.add(4);
        student2.add(5);
        student2.add(7);

        CCUTCinema cinema = new CCUTCinema(availableSeats, "CCUT");
        new Thread(new CCUTStudent(cinema, student1), "云不求").start();
        new Thread(new CCUTStudent(cinema, student2), "你猜猜").start();
    }
}
