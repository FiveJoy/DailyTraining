package com.fivejoy.myarray;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class BiggestSubSum {
	//�������
	//�����Ч����&����ȫ�ֱ��������Ч����
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
	
//�ܽ᣺һ���������뷨
	//1.�ֱ�����Զ�ŵ���Ϊ���ļ�����д������ȻAC��
	//2.3. ��ָoffer��������;ͬ����뷨��������������һ�����ġ���һ�����ҹ��ɱȽ����ף����ǻᵣ����û��©����������ڶ��ֵ�˼��������ĺ����׹���
	//4.5.6 MOOC�����˱���&��������&�ֶ���֮������˼·
	
	// ͨ��{1,-2,3,10,-4,7,2,-5}�ҹ���
	//�ѵ�һ ʱ�临�Ӷ�O(N)
	//�ѵ�� �õ����յ������е�i,j;
	
	//����ⷨ����maxSum��ֵ��Ϊ��Сֵ(2^(-31)�Ժ�ҲAC��==)
	//��������뷨�ͽ�ָoffer�ϵ��뷨���������ڣ�һ�����ȿ����ټӵ�ǰֵ��һ�����ȼ��ϵ�ǰֵ�ٿ��ǡ�
	//��������ʱ���־�Ȼ��MOOC���㷨�������ģ��Ҽǵú���ʵ
	//ԭ���ڲ��������ۼӵĹ����У����ָ����thisum�͸���maxsum�������ǰ���к�Ϊ�����򲻿��ܶԺ�����ɻ���Ӱ�죬������ֱ��thisum=0;
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
	//δ����
	//kaolv�ѵ�� �õ����յ������е�i,j;
	//ʹ�� ������Ԫ�ص����� 0����maxsum,1����i,2����j
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

	//------------ע��MaxSum��ʼֵӦ��ΪMIN_VALUE��������С����---------------------------
	//��ָoffer���У�
	//�� �����i�ӵ�j��������ĺͱ�jλ�õ�Ԫ�ر���С��Ҳ����˵��i��ʼ��������ĺ� �� ��jλ�ÿ�ʼ��������ĺ�С����ʱ������i-(j-1)λ�õ������飬��jλ�����¿�ʼ
	//�� �������λ��k�ϵ�ֵ�Ժ��sumֵ�Ȳ���С����ʱ���¼һ�²���֮ǰ��sumֵ����Ϊ�п���������������ĺ��ˣ�
	//�� �����ӵ�ʱ�򣬷��ֵ�ǰ��sum��ԭ����maxsumֵ���ˣ��͸���maxsumֵ
	//$$ע�⣬��Ԣٺ͢ڣ���thissum����maxsum�ͽ���һ�����������������Կ����Ƕ�thissum���޸ģ����ǵ��׼Ӳ������ֵ���Լ�Ҫ��Ҫ����֮ǰ��ֵ;���ע�͵���λ�����ڿ���ת��Ϊһ��if-else����
	public static int GetBiggestByJianZhi(int[] arr){
		int thisSum=0;
		 int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
//			if((thisSum+arr[i])<thisSum)
//				maxSum=thisSum;
//			thisSum+=arr[i];
//			if(thisSum<arr[i]){
//				//����i-1֮ǰ��Ԫ��	
//				thisSum=arr[i];
//				//������ʱ����Ը�����߽���	
//			}
			if(thisSum<0)
				thisSum=arr[i];
			else thisSum+=arr[i];
			if(thisSum>maxSum)
				maxSum=thisSum;
		}
		return maxSum;
	}
	//��ָoffer�ϻ��У�Ӧ�ö�̬�滮��˼�룬�õ��ݹ鹫ʽ
	//f(i)=arr[i] i=0|f(i-1)<=0
	//f(i)=f(i-1)+arr[i]; i!=0&&f(i-1)>0
	//���������˼�����һ����һ����
	
	//--------------------���MOOC��Ҳ���������-----
	//1����������������ܵ���߽�i�����ұ߽�j���г�����Ȼ���i-j֮�����ֵ����ѭ������sum   O(N^3)�������׵Ķ�����
	//2���Ա����㷨�����Ż�����i���䣬j���ϴ�i������length-1��ʱ��ǰ���sum��ʵ�ǲ���ġ����thissum=0����Ҫд��jѭ�����棬д��iѭ������Ϳ��ԡ�
	    //Ȼ���ڲ����i-j֮��sum��ʱ��Ϳ���ʡȥѭ��i-j����͵Ĺ��̣�ֱ�Ӽ�arr[j]����
	//3��ʹ�÷ֶ���֮������������������ֱ���biggestsum&�Ժ���м����������biggestsum������Ƚ��鷳&��Ҳû�������д������
	//4��MOOCһ�������ڣ���һ�ڽ���1&2���ڶ��ڽ���3�����Ľ������ߴ�����ʵ�����Ƕ�����������˵��һ�α����Ľ��O(N)�������Ҽ�����Ľⷨ�������ģ�
}
