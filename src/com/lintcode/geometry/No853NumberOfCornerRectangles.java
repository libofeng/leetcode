package com.lintcode.geometry;

public class No853NumberOfCornerRectangles {
    // reference: http://www.cnblogs.com/grandyang/p/8433813.html

    /**
     * @param grid: the grid
     * @return: the number of corner rectangles
     */
    public int countCornerRectangles(int[][] grid) {
        int total = 0;
        final int m = grid.length, n = m==0? 0 : grid[0].length;
        for(int i = 0;i<m-1;i++){
            for(int j = 0;j<n-1;j++){
                if(grid[i][j]!=1) continue;

                for(int p = i+1;p<m;p++){
                    for(int q = j+1;q<n;q++){
                        if(grid[p][q]!=1) continue;

                        if(grid[i][q]==1 && grid[p][j]==1) total ++;
                    }
                }
            }
        }

        return total;
    }


    public int countCornerRectangles2(int[][] grid) {
        int total = 0;
        final int m = grid.length, n = m==0? 0 : grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = i + 1;j<m;j++){
                int cols = 0;
                for(int k = 0; k<n;k++) if(grid[i][k]==1 && grid[j][k]==1) cols++;

                total += (cols-1) * cols / 2;
            }
        }

        return total;
    }

}
