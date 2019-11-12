C++高校水电费管理系统（教师和学生）

#include<iostream>

\#include<string>

\#include<fstream>

\#include<iomanip>

static const int tmax = 50;  //数据最大容纳量

using namespace std;

class person {

public:

​	int id;    //编号或学号

​	int age;   //年龄

​	string name;   //姓名

​	string sex;    //性别



​	string pr;   //是否缴费变量

​	double water;  //用水量

​	double electric;  //用电量 

​	double waterfee; //水费

​	double electricfee; //电费

public:

​	person(int i=0, int a=0, string n=" ", string s=" ", string p = " ",double w=0.0, double e=0.0,double wf=0.0,double ef=0.0) {   //数据初始化

​		id = i;

​		age = a;

​		name = n;

​		sex = s;

​		pr = p;

​		water = w;

​		electric = e;

​		waterfee = wf;

​		electricfee = ef;

 

​	}

​	virtual void input() {};   //虚录入函数

​	int getid() { return id; };   //返回编号或学号

​	string getname() { return name; };  //返回姓名

​	string getpr() { return pr; };  //返回是否缴费信息

​	double rwater() { return water; };   //返回用水量

​	double relectric() { return electric; };  //返回用电量

};

class student :virtual public person {

public:

​	int sselects;

​	int sselectp;

​	string college; //学院

​	string major; //专业

public:

​	student(int i = 0, int a = 0, string n = " ", string s = " ",string p=" ", double w = 0.0, double e = 0.0,double wf=0.0,double ef=0.0,string c = " ", string m = " ") :person(i, a, n, s, p, w, e,wf,ef) {

​		college = c;

​		major = m;

​	}

​	void input() {

​		cout << "请输入学生学号：" << endl;

​		cin >> id;

​		cout << "请输入学生姓名：" << endl;

​		cin >> name;

​		cout << "请输入学生年龄：" << endl;



​		cin >> age;

​		cout << "请选择学生性别：" << endl;

​		cout << "1、男      2、女" << endl;

​		cin >> sselects;

​		switch (sselects)

​		{

​		case 1:sex = "男"; break;

​		case 2:sex = "女"; break;

​		default:cout << "输入错误" << endl;

​			break;

​		}

​		cout << "请输入学生所在学院：" << endl;

​		cin >> college;

​		cout << "请输入学生所学专业：" << endl;

​		cin >> major;

​		cout << "请输入该学生本月用水量：" << endl;

​		cin >> water;

​		if (water <= 1) {

​			waterfee = 0;

​		}

​		else waterfee = 5 * (water - 1);   //学生每月免费用水1吨，多出的部分按照每吨5元计算

​		cout << "请输入该学生本月用电量：" << endl;

​		cin >> electric;

​		if (electric <= 10) {

​			electricfee = 0;

​		}

​		else electricfee = 1.5 * (electric - 10); //学生每月免费用电10度，多出的部分按照每度1.5元计算

​		cout << "该用户是否已经缴费";

​		cout << "（已缴费请按1  未缴费请按2)" << endl;

​		cin >> sselectp;

​		switch (sselectp) {

​		case 1:pr = "已缴费"; break;

​		case 2:pr = "未缴费"; break;

​		default:cout << "输入错误，请重新输入！" << endl; break;

​		}

​	}

​	friend ostream& operator<<(ostream& os, const  student& s) {

​		os << left << " " << left << s.id << setw(15) << left << s.name << setw(15) << left << s.age << setw(15) << left << s.sex << setw(15) << left << s.college << setw(15) << left << s.major << setw(15) << left << s.water << setw(15) << left << s.electric << setw(15) << left << s.waterfee << setw(15) << left << s.electricfee << setw(15) << left << s.pr << endl;

​		return os;



​	} 

};

