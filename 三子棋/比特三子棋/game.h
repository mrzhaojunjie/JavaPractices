#define _CRT_SECURE_NO_WARNINGS
#define ROW 3
#define COL 3
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
void Menu();//���˵�����
void Game();//��Ϸ��ʼ����
void InitBoard(char board[ROW][COL], int row, int col);//�ÿ����̺���
void DisplayBoard(char board[ROW][COL], int row, int col);//��ʾ���̺���
void Player(char board[ROW][COL], int row, int col);//������庯��
void Computer(char board[ROW][COL], int row, int col);// �������庯��
char Judge(char board[ROW][COL], int row, int col);//�����ж�����
char WinChecker(char board[ROW][COL], int row, int col);//ʤ���ж�����
