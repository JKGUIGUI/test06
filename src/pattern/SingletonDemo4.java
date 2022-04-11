package pattern;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * 枚举(没有延时加载)
 */
public enum  SingletonDemo4 {

    //这个枚举元素，本身就是单例对象
    INSTANCE;

    //添加自己的操作
    public void singletonOperation(){

    }

}
