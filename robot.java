import java.util.*;

public class Robot {
    public static int x;
    public static int y;
    public int countWays(int[][] map, int x, int y) {
        
        int[][] dp = new int[x][y];
        
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                dp[i][j] = 0;
            }
        }
 
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (map[i][j] != 1) {
                    continue;
                }

                // 循环每一个网格
                if (i == 0 && j == 0) {

                    // 起点为1
                    dp[i][j] = 1;
                } 

                // 第一行
                else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                } 

                // 第一列
                else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } 

                // 其他网格
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%1000000007;
                }
            }
        }
 
 
        return dp[x - 1][y - 1];
    }
    public static void main(String[] args){
        Robot Robot=new Robot();
        x=11;
        y=4;
        int[][] map={{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
        int res=Robot.countWays(map,x,y);
        System.out.println(res);
    }
}