package Recursion;
//递归实现阶乘
public class TestFactorial {
    public static void main(String[] args) {
        long result = factorial(10);
        System.out.println(result);
    }

    //求n的阶乘
    public static long factorial(int n){
        if(n == 1)
            return 1;
        return n*factorial(n-1);
    }
}
