C语言学生成绩管理系统

#include<stdio.h>
#include<string.h>
#include<math.h> 
struct student    /*定义结构体student并定义学生学号，姓名，数学，英语，C语言程序设计成绩等数据*/
{
	long int num;
	char name[20];
	float math;
    float english;
	float Cyuyan;
	int sum;
};
int n=0;  /*n表示学生总数*/ 
struct student stu[100]; /*定义结构体类型的数组 长度为100*/ 
struct student *p;  /*定义结构体类型的指针*/ 
void luru();    /*定义录入，查看，查询，更改，删除，排序，插入等函数，并且实现操作*/ 
void chakan();
void chaxun();
void genggai();
void shanchu();
void paixu();
void charu();
void findmax();


int main()  /*主体函数*/ 
{ 
	int a;
	do{        /*用do while循环结构实现选择*/ 
	printf("-------------------------------------------------\n");
	printf("            欢迎使用最厉害的学生成绩管理系统     \n"); 
	printf("             请从以下选项中选取一项              \n");
	printf("               录入学生成绩请按 1                \n");
	printf("               显示学生成绩请按 2                \n");
	printf("               查询学生成绩请按 3                \n");
	printf("               更改学生成绩请按 4                \n");
	printf("               删除学生成绩请按 5                \n");
	printf("             由学号从小到大排序请按 6            \n");
	printf("               插入学生成绩请按 7                \n");
	printf("          查看各科最高分和不及格人数请按 8       \n");
	printf("                退出系统请按 0                    \n");
	printf("-------------------------------------------------\n");
	printf("请选择：\n");
	scanf("%d",&a);
	printf("\n");
	switch(a)     /*用switch开关语句实现多分支选择*/ 
	{
		case 0:break;
		case 1: luru();break;
		case 2: chakan();break;
		case 3: chaxun();break;
		case 4: genggai();break;
		case 5:shanchu();break;
		case 6:paixu();break;
		case 7:charu();break;
		case 8:findmax();break;
	    
		default:printf("您输入有误，请重新输入\n");		
	}	
   }
   while(a!=0);

}

void luru()     /*录入函数*/ 
{
	int b;     /*实现循环所用变量*/ 
	if(n==0)    /*n==0是开始的标志*/ 
	p=stu;     /*指针指向stu数组的首地址 并使用链表接收成绩*/ 
	
	do{
	printf("------------------录入您的相关信息-----------------\n");
	printf("请输入您的学号:\n");
	scanf("%ld",&p->num);
	printf("请输入您的姓名:\n");
	scanf("%s",p->name);
	printf("请输入您的数学成绩:\n");
	scanf("%f",&p->math);
	printf("请输入您的英语成绩:\n");
	scanf("%f",&p->english);
	printf("请输入您的c语言成绩:\n");
	scanf("%f",&p->Cyuyan);
	p->sum=(int)p->math+(int)p->english+(int)p->Cyuyan; /*使用强制转换将float类型转换为int类型并进行总成绩计算*/ 
	n++;p++;
	printf("\n");
	printf("继续输入请按 1 终止输入请按 0\n");
	scanf("%d",&b);
}
while(b==1);
}

void chakan()  /*查看函数*/ 
{
	int i;
	if(n!=0){
		printf("共有%d个学生\n",n);
		printf("\n学号\t姓名\t数学成绩\t英语成绩\tC语言成绩\t总成绩\n");
		for(i=0;i<n;i++)  /*用for循环输出学生的相关信息*/ 
		printf("\n%ld\t%s\t%f\t%f\t%f\t%d\n",stu[i].num,stu[i].name,stu[i].math,stu[i].english,stu[i].Cyuyan,stu[i].sum);
	}
	else printf("查无此人，请重新录入您的相关信息\n");
}

