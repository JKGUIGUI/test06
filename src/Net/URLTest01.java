package Net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com/index.html");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
    }
}
