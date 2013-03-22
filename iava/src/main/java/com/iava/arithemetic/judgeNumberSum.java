package com.iava.arithemetic;

import com.iava.arithemetic.sort.Sort;

public class judgeNumberSum {

//给定一个数组，该数组包含N个元素。我们想要确定是否存在两个数它们的和等于给定的数K。
//例如，如果输入是8，4，1，6而K是10，则答案为yes（4和6）。一个数可以被使用两次。 
// 给出求解该问题的O（NlogN）算法。
	
    public void judgeTwoNumbersSum(int a[],int sum)
    {
    	int i,j;
    	boolean flag=false;
    	i=0;j=a.length-1;
    	while(i<=j)
    	{
    		if(a[i]+a[j]>sum)
    			j--;
    		else if(a[i]+a[j]<sum)
    			i++;
    		else
    		{
    			System.out.println(a[i]+"+"+a[j]+"="+sum);
    			i++;j--;
    			flag=true;
    			
    			
    		}
    	}
    	if(!flag)
    	System.out.println("not found!");
    	
    }
    
    public void judgeThreeNumbersSum(int a[],int sum)
    {
    	int temp;
    	for(int i=0;i<a.length;i++)
    	{
    	    temp=sum-a[i];
    	    judgeTwoNumbersSum(a,temp);
    	}
    }
	public static void main(String[] args)
	{
		int []numbers={4,2,5,7,6,9,23,45,15,46,42,20,14,16};
		Sort sort=new Sort();
		judgeNumberSum judge=new judgeNumberSum();
		sort.quick_sort(numbers);
		judge.judgeTwoNumbersSum(numbers, 13);
		//judge.judgeThreeNumbersSum(numbers, 13);
		
	}
}
