package exam;

import java.util.Scanner;

public class Rotate {
    
    public static void printMatrix(int[][] M){
        for(int i = 0; i < M.length ; i++){
            for(int j = 0 ; j < M.length ; j++){
                System.out.print(M[i][j]+" ");
            }
            System.out.println();
        }   
    }


    public static void rotateMatrix(int[][] M){
        for(int j = 0; j < M.length ; j++){
            for(int i = M.length-1 ; i >=0 ; i--){
                System.out.print(M[i][j]+" ");
            }
            System.out.println();
        }   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        int [][] M = new int[N][N];

        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                M[i][j] = sc.nextInt();
            }
        }   

        // System.out.println("---");
        // printMatrix(M);
        // System.out.println("---");
        rotateMatrix(M);




    }
}
