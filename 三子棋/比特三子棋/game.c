#include"game.h"
void Menu()
{
	printf("*****************************\n");
	printf("****      1����ʼ��Ϸ    ****\n");
	printf("****      0���˳���Ϸ    ****\n");
	printf("*****************************\n");
}
void Game()
{
	char ret=' ';
	char board[ROW][COL] = { 0 };
	//ret = WinChecker(board, ROW, COL);
	srand((unsigned int)time(NULL));
	InitBoard(board, ROW, COL);
	DisplayBoard(board, ROW, COL);
	while (1){
		printf("��һغϣ�\n");
		Player(board, ROW, COL);
		DisplayBoard(board, ROW, COL);
		if (Judge(board, ROW, COL) == 'F'){ printf("��������\n"); break; }
		printf("���Իغ�! \n");
		Computer(board, ROW,COL);
		DisplayBoard(board, ROW, COL);
		if (Judge(board, ROW, COL) == 'F'){ printf("��������\n"); break; }
		ret = WinChecker(board, ROW, COL);
		if (ret == '*'){
			printf("���ʤ��!\n");
			break;
		}
		else if (ret == '#'){
			printf("����ʤ����\n");
			break;
		}
		if (Judge(board, ROW, COL) == 'F'){
			printf("ƽ�֣�\n");
			break;
		}


	}

	printf("��Ϸ������\n");

}
void InitBoard(char board[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++){
		for (j = 0; j < col; j++){
			board[i][j] = ' ';
		}
	}
}
void DisplayBoard(char board[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++){
		printf("- - -");
		printf("|");
	}
	printf("\n");
	for (i = 0; i < row; i++){
		for (j = 0; j < col; j++){
			printf("  %c  ", board[i][j]);
			  printf("|");
		}
		printf("\n");
		for (j = 0; j < col; j++){
			printf("- - -");
			printf("|");
		}
		printf("\n");
	}
}
void Player(char board[ROW][COL], int row, int col)
{
	int x = 0;
	int y = 0;
	while (1){
		printf("��������Ҫ���ӵ�����->\n");
		scanf("%d%d", &x, &y);
		if (x > 0 && x <= row&&y > 0 && y <= col){
			if (board[x - 1][y - 1] == ' '){
				board[x - 1][y - 1] = '*';
				break;
			}
			else{
				printf("��λ�÷ǿգ����������ӣ�\n");
			}

		}
		else{
			printf("����Ƿ������������룡\n");
		}

	}

}
void Computer(char board[ROW][COL], int row, int col)
{
	int x, y;
	while (1){
		x = rand() % ROW;
		y = rand() % COL;
		if (board[x][y] == ' '){
			board[x][y] = '#';
			break;
		}
	}    
}
char Judge(char board[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	int count = 0;
	for (i = 0; i < row; i++){
		for (j = 0; j < col; j++){
			if (board[i][j] != ' ')
				count = count + 1;
		}
	}
	if (count == ROW*COL){
		return 'F'; //����������F
	}
	else return 'E';   //δ������E
}
char WinChecker(char board[ROW][COL], int row, int col){
	int i = 0;
	for (i = 0; i < row; i++){
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' '){
			return board[i][0];
		}
	}
	for (i = 0; i < row; i++){
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' '){
			return board[0][i];
		}
	}
	if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){
		return board[0][0];
	}
	else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '){
		return board[0][2];
	}

}