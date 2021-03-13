package com.studypoint;


class Test{

    public static void main(String[] args) {
        System.out.println(findSmallestDivisor("bcdbcdbcd", "bcdbcd"));
    }

    public static int findSmallestDivisor(String s, String t) {
        int lengthOfS= s.length();
        int lengthOfT=t.length();

        if (lengthOfS%lengthOfT!=0) {
            return -1;
        }

        int factor=lengthOfS/lengthOfT;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<factor;i++) {
            sb.append(t);
        }

        if (s.equals(sb.toString())) {
            int[] arr=new int[26];
            for (int i=0;i<t.length();i++){
                arr[s.charAt(i)-'a']++;
            }
            sb=new StringBuffer();
            for (int i=0;i<26;i++) {
                if (arr[i]>0) {
                    sb.append((char) (i + 'a'));
                }
            }
            return sb.toString().length();
        } else {
            return -1;
        }
    }

    int nCr(int n, int r)
    {
        int c=n-r;
        long result = 1;
        while (c<=n) {
            result = result * c++;
        }
        while (r>0) {
            result = result/ r--;
        }
        return (int)result;
    }
}
