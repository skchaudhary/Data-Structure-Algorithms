package com.learn.leetcode.arraydp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniquePath2 {
    public static void main(String[] args) {
        System.out.println(new UniquePath2().uniquePathsWithObstacles(new int[][]{{0,0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0){
            return 0;
        }

        int height=obstacleGrid.length;
        int width=obstacleGrid[0].length;
        int[][] paths=new int[height][width];

        for(int i=0;i<height;i++){
            if(obstacleGrid[i][0]!=1){
                paths[i][0]=1;
            }else{
                break;
            }
        }

        for(int i=0;i<height;i++){
            if(obstacleGrid[0][i]!=1){
                paths[0][i]=1;
            }else{
                break;
            }
        }

        for(int i=1;i<width;i++){
            for(int j=1;j<width;j++){
                if(obstacleGrid[i][j]!=1){
                    paths[i][j]=paths[i-1][j]+paths[i][j-1];
                }
            }
        }
        System.out.println(paths[height-1][width-1]);
        return paths[height-1][width-1];
    }
}
