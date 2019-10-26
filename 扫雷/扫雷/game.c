#include"game.h"
void Menu()
{
	printf("***************************\n");
	printf("****    1����ʼ��Ϸ    ****\n");
	printf("****    0���˳���Ϸ    ****\n");
	printf("***************************\n");
}
void Game()
{
	char boom[ROWS][COLS] = { 0 };  //��������
	char disboom[ROWS][COLS] = { 0 };  //��ʾ�Ų�����׵ĸ���������
	InitBoard(boom, ROWS, COLS, '0');//���õ���11*11������
	InitBoard(disboom, ROWS, COLS, '*');
    //Display(boom, ROW, COL);  //��ʾ����9*9������
	Display(disboom, ROW, COL); 
	SetBoom(boom, ROW, COL); //������Ҳֻ��9*9������
	//Display(boom, ROW, COL);
	FindBoom(boom, disboom, ROW, COL);//����Ҳ����9*9����
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
	for (i = 0; i <=col; i++){  //��ӡ�к�
		printf("%d ", i);  
	}
	printf("\n");
	for (i = 1; i <= row; i++){
		printf("%d ", i);  //��ӡ�к�
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
		printf("������Ҫ�Ų������:->\n");
		scanf("%d%d", &X, &Y);
		if (X >=1 && X <= row&&Y >=1 && Y <= col){
			if (boom[X][Y] == '1'){
				printf("����ը���ˣ�\n");
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
			printf("����������������룡\n");
	}
	
}
