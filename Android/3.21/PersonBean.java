package day0321;
//һ����׼��java��Ķ���
public class PersonBean {
	//1��˽�л��Č���
	private String name;
	private String sex;
	private double height;
	//2���ṩ���л���get��set����
	//������ɷ�ʽ���Ҽ�--��source--��generate getters and setters
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
	
	//this��ʾ��ǰ���������
	//this1���������ֳ�Ա���������ԣ����β�
	//this2����һ����������ֱ�ӵ�������һ���������߳�Ա����ʵ����ȱʡ��this.
	public void test1() {
		System.out.println("test1");
	}
	public void test2() {
		System.out.println(this.name);
		this.test1();
	}
	//3���ṩ�Ѕ��͟o����������
	//������ɷ�ʽ���Ҽ�--��source--��generate constrtor using fileds
	//�вι���
	public PersonBean(String name, String sex, double height) {
		super();
		this.name = name;
		this.sex = sex;
		this.height = height;
	}
	//�޲���������
	public PersonBean() {
		super();
	}
	//4��toString����
	//������ɷ�ʽ���Ҽ�--��source--��generate toString
	@Override//���ڹ۲���������
	public String toString() {
		return "PersonBean [name=" + name + ", sex=" + sex + ", height=" + height + "]";
	}
	public static void main(String[] args) {
		//PersonBean p = new PersonBean("xiaoming","male",1.69);
		PersonBean p = new PersonBean();
		System.out.println(p);
	}
}
