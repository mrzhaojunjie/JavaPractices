#define _CRT_SECURE_NO_WARNINGS 1
#define ROW 9   
#define COL 9
#define ROWS ROW+2
#define COLS COL+2
#define BOOM 10
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void Menu();
void Game();
void InitBoard(char board[ROWS][COLS], int rows, int cols, char set);
void Display(char board[ROWS][COLS], int row, int col);
void SetBoom(char board[ROW][COL],int row, int col);
void FindBoom(char boom[ROWS][COLS], char disboom[ROWS][COLS], int row, int col);
