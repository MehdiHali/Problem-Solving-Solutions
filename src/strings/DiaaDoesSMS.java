package strings;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DiaaDoesSMS {
    public static boolean noMappings=true;
    public static void solution(){

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        /*
         * i will store both lists in a map which will
         * make retrieving keys later efficient
         */
        Map<String,String> map1 = new HashMap<String,String>();
        for(int i = 0 ; i < N ; i++){
            String line = sc.nextLine();
            String[] parts = line.split(",");
            if(parts.length==2)
            map1.put(parts[0],parts[1]);
        }

        int M = sc.nextInt();
        sc.nextLine();
        Map<String,String> map2 = new HashMap<String,String>();
        for(int i = 0 ; i < M ; i++){
            String line = sc.nextLine();
            String[] parts = line.split(",");
            if(parts.length==2)
            map2.put(parts[1],parts[0]);

        }

        List<String> l = new LinkedList<String>();
        /*
         * for each key of map1 we will ensure if it exists in map2
         * if it exists we will print the mapping
         */
        map1.forEach((MSISDN, IMSI)->{
            if(map2.containsKey(MSISDN) && map2.get(MSISDN)!=""){
                // System.out.println(MSISDN+","+IMSI+","+map2.get(MSISDN));
                l.add(MSISDN+","+IMSI+","+map2.get(MSISDN));
                noMappings=false;
            }
        });

        /**
         * Technic: to sort by multiple columns
         * just concatenate them, then sort by one column
         */
        l.sort(null);
        for(int i = 0 ; i < l.size() ; i++) {
            System.out.println(l.get(i));
        }

        if(noMappings) System.out.println("nomatch");

        sc.close();
    }
}