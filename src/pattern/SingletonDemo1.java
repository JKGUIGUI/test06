package pattern;

/**
 * 饿汉式
 */
public class SingletonDemo1 {

    //类初始化时，立刻加载这个对象。加载类时线程安全 （没有延迟加载）
    private static SingletonDemo1 instance = new SingletonDemo1(); //类初始化时，立刻加载这个对象
    private SingletonDemo1(){

    }
    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
