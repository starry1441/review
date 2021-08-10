package work8_10;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -10
 * Time: 15:41
 */
public class Work4 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(top < (matrix.length+1)/2 && left < (matrix[0].length+1)/2) {
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for(int i = top+1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            for(int i = right-1; top!=bottom && i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            for(int i = bottom-1; left!=right && i >= top+1; i--) {
                list.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(m));
    }

}
