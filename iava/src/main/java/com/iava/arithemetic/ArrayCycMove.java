package com.iava.arithemetic;

public class ArrayCycMove {

	/**
	 * 设计一个时间复杂度为o(n),空间复杂度不超过o(2)的算法,
	该算法实现数组a[0.n-1]中所有元素依次循环右移k个位置
	@param a the array of move
	@param k  bit of the array move
	*/
	public void CycMoveArray(int a[],int k)
	{
		
		int i,j,t,temp,count;
		int n=a.length;
		count=0;
		k=k%n;
		if(k!=0)
		{
			i=0;
			while(count<n)
			{
				j=i;t=i;
				temp=a[i];
				while((j=(j-k+n)%n)!=i)
				{
					a[t]=a[j];
					t=j;
					count++;
				}
				a[t]=temp;
				count++;
			}
		}
	}
	
	public void CycMoveArray(int a[],int begin,int end,int k)
	{
		reverse( a,begin, end-k );  
		reverse( a,end-k+1, end );  
		reverse( a,begin, end );  

	}
	
	public void reverse(int a[],int begin,int end)
	{
		while(begin<end)
			swap(a,begin++,end--);
	}
	
	public void swap(int a[],int i,int j)
	{
		int temp=a[j];
		a[j]=a[i];
		a[i]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,5,6,7,8,9,10,11,12,13};
		ArrayCycMove move=new ArrayCycMove();
		//move.CycMoveArray(a, 1);
		move.CycMoveArray(a, 0, 12, 2);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		
		System.out.println("\n"+System.getProperty("java.version"));
		
	}

}
