#define _CRT_SECURE_NO_WARNINGS 1
//дһ���������ز����������� 1 �ĸ���
//���磺 15 0000 1111 4 �� 1
//����ԭ�ͣ�
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
//	}// ���� 1��λ�� 
//	return count;
//}
//int main()
//{
//	unsigned int n = 0;
//	int ret = 0;
//	printf("������һ������->\n");
//	scanf("%d", &n);
//	ret = count_one_bits(n);
//	printf("�ò����������е�1�ĸ���Ϊ�� %d\n", ret);
//	system("pause");
//	return 0;
//
//}
//2.��ȡһ�������������������е�ż��λ������λ��
//�ֱ�������������С�
//int main()
//{
//	int i = 0;
//	int n = 0;
//	int tmp;
//	printf("������һ������->\n");
//	scanf("%d", &n);
//	printf("����λ�ǣ�\n");
//	for (i = 31; i >= 0; i = i - 2){   //int����Ϊ32λ 
//		tmp = (n >> i) & 1;  //��31λ��ʼ������31λ������1�ɵõ�һλ   ÿ�α仯2λ
//		printf("%d ", tmp);
//	}
//	printf("\n");
//	printf("ż��λ�ǣ�\n");
//	for (i = 30; i >= 0; i = i - 2){  //��30λ��ʼ�ƶ�������1�ɵõڶ�λ
//		tmp = (n >> i) & 1;
//		printf("%d ", tmp);
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}

//3. ���һ��������ÿһλ��
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
//		printf("������һ������->\n");
//		scanf("%d", &n);
//		print(n);
//	    system("pause");
//	    return 0;
//}
//
//4.���ʵ�֣�
//����int��32λ������m��n�Ķ����Ʊ���У��ж��ٸ�λ(bit)��ͬ��
//�������� :
//1999 2299
//������� : 7
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
//	printf("����������������->\n");
//	scanf("%d%d", &m, &n);
//	int ret = campare(m, n);
//	printf("������������ %d ��λ��ͬ\n", ret);
//	system("pause");
//	return 0;
//}

