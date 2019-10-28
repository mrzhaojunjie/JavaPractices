#include"game.h"
int main()
{
	int input = 0;
	do
	{
		Menu();  //主菜单显示函数
		printf("请选择：->\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			Game();   //游戏开始函数
			break;
		case 0:
			printf("退出游戏!\n");
			break;
		default:
			printf("输入错误，请重新输入！\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}