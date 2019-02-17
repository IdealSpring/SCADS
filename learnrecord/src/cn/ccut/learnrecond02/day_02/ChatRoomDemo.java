package cn.ccut.learnrecond02.day_02;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatRoomDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        DatagramSocket serverSocket = new DatagramSocket(12345);

        ClientThread clientThread = new ClientThread(clientSocket);
        ServerThread serverThread = new ServerThread(serverSocket);

        new Thread(serverThread).start();
        new Thread(clientThread).start();
    }
}
