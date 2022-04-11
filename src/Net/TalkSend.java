package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 */
public class TalkSend implements Runnable{
    private DatagramSocket client;
    private BufferedReader bufferedReader;
    private String toIP;
    private int toPort;

    public TalkSend(int port,String toIP,int toPort) throws SocketException {
        this.toIP = toIP;
        this.toPort = toPort;
        client = new DatagramSocket(port);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true){
            String data = null;
            try {
                data = bufferedReader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(this.toIP, this.toPort));
                client.send(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        client.close();
    }
}
