package work6_30;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -01
 * Time: 10:10
 */
public class test {

    public static void main(String[] args) {
        String[] color = {"红","黄","蓝"}; //表示颜色的字符串数组
        //外循环：控制行，几种颜色就几行
        for (int i = 0; i < 3; i++) {
            //内循环：控制列，共几列
            for (int j = 0; j < 20; j++) {
                System.out.print(color[i]); //输出颜色
            }
            System.out.println();   //换行
        }
    }

}
