package com.iava.arithemetic;

public class LargeNumberAlgthm {

/**
 * дһ�����򣬼���N(1  <=N  <=50,000,000)�׳˵����ұߵķ���λ��ֵ��   
   ע��:10,000,000����2499999���㡣  
   ������һ����N,  
   �����һ��������ʾ���ұߵķ���λ��ֵ��  
   ������12(12! = 1 x 2 x 3 x 4 x 5 x 6 x 7 x 8 x 9 x 10 x 11 x 12 = 479,001,600 );  
   �����6;
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
		System.out.println(result+"\n���ұ߷���������0�ĸ���Ϊ��"+zeroNumber);
	}

}
