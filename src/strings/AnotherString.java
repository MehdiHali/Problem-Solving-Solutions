package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class AnotherString {


    /*
     * generate n unique random numbers that are less than n
     * these numbers will be the indexes of the new shuffled array
     */
    public static List<Integer> getRandomNumbers(int n){
        int count=0;
        List<Integer> randoms = new ArrayList<Integer>();

        while(count < n){
            int rand = (int)Math.floor(Math.random()*(n));
            if(!randoms.contains(rand)){
                randoms.add(rand);
                count++;
            }
        }
        return randoms;
    }


    public static void solution(String s){
        String[] parts = s.split("");
        String shuffled="";
        List<Integer> randoms = getRandomNumbers(parts.length);
        for(int i = 0 ; i < parts.length; i++){
            shuffled+= parts[randoms.get(i)]+"";
        }

        System.out.println(shuffled);
    }
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = new String[n];
        for(int i = 0 ; i < n ; i ++){
             strings[i] = sc.nextLine();
        }

        for(int i = 0 ; i < n ; i++){
            solution(strings[i]);
        }



        sc.close();
    }    
}
