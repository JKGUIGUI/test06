package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Service01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8585));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            Thread.sleep(1000);
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                System.out.println("处理事件");
                System.out.println(selectionKeys.size());
                SelectionKey next = iterator.next();
                iterator.remove();
                if(next.isReadable()){
                    System.out.println("选择请求事件");
                    SocketChannel channel = (SocketChannel)next.channel();
                    ByteBuffer dest = ByteBuffer.allocate(1024);
                    int read = channel.read(dest);
                    System.out.println(new String(dest.array(),0,read));
                }else if(next.isAcceptable()){
                    System.out.println("数据读取事件");
                }
            }
        }
    }
}
