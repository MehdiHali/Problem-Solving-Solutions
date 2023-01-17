package hashTables;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();        

        map.put(3, new LinkedList<>());
        map.get(3).add(4);
        map.get(3).add(6);

        map.forEach((k,v)->{
            int el1 = v.remove(0);
            int el2 = v.remove(0);
            System.out.println(k+": "+el1+","+el2);
        });
    }
}
