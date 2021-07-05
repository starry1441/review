package work7_4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -04
 * Time: 19:59
 */
public class Work {

    private byte[] bytes = new byte[5*1024*1024];
    public Work obj = null;

    public static void main(String[] args) {
        Work w1 = new Work();
        Work w2 = new Work();
        //循环引用
        w1.obj = w2;
        w2.obj = w1;
        //释放对象
        w1 = null;
        w2 = null;
        //强制垃圾回收
        System.gc();
    }

}
