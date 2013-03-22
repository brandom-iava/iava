package com.iava.arithemetic;

public class LargeNumberAlgthm {

/**
 * 写一个程序，计算N(1  <=N  <=50,000,000)阶乘的最右边的非零位的值。   
   注意:10,000,000！有2499999个零。  
   输入是一个数N,  
   输出是一个整数表示最右边的非零位的值。  
   如输入12(12! = 1 x 2 x 3 x 4 x 5 x 6 x 7 x 8 x 9 x 10 x 11 x 12 = 479,001,600 );  
   则输出6;
 */ 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,result,zeroNumber=0;
		for(i=result=1;i<=10000000l;i++)
		{
			result *= i;
             while(result == (result / 10) * 10)
             {
				 result /= 10;
				 zeroNumber++;
             }
			 result %= 10;
         }
		System.out.println(result+"\n最右边非零数后面0的个数为："+zeroNumber);
	}

}
