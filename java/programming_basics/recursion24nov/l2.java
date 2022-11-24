import java.util.Scanner;
public class l2 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(rpow(2,10));
    }
    
    public static int pow(int number, int power){
        int res = 1;
        while (power > 0){
            if ((power & 1) != 0){
                res*=number;
            }
            power >>= 1;
            number*=number;
        }
        return res;
    }
    
    public static int rpow(int number, int power){
        if (power == 0) return 1;
        if ((power&1) != 0) return number*rpow(number*number, power>>1);
        return rpow(number*number, power>>1);
    }
    
    public static String bin(int number){
        String res = "";
        while (number > 0){
            res+=String.valueOf(number%2);
            number/=2;
        }
        return reverse(res);
    }
    
    public static String reverse(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            res+=str.charAt(str.length()-i-1);
        }
        return res;
    }
}
