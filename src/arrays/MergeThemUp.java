package arrays;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class MergeThemUp{


    /*
     * 1 2 2 3
     * 1 2 2 5
     * 
     * 1 2 2 3
     * 2 3 5
     */
    public static List<Integer> solution(int[] arrN, int[] arrM){


        List<Integer> intersection = new  ArrayList<Integer>();
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();

        // if either of the arrays have one element then just 
        // test existence of that element in the other array
        if(arrN.length == 1){
            for(int i : arrM) if(arrN[0] == i) intersection.add(arrN[0]); 
        } 
        else if(arrM.length == 1){
            for(int i : arrN) if(arrM[0] == i) intersection.add(arrM[0]); 
        }
        // else we will count frequency of existence of all elements in both arrays
        // and store result in a HashMap for a fast retrieval afterwards
        else{

            // interval of intersection 
            int start = Math.max(arrN[0], arrM[0]);
            int end = Math.min(arrN[arrN.length-1], arrM[arrM.length-1]);

            // we will only count elements within interval
            // interval of intersection
            for(int el : arrM) 
                if( el >= start && el <= end)  
                    countMap.put(el, 1);          

            for(int el : arrN)
                if( el >= start && el <= end)
                    countMap.put(el, countMap.getOrDefault(el,0)+1);

            countMap.forEach((Integer key,Integer value)->{
                int count = value;
                while(count >= 2){
                    intersection.add(key);
                    count--;
                }
            });
        }

        return intersection;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrN = new int[n];
        int[] arrM = new int[m];
        for(int i =0 ; i < n ; i++) arrN[i] = sc.nextInt();
        for(int i =0 ; i < m ; i++) arrM[i] = sc.nextInt();
        
        System.out.println("n="+n+" m="+m);
        List<Integer> intersection = MergeThemUp.solution(arrN, arrM);
        if(intersection.isEmpty()) System.out.println("Empty");
        else for(int i : intersection) System.out.print(i+" ");
        System.out.println("");
        sc.close();
    }

}