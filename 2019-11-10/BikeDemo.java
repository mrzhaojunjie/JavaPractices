// class Bike{
	// private String color;
	// private int speed = 0;
	// private int maxSpeed = 100;
	// void addspeed(){
		// if(speed<=maxSpeed){
			// speed += 10;
		// }
	// }
	// void subspeed(){
		// if(speed>=0){
			// speed -= 10;
		// }
	// }
	// String getcolor(){
		// return color;
	// }
	// int getspeed(){
		// return speed;
	// }
	
// }
/* class Book{
	private String name;  //书名
	private String authorName; //作者名字
	private double price;  //价格
	private String publishPlace;//出版社
	void setterAuthorName(String an){
		this.authorName = an;
	}
	void setterName(String n){
		this.name = n;
	}
	void setterPrice(double p){
		this.price = p;
	}
	void setterPublishPlace(String pp){
		this.publishPlace = pp;
	}
	double count(double discount){
		return this.price*discount;
	}
	void show(){
		System.out.println("书名："+name);
		System.out.println("作者："+authorName);
		System.out.println("价格："+price);
		System.out.println("出版社："+publishPlace);
	} 
	
}*/
class Book(String name,String authorName,double price,String publishPlace){
	private String name;  //书名
	private String authorName; //作者名字
	private double price;  //价格
	private String publishPlace;//出版社
	void setterAuthorName(String an){
		this.authorName = an;
	}
	void setterName(String n){
		this.name = n;
	}
	void setterPrice(double p){
		this.price = p;
	}
	void setterPublishPlace(String pp){
		this.publishPlace = pp;
	}
	double count(double discount){
		return this.price*discount;
	}
	//构造方法
	@override //覆写一个方法  //不覆写的话直接打印对象为哈希码
	public String toString(){
		return String.format("《%s》by %s 的价格为 %lf,打折后的价格为 %lf 它是%s出版的",name,authorName,price,count,publishPlace);
	}

	
	
}
public class BikeDemo{
	public static void main(String[] args){
		Book book1 = new Book("钢铁是怎样炼成的","奥斯特洛夫斯基",50.8，"商务出版社");
		System.out.println(book1);
		// Book b = new Book();
		// b.setterAuthorName("陈沛鑫");
		// b.setterName("《怎样讨富婆欢心》");
		// b.setterPrice(50);
		// b.setterPublishPlace("bit出版社");
		// b.show();
		// System.out.println(b.count(0.8)); *///打八折后的价格
		
		// Bike b = new Bike();
		// b.color = "red";
		// b.speed = 20;
		// System.out.println("自行车当前速度为 "+b.getspeed()+" 颜色为 "+b.getcolor());
		// b.addspeed();
		// System.out.println("自行车当前速度为 "+b.getspeed()+" 颜色为 "+b.getcolor());
		
	}
}