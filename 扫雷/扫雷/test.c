#include"game.h"
int main()
{
	srand((unsigned int)time(NULL));
	int input = 0;
	do{
		Menu();
		printf("��ѡ��->:\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			Game();
			break;
		case 0:
			printf("�˳���Ϸ��\n");
			break;
		default:
			printf("����������������룡\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}