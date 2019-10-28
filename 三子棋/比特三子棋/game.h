#define _CRT_SECURE_NO_WARNINGS
#define ROW 3
#define COL 3
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
void Menu();//主菜单函数
void Game();//游戏开始函数
void InitBoard(char board[ROW][COL], int row, int col);//置空棋盘函数
void DisplayBoard(char board[ROW][COL], int row, int col);//显示棋盘函数
void Player(char board[ROW][COL], int row, int col);//玩家走棋函数
void Computer(char board[ROW][COL], int row, int col);// 电脑走棋函数
char Judge(char board[ROW][COL], int row, int col);//棋盘判定函数
char WinChecker(char board[ROW][COL], int row, int col);//胜负判定函数
