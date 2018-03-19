package com.fivejoy.others;

import javax.print.attribute.standard.RequestingUserName;

public class MyUF {
	public int DATA=0,PARENT=1;
	public int[][] nums;
	
	
	//һ�ֹ��췽����ֱ�Ӵ����飬���ʼÿһ��Ԫ�ض���һ������
	public MyUF(int[] arr){
		nums=new int[2][];
		nums[DATA]=new int[arr.length];
		nums[PARENT]=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			nums[DATA][i]=arr[i];
			nums[PARENT][i]=-1;
		}
	}
	//��һ�����췽����Ӧ���Ǵ���һ����ά���������ӣ�����������
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
		//ѭ����nums[DATA][i]�ҵ�m��
      //���nums[PARENT][i]=-1��ʾ�Ǹ�����i����������顾parent��¼����������������Ǹ������Ǹ���ֵk,��ô��Ӧ����nums[DATA][k]��λ�á�
	return 0;
	//����������У�ע�⣬����ʹ��nowcoder�ķ���������ʹ��ѭ�����������õݹ飬ֱ���ҵ�parent=-1��ʱ�򣬽�index���ϸ�ֵ�������ɡ���Ϊ�ݹ���еĹ����л�ѵ��ù�����ѹջ
	//��ʱ����ǣ�����ջ��Ҳ������ײ����������˳��Ժ�͵õ���root��ֵ���ɡ���
	//nowcoder������������hashmap��һ���Ǽ�¼node&father,һ���Ǽ�¼node&���������о��е�ûɶ��Ҫ�ĸо������Ƕ����� ��
	}
	public void union(int m,int n){
		int mrI=findRootIndex(m);
		int nrI=findRootIndex(n);
		//�������򲻱�union
		//���ȵĻ�����һ����parent������һ�����ɡ�
		//�������һ���Ż����ܹ���һ����Ŀ�ܹ���ʾ������ϵĸ�����parent=-1��ʾ��,parentΪ����ʾ���Ǹ�����Ҫ�����顿
		//����Ϊparent=��ֵ��ʾ������ֵ��ʾ���Ǹ������Ǹ�ֵ��ʱ�������ֵ���ǵ�ǰ���ϵ���Сֵ��
	}
}
