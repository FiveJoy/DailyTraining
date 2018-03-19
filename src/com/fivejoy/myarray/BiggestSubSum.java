package com.fivejoy.myarray;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class BiggestSubSum {
	//方法入口
	//检查无效输入&定义全局变量标记无效输入
	static boolean InvalidInput=false;
	public static int Solution_biggest_sum(int[] arr){
		if(arr==null||arr.length<1)
		{
			InvalidInput=true;
			return 0;
		}
		return GetBiggestByJianZhi(arr);

	}
	public static void main(String[] args){
//		int[] arr={1,-2,3,10,-4,7,2,-5};
//		System.out.println(Solution_biggest_sum(arr));
		int[] arr={1};
		System.out.println(GetBiggestSubSum(arr));
	
	}
	
//总结：一共有六种想法
	//1.分别是我远古的以为会错的记忆结果写出来竟然AC了
	//2.3. 剑指offer的两种殊途同归的想法，但代码最终是一样样的。第一种是找规律比较容易，但是会担心有没有漏的情况。而第二种的思考起来真的很容易哈哈
	//4.5.6 MOOC采用了暴力&暴力升级&分而治之的三种思路
	
	// 通过{1,-2,3,10,-4,7,2,-5}找规律
	//难点一 时间复杂度O(N)
	//难点二 得到最终的子序列的i,j;
	
	//这个解法，把maxSum的值该为极小值(2^(-31)以后，也AC了==)
	//我想这个想法和剑指offer上的想法有区别在于，一个是先考虑再加当前值，一个是先加上当前值再考虑。
	//最后整理的时候发现竟然是MOOC的算法哈哈开心，我记得很扎实
	//原理：在不断向右累加的过程中，发现更大的thisum就更新maxsum，如果当前子列和为负，则不可能对后面造成积极影响，故抛弃直接thisum=0;
	public static int GetBiggestSubSum(int[] arr){
		int thisSum=0;
        int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			thisSum+=arr[i];
			if(thisSum>maxSum)
				maxSum=thisSum;
			else if(thisSum<0)
				thisSum=0;
		}
		return maxSum;
	}
	//未检验
	//kaolv难点二 得到最终的子序列的i,j;
	//使用 有三个元素的数组 0——maxsum,1——i,2——j
	public int[] GetBiggestSubSumGetIndex(int[] arr){
		int[] re=new int[3];
		int thisSum=0,maxSum=0;
		int a=0,b=0;
	
		for(int i=0;i<arr.length-1;i++){
			thisSum+=arr[i];			
			if(thisSum>maxSum){
				maxSum=thisSum;
				b=i;
				re[1]=a;
				re[2]=b;
			}			
			else if(thisSum<0){
				thisSum=0;
				a=i+1;
			}
			
		}
		re[0]=maxSum;
		return re;
	}

	//------------注意MaxSum初始值应设为MIN_VALUE类似无穷小这种---------------------------
	//剑指offer上有：
	//① 如果从i加到j的子数组的和比j位置的元素本身还小，也就是说从i开始的子数组的和 比 从j位置开始的子数组的和小，此时抛弃从i-(j-1)位置的子数组，从j位置重新开始
	//② 如果加上位置k上的值以后的sum值比不加小，这时候记录一下不加之前的sum值（因为有可能是最大的子数组的和了）
	//③ 继续加的时候，发现当前的sum比原来的maxsum值大了，就更新maxsum值
	//$$注意，针对①和②，把thissum赋给maxsum就交给一会做。这两部都可以看做是对thissum的修改，就是到底加不加这个值，以及要不要舍弃之前的值;因此注释掉的位置现在可以转化为一个if-else来做
	public static int GetBiggestByJianZhi(int[] arr){
		int thisSum=0;
		 int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
//			if((thisSum+arr[i])<thisSum)
//				maxSum=thisSum;
//			thisSum+=arr[i];
//			if(thisSum<arr[i]){
//				//舍弃i-1之前的元素	
//				thisSum=arr[i];
//				//——这时候可以更新左边界了	
//			}
			if(thisSum<0)
				thisSum=arr[i];
			else thisSum+=arr[i];
			if(thisSum>maxSum)
				maxSum=thisSum;
		}
		return maxSum;
	}
	//剑指offer上还有：应用动态规划的思想，得到递归公式
	//f(i)=arr[i] i=0|f(i-1)<=0
	//f(i)=f(i-1)+arr[i]; i!=0&&f(i-1)>0
	//但是总体的思想和上一个是一样的
	
	//--------------------浙大MOOC上也讲到这个题-----
	//1、暴力解决。将可能的左边界i，和右边界j都列出来，然后对i-j之间的数值进行循环计算sum   O(N^3)。最容易的对数器
	//2、对暴力算法进行优化，当i不变，j不断从i增长到length-1的时候。前面的sum其实是不变的。因此thissum=0不需要写在j循环下面，写在i循环下面就可以。
	    //然后内层计算i-j之间sum的时候就可以省去循环i-j计算和的过程，直接加arr[j]即可
	//3、使用分而治之。对左右两半子数组分别求biggestsum&对横跨中间的子数组求biggestsum（编码比较麻烦&长也没考虑如何写出来）
	//4、MOOC一共有三节，第一节讲了1&2，第二节讲了3，第四节是在线处理——实际上是对数据流或者说是一次遍历的结果O(N)！就是我记忆深处的解法！！开心！
}