class teacher :virtual public person {

public:

​	int tselects;

​	int tselectd;

​	int tselectp;

​	string depart;  //教师所属部门

public:

​	teacher(int i = 0, int a = 0, string n = " ", string s = " ",string p=" ", double w = 0.0, double e = 0.0, double wf = 0.0, double ef = 0.0, string d=" ") :person(i, a, n, s, p, w, e, wf, ef) {

​		depart = d;

​	}

​	void input() {

​		cout << "请输入教师编号" << endl;

​		cin >> id;

​		cout << "请输入教师姓名：" << endl;

​		cin >> name;

​		cout << "请输入教师年龄：" << endl;

​		cin >> age;

​		cout << "请选择教师性别：" << endl;

​		cout << "1、男      2、女" << endl;

​		cin >> tselects;

​		switch (tselects)

​		{

​		case 1:sex = "男"; break;

​		case 2:sex = "女"; break;

​		default:cout << "输入错误" << endl;

​			break;

​		}

​		cout << "请选择教师所在部门：" << endl;

​		cout << "1、普通教师  2、教务处  3、财务处  4、行政部  5、大学生创业中心" << endl;

​		cin >> tselectd;

​		switch (tselectd) {

​		case 1:depart = "普通教师"; break;

​		case 2:depart = "教务处"; break;

​		case 3:depart = "财务处"; break;

​		case 4:depart = "行政部"; break;

​		case 5:depart = "大学生创业中心"; break;

​		default:cout << "输入错误" << endl; break;

​		}

​		cout << "请输入该教师本月用水量：" << endl;

​		cin >> water;

​		if (water <= 2) {

​			waterfee = 0;

​		}

​		else waterfee = 4 * (water - 2);   //教师每月免费用水2吨，多出的部分按每吨4元计算

​		cout << "请输入该教师本月用电量：" << endl; 

​		cin >> electric;

​		if (electric <= 10) {

​			electricfee = 0;

​		}

​		else electricfee = 1 * (electric - 10);  //教师每月免费用电10度，多出的部分按每度1元计算

​		cout << "该用户是否已经缴费";

​		cout << "（已缴费请按1  未缴费请按2)" << endl;

​		cin >> tselectp;

​		switch (tselectp) {

​		case 1:pr = "已缴费"; break;

​		case 2:pr = "未缴费"; break;

​		default:cout << "输入错误，请重新输入！" << endl; break;

​		}

​	}

​	friend ostream& operator<<(ostream& os, const  teacher& t) {

​		os << left << " " << left << t.id << setw(15) << left << t.name << setw(15) << left << t.age << setw(15) << left << t.sex << setw(15) << left << t.depart << setw(15) << left << t.water << setw(15) << left << t.electric << setw(15) << left << t.waterfee << setw(15) << left << t.electricfee << setw(15) << left << t.pr << endl;

​		return os;

​	}

 

 

};

class stu_manage{  //学生的相关类

​	student stu[tmax];

​	int max;  //指当前存储的数据个数

public:

​	stu_manage() { max = 0; }

​	void add();//添加函数

​	void display();//显示函数

​	void search();//查询函数

​	void change();//更改信息函数

​	void remove();//删除函数

​	void show();//输出未缴纳费用名单函数

​	void save();//将数据保存在文件中

​	void read();//将文件中的数据读取出来

};

void stu_manage::add() {

​	if (max > tmax) {

​		cout << "用户已满，请删除后添加！" << endl;

​		return;

​	}

​	student s;

​	cout << "请输入新添加人员信息" << endl;

​	s.input();

​	for (int i = 0; i < max; i++) {

​		if (s.getid() == stu[i].getid()) {

​			cout << "该用户已存在，请重新录入信息" << endl;

​			return;

​		}

​		if (s.getname() == stu[i].getname()) {

​			cout << "已存在同名用户,仍可继续添加！" << endl;

​		}

​	}

​	stu[max] = s;

​	max++;

​	cout << "人员添加成功" << endl;

}

