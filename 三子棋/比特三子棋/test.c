#include"game.h"
int main()
{
	int input = 0;
	do
	{
		Menu();  //���˵���ʾ����
		printf("��ѡ��->\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			Game();   //��Ϸ��ʼ����
			break;
		case 0:
			printf("�˳���Ϸ!\n");
			break;
		default:
			printf("����������������룡\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}