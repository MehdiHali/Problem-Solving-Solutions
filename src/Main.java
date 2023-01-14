import java.io.*;
import java.util.*;


public class Main {
    
    /*
     * 1 2 2 3
     * 1 2 2 5
     * 
     * 1 2 2 3
     * 2 3 5
     */
    public static List<Integer> solution2(int[] arrN, int[] arrM){
        List<Integer> intersection = new  ArrayList<Integer>();
        Map<Integer,Integer> countMapN = new HashMap<Integer,Integer>();
        Map<Integer,Integer> countMapM = new HashMap<Integer,Integer>();
        int i=0, j=0;
        while(i<arrN.length && j<arrM.length){
            if(arrN[i]<arrM[j])
                i++;
            else if(arrN[i]>arrM[j])
                j++;
            else{
                intersection.add(arrN[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }


    public static List<Integer> solution1(int[] arrN, int[] arrM){


        List<Integer> intersection = new  ArrayList<Integer>();
        Map<Integer,Integer> countMapN = new HashMap<Integer,Integer>();
        Map<Integer,Integer> countMapM = new HashMap<Integer,Integer>();

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
                    countMapN.put(el, countMapN.getOrDefault(el,0)+1);          

            for(int el : arrN)
                if( el >= start && el <= end)
                    countMapM.put(el, countMapM.getOrDefault(el,0)+1);

            countMapN.forEach((Integer key,Integer value)->{
                if(countMapM.containsKey(key))
                    for(int i = 0 ; i< Math.min(countMapM.get(key), countMapN.get(key)); i++){
                        // System.out.print(key);
                        intersection.add(key);
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
        
        List<Integer> intersection = Main.solution2(arrN, arrM);
        if(intersection.isEmpty()) 
            System.out.println("Empty");
        else 
            for(int i = 0 ; i < intersection.size()-1; i++)
                System.out.print(intersection.get(i)+" ");
                System.out.println(intersection.get(intersection.size()-1));
        sc.close();
    }

}
