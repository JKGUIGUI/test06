import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserCustomerClassLoader extends ClassLoader{
    //1、创建一个私有的String类型的classPath变量，确定class文件位置
    private String classPath;

    public UserCustomerClassLoader(String classPath) {
        this.classPath = classPath;
    }


    private byte[] loadByte(String name) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(classPath+"/"+name+".class");
        int len = fileInputStream.available();
        byte[] data = new byte[len];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }

    //继承Classloader类，重写findClass·方法，返回一个Class对象
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = new byte[0];
        try {
            data = loadByte(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //name：是该类的全限定类名
        //data：是一个byte【】数组，由fileInputStream返回
        //0是数组起始位置
        //数组长度
        return defineClass(name,data,0, data.length);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        UserCustomerClassLoader customerClassLoader = new UserCustomerClassLoader("/Users/guigui/IdeaProjects/src/test06/src/");
        Class<?> clazz= customerClassLoader.loadClass("HelloGC");
        System.out.print(clazz.getClassLoader().getClass().getName());
    }
}
