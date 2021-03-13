package test.codemonk;

import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long n=sc.nextLong();
            long k=sc.nextLong();
            if(n%(k+1)!=0)
                System.out.println("Arpa");
            else
                System.out.println("Dishant");
        }
    }
}
