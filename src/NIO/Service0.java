package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Service0 {
    public static void main(String[] args) {
        try {
            //创建ServerSocketChannel通道，绑定监听端口为8585
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(8585));
            //设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //开始监听
            System.out.println("开始监听");
            while(true){
                Thread.sleep(10000);
                SocketChannel socketChannel= serverSocketChannel.accept();
                System.out.println("accept"+socketChannel);
                if(socketChannel != null){
                    System.out.println("接收到请求。。。");
                    //设置为非阻塞
                    socketChannel.configureBlocking(false);
                    ByteBuffer dst = ByteBuffer.allocate(1024);
                    socketChannel.read(dst);
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
