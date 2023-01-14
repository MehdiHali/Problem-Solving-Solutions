package staircase;

public class Staircase {

    /*
     *     #
     *    ##
     *   ###
     *  ####
     * #####
     * n=5
     */
    public static String staircase(int n){
        String staircase="";
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n-i-1; j++) staircase+=" ";
            for(int j = n-1 ; j >= n-i-1; j--) staircase+="#";
            staircase += (i<n-1)?("\n"):"";
        }
        return staircase;
    }
    public static void main(String[] args) {
        System.out.println(staircase(5));
    }
}
