package strings;

import java.util.Scanner;

public class EasySpliting {

    public static int solution(int[] arr, int M){
        int min_splits=0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] > M) return -1;
            int tmp_sum = 0;

            // add next element while we don't exceed M
            while(i<arr.length && tmp_sum+arr[i] <= M){
                tmp_sum+=arr[i];
                i++;
            }
            min_splits++;
        }

        return min_splits;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        
        int minSplits = solution(arr, M);
        System.out.println(minSplits);

        sc.close();
        
    }    
}
