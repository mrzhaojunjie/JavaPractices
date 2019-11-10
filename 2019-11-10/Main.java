class Person{ 
    //属性
	String name = " ";
	int age;
	
	
	//普通方法
	void sayhello(String target){
		System.out.println(age+" 岁的 "+name+" say hello to "+target);
	}
	public Person(){
		this.name = "秘密";
		this.age = -1;
	}
	//重载：构造器名称相同但参数不同
	public Person(String n,int age){
		this.name = n;
		this.age = age;
	}
}
public class Main{
	public static Person createPerson(String name, int age){
		Person p = new Person();
		p.name = name;
		p.age = age;
		return p;
	}
	public static void main(String[] args){	
		Person p = new Person("陈沛鑫",18);
		Person a = new Person();
		System.out.println(p.name);
		a.age = 20;
		a.name = "赵军杰";
		a.sayhello("这个世界");
		p.sayhello("汤众");
		
	}
	
}