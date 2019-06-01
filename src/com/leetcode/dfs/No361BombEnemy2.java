package com.leetcode.dfs;

public class No361BombEnemy2 {
    public int maxKilledEnemies(char[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        final EnemyCount[][] count = new EnemyCount[m][n];
        for(int i = 0; i<m;i++){
            for(int j = 0;j<n;j++){
                EnemyCount ec = count[i][j] = new EnemyCount();
                if(grid[i][j] == 'W') continue;

                ec.left = (j == 0? 0 : count[i][j-1].left) + (grid[i][j] == 'E'? 1 : 0);
                ec.up = (i == 0? 0 : count[i-1][j].up) + (grid[i][j] == 'E'? 1 : 0);
            }
        }


        int maxKill = 0;
        for(int i = m-1; i>=0;i--){
            for(int j = n - 1;j>=0;j--){
                if(grid[i][j] == 'W') continue;

                EnemyCount ec = count[i][j];
                ec.right = (j == n-1? 0 : count[i][j+1].right) + (grid[i][j] == 'E'? 1 : 0);
                ec.down = (i == m-1? 0 : count[i+1][j].down) + (grid[i][j] == 'E'? 1 : 0);

                if(grid[i][j] == '0') maxKill = Math.max(maxKill, ec.left + ec.right + ec.up + ec.down);
            }
        }

        return maxKill;
    }

    class EnemyCount{
        int left, right, up, down;
    }
}
