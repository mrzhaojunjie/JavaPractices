两个多项式相加，若其所有指数相同，则将对应系数相加，若指数不同，则先插入指数较小的项到链表中

```
#include <stdio.h>
#include <stdlib.h>
#include<malloc.h>
typedef struct node{
	int coefficient; //系数
	int pointer;  //指数
	struct node* next; //next域
}node, *linklist;
void CreatNode(linklist *p, int n);
void PrintNode(linklist p);
int flag(linklist p1, linklist p2);
linklist AddNode(linklist pa, linklist pb);
void CreatNode(linklist *p, int n){  //创建结点
	linklist last, s;  
	*p = (linklist)malloc(sizeof(node));
	last = *p;
	for (int i = 0; i < n; i++){
		s = (linklist)malloc(sizeof(node));
		printf("请输入系数和指数：");
		scanf("%d%d", &s->coefficient, &s->pointer);
		last->next = s;
		last = s;
	}
	last->next = NULL;
}
void PrintNode(linklist p){
	linklist s;
	s = p->next;
	while (s){
		printf("%.2f  X^%d", s->coefficient, s->pointer);
		s = s->next;
		if (s != NULL){
			if (s->coefficient >= 0)
				printf("+");
		}
	}
	printf("\n");
}
int flag(linklist p1, linklist p2){
	if (p1->pointer < p2->pointer){
		return -1;
	}
	else if(p1->pointer == p2->pointer){
		return 0;
	}
	else if (p1->pointer>p2->pointer){
		return 1;
	}
}
linklist AddNode(linklist pa, linklist pb){
	linklist a, b, newnode, n;
	linklist s;
	a = pa->next;
	b = pb->next;
	newnode = (linklist)malloc(sizeof(node));
	float sum;
	n = newnode;
	while (a&&b){
		switch (flag(a,b))
		{
		case -1:
			s = (linklist)malloc(sizeof(node));
			s->coefficient = a->coefficient;
			s->pointer = a->pointer;
			n->next = s;
			n = s;
			a = a->next;
			break;
		case 0:
			sum = a->coefficient + b->coefficient;
			if (sum != 0){
				s = (linklist)malloc(sizeof(node));
				s->coefficient = sum;
				s->pointer = a->pointer;
				n->next = s;
				n = s;
			}
			break;
		case 1:
			s = (linklist)malloc(sizeof(node));
			s->coefficient = b->coefficient;
			s->pointer = b->pointer;
			n->next = s;
			n = s;
			b = b->next;
			break;
		default:
			break;
		}
	}
	while (a){
		s = (linklist)malloc(sizeof(node));
		s->coefficient = a->coefficient;
		s->pointer = a->pointer;
		n->next = s;
		n = s;
		a = a->next;
	}
	while (b){
		s = (linklist)malloc(sizeof(node));
		s->coefficient = b->coefficient;
		s->pointer = b->pointer;
		n->next = s;
		n = s;
		b = b->next;
	}
	n->next = NULL;
	return newnode;
}

int main(){
	linklist P1, P2;
	int l1, l2;
	printf("请输入第一个多项式的系数：-> ");
	scanf("%d", &l1);
	CreatNode(&P1, l1);
	printf("第一个多项式为：-> ");
	PrintNode(P1);
	printf("请输入第二个多项式的系数：-> ");
	scanf("%d", &l2);
	CreatNode(&P2, l2);
	printf("第二个多项式为：-> ");
	PrintNode(P2);
	printf("两个多项式相加结果为：->");
	PrintNode(AddNode(P1, P2));
	system("pause");
	return 0;
	
}
```

