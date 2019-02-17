package cn.ccut.learnrecond02.day_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientThread implements Runnable {
    private DatagramSocket clientSocket;

    public ClientThread(DatagramSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        DatagramPacket datagramPacket;
        try {
            while ((line = reader.readLine()) != null && !"666".equals(line)) {
                byte[] lineBytes = line.getBytes();
                datagramPacket = new DatagramPacket(lineBytes,
                        lineBytes.length, InetAddress.getByName("192.168.1.173"), 12345);

                clientSocket.send(datagramPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }

    }
}