void stu_manage::display() {

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	cout << left << " " << left << "学号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "学院" << setw(15) << left << "专业" << setw(15) << left << "用水量（吨）" << setw(15) << left << "用电量（度）" << setw(15) << left << "水费（元）" << setw(15) << left << "电费（元）" << setw(15) << left << "缴费状态" << endl;

​	for (int i = 0; i < max; i++) {

​		cout << stu[i] << endl;

​	}

​	

}

void stu_manage::search() {

​	if (max == 0) {

​		cout << "没有用户，请添加" << endl;

​		return;

​	}

​	int choice1;

​	string name;

​	int id;

​	cout << "根据姓名查询请按1  根据编号/学号查询请按2" << endl;

​	cin  >>  choice1;

​	switch (choice1)

​	{

​	case 1: {

​		cout << "请输入姓名" << endl;

​		cin >> name;

​		cout << left << " " << left << "学号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "学院" << setw(15) << left << "专业" << setw(15) << left << "用水量（吨）" << setw(15) << left << "用电量（度）" << setw(15) << left << "水费（元）" << setw(15) << left << "电费（元）" << setw(15) << left << "缴费状态" << endl;

​		for (int i = 0; i < max; i++) {

​			if (stu[i].getname() == name) {

​				cout << stu[i] << endl;

  

​			}

​			}

​		}break;

​	case 2: {

​		cout << "请输入学号" << endl;

​		cin >> id;

​		cout << left << " " << left << "学号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "学院" << setw(15) << left << "专业" << setw(15) << left << "用水量（吨）" << setw(15) << left << "用电量（度）" << setw(15) << left << "水费（元）" << setw(15) << left << "电费（元）" << setw(15) << left << "缴费状态" << endl;

​		for (int i = 0; i < max; i++) {

​			if (stu[i].getid() == id) {

​				cout << stu[i] << endl;

 

​			}

​		}

}break;

​	default:cout << "输入错误，请重新输入" << endl;

​		break;

​	}

}

void stu_manage::show() {

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	cout << "未缴费用户信息如下：" << endl;

​	cout << left << " " << left << "学号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "学院" << setw(15) << left << "专业" << setw(15) << left << "用水量（吨）" << setw(15) << left << "用电量（度）" << setw(15) << left << "水费（元）" << setw(15) << left << "电费（元）" << setw(15) << left << "缴费状态" << endl;

​	for (int i = 0; i < max; i++) {

​		if (stu[i].getpr() =="未缴费" ) {

​			cout << stu[i] << endl;

 

​		}

​	}

}

void stu_manage::change() {

​	person* p1;

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	int id;

​	cout << "请输入要查找的学生学号" << endl;

​	cin >> id;

​	for (int i = 0; i < max; i++) {

​		if (stu[i].getid() == id) {

​			cout << "请修改学生信息" << endl;

​			p1 = &stu[i];

​			p1->input();

​			cout << "修改成功" << endl;

​		}

​	}

}

void stu_manage::remove() {

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	cout << "按学号查找删除请按1  按姓名查找删除请按2" << endl;

​	int sselectr;

​	cin >> sselectr;

​	switch (sselectr) {

​	case 1: {

​		cout << "请输入学号" << endl;

​		int id;

​		cin >> id;

​		for (int i = 0; i < max; i++) {

​			if (stu[i].getid() == id) {

​				cout << "是否删除？（1、是 2、否）" << endl;

​				int sselecty;

​				cin >> sselecty;

​				switch (sselecty) {

​				case 1: {

​					for (int j = i; j < max - 1; j++)

​						stu[j] = stu[j + 1];

​					cout << "删除成功" << endl;

​					max=max-1;

​				}; break;

​				case 2: return;

​				default:cout << "输入错误，请重新输入" << endl; break;

​				}return;

​			}

​		}

​		

​	}; break;

​	case 2: {

​		cout << "请输入姓名" << endl;

​		string name;

​		cin >> name;

​		for (int i = 0; i < max; i++) {

​			if (stu[i].getname() == name) {

​				cout << "是否删除？（1、是 2、否）" << endl;

​				int sselectn;

​				cin >> sselectn;

​				switch (sselectn) {

​				case 1: {

​					for (int j = i; j < max - 1; j++)

​						stu[j] = stu[j + 1];

​					cout << "删除成功" << endl;

​					max=max-1;

​				}; break;

​				case 2: return;

​				default:cout << "输入错误，请重新输入" << endl; break;

​				}return;

​			}

​		}

​	}; break;

​	default:cout << "输入错误，请重新输入" << endl; break;

​	}

}

