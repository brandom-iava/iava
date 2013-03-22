package com.iava.arithemetic;

public class MaxLengthSameString {

	public static void getMaxLengthString(String str){
		int i = 0,j = 0,k = 0;
		
		for(int m=0;m<str.length()-1;m++){
			char c1 = str.charAt(m);
			char c2 = str.charAt(m+1);
			if(c1 == c2){
				j++;
			}else if((k-(j+1))>(j-i)){
				i = j+1;
				j = k;
			}else{
				
			}
			k++;
		}
		
		System.out.printf("%s",str.substring(i, j));
	}
	
	public static void main(String args[]){
		getMaxLengthString("aaabbbbcccccc");
	}
}
