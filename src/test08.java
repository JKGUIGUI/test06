public class test08 {
    public static void main(String[] args) {
        A[] as = new A[10];
    }
}

class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}

class A extends A_Father{
    public static  int width = 100;
    public static final int MAX = 100;
}

class A_Father{
   static {
       System.out.println("静态初始化A_Father");
   }
    public static  int width = 300;
}