void stu_manage::save() {

​	ofstream out("学生.txt", ios::out);

​	if (!out) {

​		cout << "打开文件失败" << endl;

​		return;

​	}

​	cout << "打开成功" << endl;

​	for (int i=0; i < max; i++) {

​		out << stu[i].id <<	" " << stu[i].name << " " << stu[i].age << " " << stu[i].sex <<" " << stu[i].pr << " " << stu[i].water << " " << stu[i].electric << " " << stu[i].waterfee << " " << stu[i].electricfee << " " << stu[i].college << " " << stu[i].major << endl;

​	}

​	cout << "写入成功" << endl;

​	out.close();

}

void stu_manage::read() {

​	ifstream in("学生.txt", ios::in);

​	if (!in) {

​		cout << "文件读取失败！" << endl;

​		return;

​	}

​	int i = 0;

​	while (in >> stu[i].id >> stu[i].name >> stu[i].age >> stu[i].sex >> stu[i].pr >> stu[i].water >> stu[i].electric >> stu[i].waterfee >> stu[i].electricfee >> stu[i].college >> stu[i].major) {

​		i++;

​		max++;

​	}

​	cout << "文件读取成功!" << endl;

​	in.close();

}

class tea_manage {

​	teacher tea[tmax];

​	int max;  

public:

​	tea_manage() { max = 0; }

​	void add();//添加函数

​	void display();//显示函数

​	void search();//查询函数

​	void change();//更改信息函数

​	void remove();//删除函数

​	void show();//输出未缴纳费用名单函数

​	void save();//将数据保存在文件中

​	void read();//将文件中的数据读取出来

};

void tea_manage::add() {

​	if (max > tmax) {

​		cout << "用户已满，请删除后添加！" << endl;

​		return;

​	}

​	teacher t;

​	cout << "请输入新添加人员信息" << endl;

​	t.input();

​	for (int i = 0; i < max; i++) {

​		if (t.getid() == tea[i].getid()) {

​			cout << "该用户已存在，请重新录入信息" << endl;

​			return;

​		}

​		if (t.getname() == tea[i].getname()) {

​			cout << "已存在同名用户,仍可继续添加！" << endl;

​		}

​	}

​	tea[max] = t;

​	max++;

​	cout << "人员添加成功" << endl;

}

void tea_manage::display() {

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	cout << left << " " << left << "编号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "部门" << setw(15) << left << "用水量" << setw(15) << left << "用电量" << setw(15) << left << "水费" << setw(15) << left << "电费" << setw(15) << left << "缴费状态" << endl;

​	for (int i = 0; i < max; i++) {

​		cout << tea[i] << endl;

 

​	}

}

