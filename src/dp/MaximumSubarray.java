package dp;
import java.util.Scanner;

public class MaximumSubarray {
    // public static void solution(int[] arr){
    //     int maxSum = 0 ;
    //     int i=0, j=0;
    //     int tmpSum=0;
    //     while( (i<arr.length) && (j< arr.length)){
    //         if(tmpSum >= tmpSum+arr[j]){
    //             tmpSum-=arr[i];
    //             i=j;
    //             j++;
    //             tmpSum+=arr[j];
    //         }
    //         else{
    //             tmpSum+=arr[j];
    //             if(maxSum < tmpSum)
    //             {
    //                 maxSum = tmpSum;
    //                 j++;
    //             }
    //         }
    //     }

    //     System.out.println(maxSum);

    // }

    public static void solution2(int[] arr){
        int maxSum=0;
        int tmpSum=0;
        for(int i =0 ; i < arr.length ; i++){
            tmpSum+=arr[i];
            if(tmpSum<0){
                tmpSum=0;
                // System.out.println("tmpsum = 0");
            }else{
                // System.out.println("tmpsum: "+tmpSum);
                if(tmpSum>maxSum) maxSum=tmpSum;
                // System.out.println("maxsum: "+maxSum);
            }
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        solution2(arr);
    }
}
