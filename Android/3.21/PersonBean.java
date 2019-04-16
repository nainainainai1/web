package day0321;
//一个标准的java类的定义
public class PersonBean {
	//1、私有化的屬性
	private String name;
	private String sex;
	private double height;
	//2、提供公有化的get、set方法
	//快捷生成方式：右键--》source--》generate getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//this表示当前对象的引用
	//this1、用于区分成员变量（属性）和形参
	//this2、在一个方法里面直接调用另外一个方法或者成员变量实质上缺省了this.
	public void test1() {
		System.out.println("test1");
	}
	public void test2() {
		System.out.println(this.name);
		this.test1();
	}
	//3、提供有參和無參數构造器
	//快捷生成方式：右键--》source--》generate constrtor using fileds
	//有参构造
	public PersonBean(String name, String sex, double height) {
		super();
		this.name = name;
		this.sex = sex;
		this.height = height;
	}
	//无参数构造器
	public PersonBean() {
		super();
	}
	//4、toString方法
	//快捷生成方式：右键--》source--》generate toString
	@Override//用于观察对象的数据
	public String toString() {
		return "PersonBean [name=" + name + ", sex=" + sex + ", height=" + height + "]";
	}
	public static void main(String[] args) {
		//PersonBean p = new PersonBean("xiaoming","male",1.69);
		PersonBean p = new PersonBean();
		System.out.println(p);
	}
}
