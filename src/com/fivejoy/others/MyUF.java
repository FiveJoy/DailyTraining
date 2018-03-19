package com.fivejoy.others;

import javax.print.attribute.standard.RequestingUserName;

public class MyUF {
	public int DATA=0,PARENT=1;
	public int[][] nums;
	
	
	//一种构造方法是直接传数组，即最开始每一个元素都是一个集合
	public MyUF(int[] arr){
		nums=new int[2][];
		nums[DATA]=new int[arr.length];
		nums[PARENT]=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			nums[DATA][i]=arr[i];
			nums[PARENT][i]=-1;
		}
	}
	//另一个构造方法，应该是传入一个二维数组这样子？？先这样吧
//--------------------------------------------------------
	public boolean isSameSet(int m,int n){
		if(findRoot(m)==findRoot(n))
		return true;
		else return false;
		
	}
	public int findRoot(int m){
		return nums[PARENT][findRootIndex(m)];
	}
	public int findRootIndex(int m){
		//循环从nums[DATA][i]找到m，
      //如果nums[PARENT][i]=-1表示是根返回i。否则继续查【parent记录的是索引，如果不是根，就是个正值k,那么根应该在nums[DATA][k]的位置】
	return 0;
	//在这个过程中，注意，可以使用nowcoder的方法，不是使用循环，而是利用递归，直到找到parent=-1的时候，将index不断赋值回来即可。因为递归进行的过程中会把调用过程呢压栈
	//这时候就是，弹出栈（也就是最底部函数不断退出以后就得到了root赋值即可。）
	//nowcoder是利用了两个hashmap，一个是记录node&father,一个是记录node&集合数（感觉有点没啥必要的感觉。就是多余了 ）
	}
	public void union(int m,int n){
		int mrI=findRootIndex(m);
		int nrI=findRootIndex(n);
		//如果相等则不必union
		//不等的话。将一个的parent换成另一个即可。
		//【这里的一个优化是能够加一个项目能够表示这个集合的个数。parent=-1表示根,parent为正表示不是根，还要继续查】
		//【改为parent=负值表示根，正值表示不是根，但是负值的时候，其绝对值就是当前集合的最小值】
	}
}
