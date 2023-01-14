package strings;

public class CamelCase{

    /**
    - char does not have Char.valueOf ?
    - cannot cast String to char or int?
     */

    public static int solution(String s){
        String[] arr = new String[s.length()]; 
        int words_count = 1;
        arr = s.split("");
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].charAt(0) < 97)
            words_count++;
        }
        return words_count;
    }

    public static void main(String args[]){
        System.out.println(CamelCase.solution("helloBeautifulWorld"));

    }
}