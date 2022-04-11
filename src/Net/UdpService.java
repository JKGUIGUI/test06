package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * 1、使用DatagramSocket指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接受包裹receive（DatagramPacket p）
 * 4、分析数据
 *      byte[] getData()
 *             getLength()
 * 5、释放资源
 */
public class UdpService {
    public static void main(String[] args) throws IOException {
        System.out.println("接受方启动中");
//        1、使用DatagramSocket指定端口 创建接收端
        DatagramSocket service = new DatagramSocket(9999);
//      2、准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
// 3、阻塞式接受包裹receive（DatagramPacket p）
        service.receive(packet);
// 4、分析数据
//         byte[] getData()
//         getLength()
        byte[] datas = packet.getData();
        System.out.println(new String(datas));
//                * 5、释放资源
        service.close();
    }
}
