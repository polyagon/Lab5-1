package org.example;

import java.util.Scanner;

public class informaticsSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] numN = new int[n];
        int[] numK = new int[k];

        for(int i = 0; i < n; i++){
            numN[i] = in.nextInt();
        }

        for(int i = 0; i < k; i++){
            numK[i] = in.nextInt();
        }

        for(int i : numK){
            int l = 0;
            int r = n;
            int ans = 2000000000;
            while (r - l > 1){
                int m = (l + r) / 2;
                if(ans > Math.abs(i - numN[m])){
                    ans = Math.abs(i - numN[m]);
                }

                if(i > numN[m]){
                    l = m;
                }else{
                    r = m;
                }
            }
        }




    }
}
