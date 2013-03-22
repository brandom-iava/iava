package com.iava.arithemetic;

public class Knapsack_greedy {

	//背包问题的求解（可分割的包）
	public float greedy_Knapsack(float M , Knapsack sack[] , float x[])
	{
		
		float m=M , p=0 ;
		for(int i=0; i<sack.length; i++)
		{
			sack[i].v=sack[i].p/sack[i].w;
			x[i]=0;
		}
		sortSack(sack);
		
		for(int i=0; i<sack.length; i++)
		{
			if(sack[i].w<=m)
			{
				x[i]=1;
				m-=sack[i].w;
				p+=sack[i].p;
			}else//最后一个包，可以分割
			{
				x[i]=m/sack[i].w;
				p+=x[i]*sack[i].p;
				break;
			}
		}
		return p;
	}
	
	public void sortSack(Knapsack a[])
	{
		recQuickSort(a,0,a.length-1);
	}
	/*public void quick_sort(Knapsack a[])
	{
		recQuickSort(a,0,a.length-1);
	}*/
	public void recQuickSort(Knapsack a[],int start,int end)
	{
		if(start>end)
			return ;
		int p=partion(a,start,end);
		recQuickSort(a,start,p-1);
		recQuickSort(a,p+1,end);
	}
	public int partion(Knapsack a[],int start,int end)
	{
	    int right=end-1;
		while(true)
		{
			while(a[start].v>a[end].v)
				start++;
			while(right>0&&a[right].v<a[end].v)
				right--;
			if(start>=right)
				break;
			else
			 swap(a,start,right);
		}
		swap(a,start,end);
		return start;
		
	}
	
	public void swap(Knapsack a[],int i,int j)
	{
		Knapsack temp=a[j];
		a[j]=a[i];
		a[i]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Knapsack_greedy greedy=new Knapsack_greedy();
		Knapsack []sack=new Knapsack[10];
		float x[]=new float[10];
		for(int i=0;i<10;i++)
		{
			sack[i]=new Knapsack();
			sack[i].p=10*(float)Math.random();
			sack[i].w=50*(float)Math.random();
			x[i]=0;
		}
		for(int i=0;i<10;i++)
		{
			System.out.print(sack[i].p+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++)
		{
			System.out.print(sack[i].w+" ");
		}
		System.out.println();
		float p=greedy.greedy_Knapsack(100, sack, x);
		
		for(int i=0;i<10;i++)
		{
			System.out.print(x[i]+" ");
		}
		System.out.println();
		System.out.println(p);
		
	}

}
