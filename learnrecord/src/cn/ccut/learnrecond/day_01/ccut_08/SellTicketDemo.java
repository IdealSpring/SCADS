package cn.ccut.learnrecond.day_01.ccut_08;

public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket sellTicket  = new SellTicket();

        Thread t1 = new Thread(sellTicket, "窗口1");
        Thread t2 = new Thread(sellTicket, "窗口2");
        Thread t3 = new Thread(sellTicket, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
