package work7_30;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -30
 * Time: 10:31
 */
public class Work1 {

    public static int maxPath(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(i == 0 && j == 0) arr[i][i] = grid[i][j];
                else if(i == 0) arr[i][j] = arr[i][j-1] + grid[i][j];
                else if(j == 0) arr[i][j] = arr[i-1][j] + grid[i][j];
                else arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]) + grid[i][j];
            }
        }
        return arr[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,5},{3,2,1}};
        System.out.println(maxPath(grid));
    }

}
