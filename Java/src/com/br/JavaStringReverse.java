package com.br;

import java.io.*;
import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        A = A.toLowerCase();
        int len = A.length();
        if(len>50)
            System.exit(0);
        char charArray[] = A.toCharArray();
        boolean isPalindrome = false;
        for(int i=0,j=len-1;i<=j;i++,j--){
               if(charArray[i] == charArray[j]){
                   isPalindrome = true;
               }
               else{
                   isPalindrome = false;
                   break;
               }
        }
        if(isPalindrome == true)
            System.out.println("Yes");
        else
            System.out.println("No");
        sc.close(); 
    }
}