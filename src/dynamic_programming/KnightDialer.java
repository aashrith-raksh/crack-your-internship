package dynamic_programming;

import java.util.Arrays;

public class KnightDialer {
    int move_x[]={-2,-2,2,2,-1,-1,1,1};
    int move_y[]={-1,1,-1,1,-2,2,-2,2};
    int dp[][][];
    int MOD = (int) 1e9 + 7;
    boolean isValid(int x, int y){
        if(x<0 || y< 0 || x>3 || y>2){
            return false;
        }
        if(x==3 && y!=1){
            return false;
        }
        return true;
    }
    int recur(int x , int y , int N){
        if(N==1){
            return 1;
        }
        if(dp[x][y][N]!=-1){
            return dp[x][y][N];
        }
        int s=0;
        for(int i=0;i<8;i++){
            int nx,ny;
            nx=x+move_x[i];
            ny=y+move_y[i];
            if(isValid(nx,ny)){
                s= (s+recur(nx,ny,N-1))% MOD;
            }
        }
        return dp[x][y][N]= s;
    }
    public int knightDialer(int n) {
        dp= new int[4][3][n+1];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        int s=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               s=(s+recur(i,j,n))% MOD;
            }
        }
        s= (s+recur(3,1,n))% MOD;
        return s;
    }

}