void tea_manage::search() {

​	if (max == 0) {

​		cout << "没有用户，请添加" << endl;

​		return;

​	}

​	int choice2;

​	string name;

​	int id;

​	cout << "根据姓名查询请按1  根据编号/学号查询请按2" << endl;

​	cin >> choice2;

​	switch (choice2)

​	{

​	case 1: {

​		cout << "请输入姓名" << endl;

​		cin >> name;

​		cout << left << " " << left << "编号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "部门" << setw(15) << left << "用水量" << setw(15) << left << "用电量" << setw(15) << left << "水费" << setw(15) << left << "电费" << setw(15) << left << "缴费状态" << endl;

​		for (int i = 0; i < max; i++) {

​			if (tea[i].getname() == name) {

​				cout << tea[i] << endl;

​			}

​		}

​	}

​			break;

​	case 2: {

​		cout << "请输入编号" << endl;

​		cin >> id;

​		cout << left << " " << left << "编号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "部门" << setw(15) << left << "用水量" << setw(15) << left << "用电量" << setw(15) << left << "水费" << setw(15) << left << "电费" << setw(15) << left << "缴费状态" << endl;

​		for (int i = 0; i < max; i++) {

​			if (tea[i].getid() == id) {

​				cout << tea[i] << endl;

​			}

 

​		}

​	}

​			break;

​	default:cout << "输入错误，请重新输入" << endl;

​		break;

​	}

}

void tea_manage::show() {

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	cout << "未缴费用户信息如下：" << endl;

​	cout << left << " " << left << "编号" << setw(15) << left << "姓名" << setw(15) << left << "年龄" << setw(15) << left << "性别" << setw(15) << left << "部门" << setw(15) << left << "用水量" << setw(15) << left << "用电量" << setw(15) << left << "水费" << setw(15) << left << "电费" << setw(15) << left << "缴费状态" << endl;

​	for (int i = 0; i < max; i++) {

​		if (tea[i].getpr() == "未缴费") {

​			cout << tea[i] << endl;

​		}

​	}

}

void tea_manage::change() {

​	person* p2;

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	int id;

​	cout << "请输入要查找的教师编号" << endl;

​	cin >> id;

​	for (int i = 0; i < max; i++) {

​		if (tea[i].getid() == id) {

​			cout << "请修改教师信息" << endl;

​			p2 = &tea[i];

​			p2->input();

​			cout << "修改成功" << endl;

​		}

​	}

}

void tea_manage::remove() {

​	if (max == 0) {

​		cout << "没有用户，请添加！" << endl;

​		return;

​	}

​	cout << "按编号查找删除请按1  按姓名查找删除请按2" << endl;

​	int tselectr;

​	cin >> tselectr;

​	switch (tselectr) {

​	case 1: {

​		cout << "请输入学号" << endl;

​		int id;

​		cin >> id;

​		for (int i = 0; i < max; i++) {

​			if (tea[i].getid() == id) {

​				cout << "是否删除？（1、是 2、否）" << endl;

​				int tselecty;

​				cin >> tselecty;

​				switch (tselecty) {

​				case 1: {

​					for (int j = i; j < max - 1; j++)

​						tea[j] = tea[j + 1];

​					cout << "删除成功" << endl;

​					max=max-1;

​				}; break;

​				case 2: return;

​				default:cout << "输入错误，请重新输入" << endl; break;

​				}return;

​			}

​		}

​	}; break;

​	case 2: {

​		cout << "请输入姓名" << endl;

​		string name;

​		cin >> name;

​		for (int i = 0; i < max; i++) {

​			if (tea[i].getname() == name) {

​				cout << "是否删除？（1、是 2、否）" << endl;

​				int tselectn;

​				cin >> tselectn;

​				switch (tselectn) {

​				case 1: {

​					for (int j = i; j < max - 1; j++) //所删除的非最后一项

​						tea[j] = tea[j + 1];  //将后一项的数据赋给前一项

​					cout << "删除成功" << endl;

​					max=max-1;

​				}; break;

​				case 2: return;

​				default:cout << "输入错误，请重新输入" << endl; break;

​				}return;

​			}

​		}

​	}; break;

​	default:cout << "输入错误，请重新输入" << endl; break;

​	}

}

