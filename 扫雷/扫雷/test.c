#include"game.h"
int main()
{
	srand((unsigned int)time(NULL));
	int input = 0;
	do{
		Menu();
		printf("请选择->:\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			Game();
			break;
		case 0:
			printf("退出游戏！\n");
			break;
		default:
			printf("输入错误，请重新输入！\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}