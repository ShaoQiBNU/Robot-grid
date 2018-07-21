机器人走方格
===========
# 一. 问题描述

> 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50。

# 二. 求解

> 此题是典型的动态规划问题，动态规划转移方程为：当map[i][j]=1时，dp[i][j]=dp[i-1][j]+dp[i][j-1]；当map[i][j]=0时，dp[i][j]=0。另外，需要注意的是网格边界，边界网格走法的数量取决于前一个网格的数量，而不是map[i][j]=1时，dp[i][j]=1；当map[i][j]=0时，dp[i][j]=0。代码如下：

```Java
import java.util.*;

public class Robot {
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
}
```
