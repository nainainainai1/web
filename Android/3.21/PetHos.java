package day0321;
//宠物医院
public class PetHos {
	//看病的功能
	/*public void cureDog(Dog d) {
		System.out.println("cureDog:"+d.name);
	}
	public void cureBird(Bird d) {
		System.out.println("cureBird:"+d.name);
	}*/
	
	//使用多态：父类的引用指向子类的对象
	public void curePet(Aminal d) {
		d.cure();
	}
	//多态：要体现子类的特殊的行为特征
	//多态就是父类的引用指向子类的对象，在调用方法的时候会体现出子类的行为特征
	public static void main(String[] args) {
		PetHos p = new PetHos();
		//Cat cat = new Cat();
		//p.curePet(cat);
		Dog d = new Dog();
		p.curePet(d);
	}
	
}
