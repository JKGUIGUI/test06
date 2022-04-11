package Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
//            System.out.println(addr.getHostAddress());
//            System.out.println(addr.getHostName());

            addr = InetAddress.getByName("www.shsxt.com");
            System.out.println(addr.getHostAddress());
            System.out.println(addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


}
