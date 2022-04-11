package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public static void main(String[] args) {
        List<SocketChannel> socketChannels = new ArrayList<SocketChannel>();
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(8585));
            while (true){
                //设置为非阻塞模式
                serverSocketChannel.configureBlocking(false);
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    System.out.println("接收到请求。。。");
                    //设置为非阻塞
                    socketChannel.configureBlocking(false);
                   socketChannels.add(socketChannel);
                   System.out.println(socketChannels.size());
                }
                for(int x = 0;x<socketChannels.size();x++){
                    SocketChannel sc= socketChannels.get(x);
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    try{
                        int read = sc.read(buffer);
                        if(read>0){
                            buffer.flip();
                            String str = new String(buffer.array(),0,buffer.limit());
                            System.out.println(str);
                        }
                    }catch (IOException e){
                        System.out.println("关闭了一个连接");
                        socketChannels.remove(sc);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
