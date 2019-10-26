#include"game.h"
void Menu()
{
	printf("***************************\n");
	printf("****    1、开始游戏    ****\n");
	printf("****    0、退出游戏    ****\n");
	printf("***************************\n");
}
void Game()
{
	char boom[ROWS][COLS] = { 0 };  //布雷棋盘
	char disboom[ROWS][COLS] = { 0 };  //显示排查出地雷的个数的棋盘
	InitBoard(boom, ROWS, COLS, '0');//重置的是11*11的棋盘
	InitBoard(disboom, ROWS, COLS, '*');
    //Display(boom, ROW, COL);  //显示的是9*9的棋盘
	Display(disboom, ROW, COL); 
	SetBoom(boom, ROW, COL); //设置雷也只在9*9中设置
	//Display(boom, ROW, COL);
	FindBoom(boom, disboom, ROW, COL);//排雷也是在9*9中排
}
void InitBoard(char board[ROWS][COLS], int rows, int cols,char set){
	int i = 0;
	int j = 0;
	for (i = 0; i < rows; i++){
		for (j = 0; j < cols; j++){
			board[i][j] = set;
		}
	}
}
void Display(char board[ROWS][COLS], int row, int col){
	int i = 0;
	int j = 0;
	for (i = 0; i <=col; i++){  //打印列号
		printf("%d ", i);  
	}
	printf("\n");
	for (i = 1; i <= row; i++){
		printf("%d ", i);  //打印行号
		for (j = 1; j <= col; j++){
			printf("%c ", board[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}
void SetBoom(char board[ROWS][COLS], int row, int col){
	int x = 0;
	int y = 0;
	int count = BOOM;
	while (count){
		x = rand() % row + 1;
		y = rand() % col + 1;
		if (board[x][y] == '0'){
			board[x][y] = '1';
			count--;
		}	
	}
}
int GetBoom(char board[ROWS][COLS],int X,int Y){
	return board[X - 1][Y] +
		board[X - 1][Y - 1] +
		board[X][Y - 1] +
		board[X + 1][Y - 1] +
		board[X + 1][Y] +
		board[X + 1][Y + 1] +
		board[X][Y + 1] +
		board[X - 1][Y + 1] - 8 * '0';
}
void FindBoom(char boom[ROWS][COLS], char disboom[ROWS][COLS], int row, int col)
{
	int X = 0;
	int Y = 0;
	while (1)
	{
		printf("请输入要排查的坐标:->\n");
		scanf("%d%d", &X, &Y);
		if (X >=1 && X <= row&&Y >=1 && Y <= col){
			if (boom[X][Y] == '1'){
				printf("您被炸死了！\n");
				Display(boom, row, col);
				break;
			}
			else{
				int count = GetBoom(boom,X,Y);
				disboom[X][Y] = count + '0';
				Display(disboom, row, col);
			}
		}
		else
			printf("输入错误请重新输入！\n");
	}
	
}
