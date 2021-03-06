import java.io.*;
import java.net.*;

public class EchoServer {
    private static final int PORT = 34522;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accepting a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF(); // reading a message
                    output.writeUTF(msg); // resend it to the client
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}