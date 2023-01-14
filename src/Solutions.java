import java.util.LinkedList;
import java.util.List;

class P1{
    public static int arraySum(int[] arr){
        int sum=0;

        for(int i: arr){
            sum+=i;
        }

        return sum;
    }

    public static int[] compareTriplets(int[] a, int[] b){
        int[] results = {0,0};
        if(a.length != b.length) return null;
        for(int i =0 ; i<3; i++){
            if(a[i] > b[i]) results[0]++;
            if(a[i] < b[i]) results[1]++;
        }
        return results;
    }

    public static long aVeryBigSum(List<Long> ar){
        long sum = 0;
        for(long l: ar) sum+=l;

        return sum;
    }
}


public class Solutions {

    public static void main(String[] args) {
        
    }
    
}