void chaxun() /*查询函数*/ 
{
	int i;
	int h;
    int c;
    char name[20];  /*定义新的name字符变量，是按姓名查询的变量*/ 
    if(n!=0){
    	
    	do{
    		printf("请选择您的查询方式:\n");
    		printf("--------------------------------------------------------\n");
    		printf("按学号查询请输入  1\n");
    		printf("按姓名查询请输入  2\n");
    		printf("取消查询请输入  0\n");
    		printf("--------------------------------------------------------\n");
    		printf("请选择：\n");
    		scanf("%d",&c); 
    		printf("\n");
    	
    	switch(c) /*用switch开关语句实现多分支选择结构*/ 
    	{
    		case 0:break;
    		case 1:printf("请输入学号：\n");
    		       scanf("%ld",&h);
    		       for(i=0;i<n;i++)
    		       if(stu[i].num==h){
    		       	printf("\n学号\t姓名\t数学成绩\t英语成绩\tC语言成绩\t总成绩\n");
    		       	printf("\n%ld\t%s\t%f\t%f\t%f\t%d\n",stu[i].num,stu[i].name,stu[i].math,stu[i].english,stu[i].Cyuyan,stu[i].sum);
    		       	printf("\n");
    			   }break;
    		case 2:printf("请输入姓名：\n");
    		       scanf("%s",&name);
    		       for(i=0;i<n;i++)
    		       if(strcmp(name,stu[i].name)==0){
    		       	printf("\n姓名\t学号\t数学成绩\t英语成绩\tC语言成绩\t总成绩\n");
    		       	printf("\n%s\t%ld\t%f\t%f\t%f\t%d\n",stu[i].name,stu[i].num,stu[i].math,stu[i].english,stu[i].Cyuyan,stu[i].sum);
    		       	printf("\n");
    			   }break;
    		default:printf("查无此人，请重新输入学号或姓名\n");
    		break;
    		                                    
    	}
    }while(c!=0);

}
else printf("\n输入错误，请重新选择！\n");
}

void genggai() /*更改函数*/ 
{
	long int num; /*定义新的num变量，是根据学号更改信息时的变量*/ 
	int i;
	int e;        /*分支选择的变量*/ 
	int f=1;     /*更改后的信息插入结构体时需要的变量*/ 
	if(n!=0){
		printf("请输入需要更改成绩的学生学号：\n");
		scanf("%ld",&num);
		for(i=0;i<n;i++)
		if(stu[i].num==num)	
		do{
			printf("请输入需要更改学生的相关信息：\n");
			printf("-------------------------------------------------------\n");
			printf("取消本次操作请按 0\n");
			printf("更改学生学号请按 1\n");
			printf("更改学生姓名请按 2\n");
			printf("更改数学成绩请按 3\n");
			printf("更改英语成绩请按 4\n");
			printf("更改C语言成绩请按 5\n");
			printf("--------------------------------------------------------\n");
			printf("请选择：\n");
			scanf("%d",&e); 
			printf("\n");
	
		switch (e)
		{
		case 0:    break;
		case 1:printf("请输入更改后的学生学号：\n");
		       scanf("%ld",&stu[f].num);
		       break;
	    case 2:printf("请输入更改后的学生姓名：\n");
		       scanf("%s",&stu[f].name);
			   break;
		case 3:printf("请输入更改后的数学成绩：\n");
		       scanf("%f",&stu[f].math);
			   break;
		case 4:printf("请输入更改后的英语成绩：\n");
		       scanf("%f",&stu[f].english);
			   break;
	    case 5:printf("请输入更改后的C语言成绩：\n");
		       scanf("%f",&stu[f].Cyuyan);
			   break;
		default:printf("您的输入有误，请重新选择!\n");
		       break;
	}
	}
	while(e!=0);
}else printf("无该学生信息，请重新输入！\n");
}

void shanchu() /*删除函数*/ 
{
	long int num;
	int i,j;
	if(n!=0){
		printf("-------------------------------------------------------\n");
		printf("\n学号\t姓名\t数学成绩\t英语成绩\tC语言成绩\t总成绩\n");
		for(i=0;i<n;i++)
		printf("\n%ld\t%s\t%f\t%f\t%f\t%f\n",stu[i].num,stu[i].name,stu[i].math,stu[i].english,stu[i].Cyuyan,stu[i].sum);
		printf("-------------------------------------------------------\n");
		printf("请输入要删除的学生学号：\n");
		scanf("%ld",&num);
		for(i=0;i<n;i++)
		if(num==stu[i].num)
		j=i;  
		if(j!=(n-1)) 
		{
		
			
			
			stu[j].num=stu[j+1].num;
			strcpy(stu[j].name,stu[j+1].name); /*使用strcpy函数将字符串前一项的值赋给后一项 */ 
			stu[j].math=stu[j+1].math;
			stu[j].english=stu[j+1].english;
			stu[j].Cyuyan=stu[j+1].Cyuyan;
			n--;
			
		}else n--;
		printf("已删除！\n");
		
	}	else printf("输入错误，请重新输入\n");
}



