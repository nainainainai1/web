package day0321;
//子类通过继承父类,通过extends关键字来继承某一个类
//java能不能多继承？不可以,只能单继承
public class Dog extends Aminal{
	//方法重写是存在于继承链当中
	//两同（方法名、参数列表一致） 
	//两小或等（返回值类型、抛出的异常）
	//一大或等（权限修饰符）
	//方法的重写来体现子类的行为特征
	public void eat() {
		System.out.println("Dog eat 骨头");
	}
	//提供一个方法用于调用父类的eat方法
	//super表示当前的父类对象的引用
	public void superMethod() {
		super.eat();
		System.out.println("superClazz="+super.clazz);
	}
	
	//方法的重载:同一个类中的同一种行为的不同的实现方式
	//方法的重载存在于同一个类中
	public void eat(String food) {
		System.out.println("Dog eat "+food);
	}
	
}
