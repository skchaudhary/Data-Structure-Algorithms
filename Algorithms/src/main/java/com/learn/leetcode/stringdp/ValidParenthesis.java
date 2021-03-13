package com.learn.leetcode.stringdp;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s="([)]";
        System.out.println(new ValidParenthesis().isValid(s));
    }
    public boolean isValid(String s) {
        if(s==null || s.length()==0){
            return true;
        }

        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();

        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack1.push(s.charAt(i));
                    break;
                case ')':
                case ']':
                case '}':
                    stack2.add(0, s.charAt(i));
                    break;
                default:
                    return false;
            }
        }

        if(stack1.size()!=stack2.size()){
            return false;
        }

        int size = stack1.size();
        for(int i=0;i<size;i++){
            String para = stack1.peek() +""+ stack2.peek();
            if("()".equals(para) || "{}".equals(para) || "[]".equals(para)){
                stack1.pop();
                stack2.pop();
            }
        }
        if(stack1.size()!=0 || stack2.size()!=0){
            return false;
        }
        return true;
    }
}