void paixu()  /*按学号从小到大排序输出*/ 
{
	int i,j;
	struct student temp;  /*定义结构体中间变量*/ 
	for(i=0;i<n;i++) /*使用双层循环进行排序*/ 
	{	
	for(j=n-1;j>i;j--)
	{
	
		if(stu[j].num<stu[j-1].num)
		{
			temp=stu[j];
			stu[j]=stu[j-1];
			stu[j-1]=temp;
		}
	}
	if(n!=0){
		printf("-------------------------------------------------------\n");
		printf("\n学号\t姓名\t数学成绩\t英语成绩\tC语言成绩\t总成绩\n");
		for(i=0;i<n;i++)
		printf("\n%ld\t%s\t%f\t%f\t%f\t%f\n",stu[i].num,stu[i].name,stu[i].math,stu[i].english,stu[i].Cyuyan,stu[i].sum);
		printf("-------------------------------------------------------\n");
		printf("\n");
				
	       }
	}
}

void charu() /*插入*/ 
{
	int k;  /*定义插入的学生序号所用变量*/ 
	int q;
	if(n!=0)
	do{
	printf("------------------录入插入学生的相关信息-----------------\n");
	printf("请输入插入的学生学号：\n");
	scanf("%ld",&stu[k].num);
	printf("请输入学生的姓名:\n");
	scanf("%s",stu[k].name);
	printf("请输入插入的学生数学成绩：\n");
	scanf("%f",&stu[k].math);
	printf("请输入插入的学生英语成绩：\n");
	scanf("%f",&stu[k].english);
	printf("请输入插入的学生C语言成绩：\n");
	scanf("%f",&stu[k].Cyuyan);
	stu[k].sum=stu[k].math+stu[k].english+stu[k].Cyuyan;
	n++;k++;
	printf("已插入该学生成绩！"); 
	printf("\n");
	printf("继续输入请按 1    输入完毕请按 0\n");
	scanf("%d",&q);
	
      }while(q==1);

}

void findmax() /*查看各科最高分并输出各科不及格人数*/ 
{
	int i,j;
	float mmax=stu[0].math;
	float emax=stu[0].english;
	float Cmax=stu[0].Cyuyan;
	int mout=0;
	int eout=0;
	int Cout=0;
	for(i=0;i<n;i++)
	{
			if(mmax<stu[i].math) /*比较前后两项的大小并且把最大值赋给所定义的变量mmax*/ 
			{mmax=stu[i].math;}
			if(emax<stu[i].english)
			{emax=stu[i].english;}
			if(Cmax<stu[i].Cyuyan)
			{Cmax=stu[i].Cyuyan;}
			if(stu[i].math<60)
			{mout=mout+1;}  /*如果成绩低于60则变量+1*/ 
			if(stu[i].english<60)
			{eout=eout+1;}
			if(stu[i].Cyuyan<60)
			{Cout=Cout+1;}
    }

		if(n!=0){
		printf("-------------------------------------------------------\n");
		printf("\n学号\t姓名\t数学成绩\t英语成绩\tC语言成绩\t总成绩\n");
		for(i=0;i<n;i++)
		printf("\n%ld\t%s\t%f\t%f\t%f\t%d\n",stu[i].num,stu[i].name,stu[i].math,stu[i].english,stu[i].Cyuyan,stu[i].sum);
		printf("-------------------------------------------------------\n");
		printf("\n数学最高分为 %f\t英语最高分为 %f\tC语言最高分为 %f\n",mmax,emax,Cmax);
		printf("-------------------------------------------------------\n");
		printf("\n数学不及格人数为 %d 个\t英语不及格人数为 %d 个\tC语言不及格人数为 %d 个\n",mout,eout,Cout);
		printf("\n");
		       }
}