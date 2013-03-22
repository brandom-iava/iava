package com.iava.arithemetic.sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sort {
  
	public void quick_sort(int a[])
	{
		recQuickSort(a,0,a.length-1);
	}
	public void recQuickSort(int a[],int start,int end)
	{
		if(start>end)
			return ;
		int p=partion(a,start,end);
		recQuickSort(a,start,p-1);
		recQuickSort(a,p+1,end);
	}
	public int partion(int a[],int start,int end)
	{
	    int right=end-1;
		while(true)
		{
			while(a[start]<a[end])
				start++;
			while(right>0&&a[right]>a[end])
				right--;
			if(start>=right)
				break;
			else
			 swap(a,start,right);
		}
		swap(a,start,end);
		return start;
		
	}
	
	public void swap(int a[],int i,int j)
	{
		int temp=a[j];
		a[j]=a[i];
		a[i]=temp;
	}
	
	public void heapSort(int a[])
	{
		int i,temp;  
	    int heap_size=a.length-1;  
	    buildHeap(a);  
	for(i=heap_size;i>=0;i--)  
	    {  
		    temp=a[i];
	        a[i]=a[0];  
	        a[0]=temp;  
	        heap_size--;  
	        max(a,heap_size,0);  
	    }
	}
	
	public void max(int a[],int heap_size,int i)
	{
		int largest, l, r;
		int temp;
		l = 2 * i + 1;
		r = 2 * i + 2;
		if (l <= heap_size && a[l] > a[i])
			largest = l;
		else
			largest = i;
		if (r<heap_size && a[r] > a[largest])
			largest = r;
		if (largest != i)
		{
			temp =  a[largest] ;
			a[largest] = a[i];
		    a[i] = temp ;
		    max(a,heap_size,largest); 
		}
		
	}
	
	public void buildHeap(int a[])
	{
		for(int i=a.length-1;i>=0;i--)
		{
			max(a,a.length-1,i);
		}
	}
	
	
	public static void main(String []args)
	{
		int []numbers={4,2,5,7,6,9,23,45,15,46};
		Sort sort=new Sort();
		/*String a="abc";
		String b="bcd";
		System.out.println(b.compareToIgnoreCase(a));*/
		//sort.quick_sort(numbers);
		sort.heapSort(numbers);
		for(int i=0;i<numbers.length;i++)
			System.out.println(numbers[i]);
		
		DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		Calendar calend = Calendar.getInstance();
		calend.set(Calendar.MONTH, calend.get(Calendar.MONTH) -2);
		calend.set(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println(calend.getTime());
		System.out.println(df.format(calend.getTime()));
		
	}
}
