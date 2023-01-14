package arrays;

import java.util.ArrayList;
import java.util.List;



    /*
     * in: [234,42,90,45,987]
     * out: 411 1356
     */
public class MinMaxSum {

    public static int getMinIndx(List<Integer> arr, int startIndx, int endIndx){
        int minIndx = startIndx;
        for(int i = startIndx +1 ; i < endIndx ; i++) if(arr.get(i) < arr.get(minIndx)) minIndx = i; 

        return minIndx;
    }

    public static void swap(List<Integer> arr, int indx1, int indx2){
        int tmp = arr.get(indx1);
        arr.set(indx1, arr.get(indx2));
        arr.set(indx2, tmp);
    }
    public static void selectionSort(List<Integer> arr){
        for(int i= 0 ; i < arr.size() ; i++)
            for(int j = 0 ; j < arr.size(); j++){
                int minIndx = getMinIndx(arr,j,arr.size());
                if(j!=minIndx) swap(arr,j,minIndx);
            }
    }


    public static void minMaxSum(List<Integer> arr){
        int size = arr.size();
        selectionSort(arr);
        arr.forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println();
        if(arr.size() <= 3){
            int count=0;
            for(int n: arr) count+=n;
            System.out.println(count+" "+count);
        }
        else{
            System.out.print((arr.get(0)+arr.get(1)+arr.get(2)+arr.get(3))+" ");
            System.out.print((arr.get(size-1)+arr.get(size-2)+arr.get(size-3)+arr.get(size-4))+" ");
        }
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add((int)Math.pow(10,9));
        arr.add((int)Math.pow(10,9));
       minMaxSum(arr);
    }    
}
 