void tea_manage::save() {

​	ofstream out("教师.txt", ios::out);

​	if (!out) {

​		cout << "打开文件失败" << endl;

​		return;

​	}

​	cout << "打开成功" << endl;

​	for (int i=0; i < max; i++) {

​		out << tea[i].id << " " << tea[i].name << " " << tea[i].age << " " << tea[i].sex << " " << tea[i].pr << " " << tea[i].water << " " << tea[i].electric << " " << tea[i].waterfee << " " << tea[i].electricfee << " " << tea[i].depart  << endl;

​	}

​	cout << "写入成功" << endl;

​	out.close();

}

void tea_manage::read() {

​	ifstream in("教师.txt", ios::in);

​	if (!in) {

​		cout << "文件读取失败！" << endl;

​		return;

​	}

​	int i = 0;

​	while (in >> tea[i].id >> tea[i].name >> tea[i].age >> tea[i].sex >> tea[i].pr >> tea[i].water >> tea[i].electric >> tea[i].waterfee >> tea[i].electricfee >> tea[i].depart ) {

​		i++;

​		max++;

​	}

​	cout << "文件读取成功!" << endl;

​	in.close();

}

void stumenu();

void teamenu();

int main()

{   

​	cout << setw(50) << "欢 迎 使 用 高 校 水 电 管 理 系 统" << endl;

​	cout << endl;

​	cout << endl;

​	int choice;

​	do {

​		cout << "*************************  1、学生水电管理系统  *************************" << endl;

​		cout << endl;

​		cout << "*************************  2、教师水电管理系统  *************************" << endl;

​		cout << endl;

​		cout << "*************************  0、退出系统          *************************" << endl;

​		cin >> choice;

​		switch (choice)

​		{

​		case 1:stumenu(); break;

​		case 2:teamenu(); break;

​		case 0:cout << "您已退出系统，感谢使用！" << endl; break;

​		default:cout << "输入错误，请重新输入" << endl;

​			break;

​		}

​	} while (choice != 0);

​		cout << "欢迎下次使用,再见!" << endl;

​		return 0;

}

void stumenu() {

​	stu_manage s;

​	int choice;

​	cout << "学生水电管理系统" << endl;

​	do{

​		cout << "\n" << endl;

​		cout << "<-------------------------  1、添加学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  2、显示学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  3、查询学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  4、更改学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  5、删除学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  6、显示未缴费名单  ----------------------->" << endl;

​		cout << "<-------------------------  7、保存学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  8、读取学生信息  ------------------------->" << endl;

​		cout << "<-------------------------  0、退出系统      ------------------------->" << endl;

​		cin >> choice;

​		switch (choice) {

​		case 1:s.add(); break;

​		case 2:s.display(); break;

​		case 3:s.search(); break;

​		case 4:s.change(); break;

​		case 5:s.remove(); break;

​		case 6:s.show(); break;

​		case 7:s.save(); break;

​		case 8:s.read(); break;

​		case 0: break;

​		default:cout << "输入错误，请重新输入" << endl; break;

​	}

​	} while (choice != 0);

}

void teamenu() {

​	tea_manage t;

​	int choice;

​	cout << "教师水电管理系统" << endl;

​	do{

​		cout << "\n" << endl;

​		cout << "<-------------------------  1、添加教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  2、显示教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  3、查询教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  4、更改教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  5、删除教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  6、显示未缴费名单  ----------------------->" << endl;

​		cout << "<-------------------------  7、保存教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  8、读取教师信息  ------------------------->" << endl;

​		cout << "<-------------------------  0、退出系统      ------------------------->" << endl;

​		cin >> choice;

​		switch (choice) {

​		case 1:t.add(); break;

​		case 2:t.display(); break;

​		case 3:t.search(); break;

​		case 4:t.change(); break;

​		case 5:t.remove(); break;

​		case 6:t.show(); break;

​		case 7:t.save(); break;

​		case 8:t.read(); break;

​		case 0:break;

​		default:cout << "输入错误，请重新输入" << endl; break;

​		}

​	} while (choice != 0);

}

 