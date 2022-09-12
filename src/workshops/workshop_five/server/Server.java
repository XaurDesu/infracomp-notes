package workshops.workshop_five.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 3400;

    public static void main(String args[]) throws IOException {
        ServerSocket ss = null;
        boolean keepGoing = true;

        System.out.println("--Main Server--");
        try {
            ss = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while (keepGoing) {
            Socket socket = ss.accept();
            try {
                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
