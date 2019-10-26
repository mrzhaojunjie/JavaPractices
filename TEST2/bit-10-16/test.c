#define _CRT_SECURE_NO_WARNINGS 1
//写一个函数返回参数二进制中 1 的个数
//比如： 15 0000 1111 4 个 1
//程序原型：
#include<stdio.h>
#include<stdlib.h>
//int count_one_bits(unsigned int value)
//{
//	int count = 0;
//	while (value){
//		if (value % 2 == 1){
//			count++;
//		}
//		value = value / 2;
//	}// 返回 1的位数 
//	return count;
//}
//int main()
//{
//	unsigned int n = 0;
//	int ret = 0;
//	printf("请输入一个数：->\n");
//	scanf("%d", &n);
//	ret = count_one_bits(n);
//	printf("该参数二进制中的1的个数为： %d\n", ret);
//	system("pause");
//	return 0;
//
//}
//2.获取一个数二进制序列中所有的偶数位和奇数位，
//分别输出二进制序列。
//int main()
//{
//	int i = 0;
//	int n = 0;
//	int tmp;
//	printf("请输入一个数：->\n");
//	scanf("%d", &n);
//	printf("奇数位是：\n");
//	for (i = 31; i >= 0; i = i - 2){   //int类型为32位 
//		tmp = (n >> i) & 1;  //从31位开始向右移31位再与上1可得第一位   每次变化2位
//		printf("%d ", tmp);
//	}
//	printf("\n");
//	printf("偶数位是：\n");
//	for (i = 30; i >= 0; i = i - 2){  //从30位开始移动再与上1可得第二位
//		tmp = (n >> i) & 1;
//		printf("%d ", tmp);
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}

//3. 输出一个整数的每一位。
//void print(unsigned int n){
//	if (n <= 9){
//		printf("%d", n);
//	}
//	else
//	{
//		printf("%d ", n % 10);
//		print(n / 10);
//	}
//}
//int main()
//{
//		unsigned int n = 0;
//		printf("请输入一个数：->\n");
//		scanf("%d", &n);
//		print(n);
//	    system("pause");
//	    return 0;
//}
//
//4.编程实现：
//两个int（32位）整数m和n的二进制表达中，有多少个位(bit)不同？
//输入例子 :
//1999 2299
//输出例子 : 7
//int campare(int m, int n){
//	int count = 0;
//	while (1){
//	if (m % 2 != n % 2){
//		count++;
//	}
//	m = m / 2;
//	n = n / 2;
//	if (n<1){
//			break;
//		}
//	}
//	return count;
//}
//int main(){
//	int m = 0;
//	int n = 0;
//	printf("请输入两个整数：->\n");
//	scanf("%d%d", &m, &n);
//	int ret = campare(m, n);
//	printf("该两个函数有 %d 个位不同\n", ret);
//	system("pause");
//	return 0;
//}

