package day0321;
//����ҽԺ
public class PetHos {
	//�����Ĺ���
	/*public void cureDog(Dog d) {
		System.out.println("cureDog:"+d.name);
	}
	public void cureBird(Bird d) {
		System.out.println("cureBird:"+d.name);
	}*/
	
	//ʹ�ö�̬�����������ָ������Ķ���
	public void curePet(Aminal d) {
		d.cure();
	}
	//��̬��Ҫ����������������Ϊ����
	//��̬���Ǹ��������ָ������Ķ����ڵ��÷�����ʱ������ֳ��������Ϊ����
	public static void main(String[] args) {
		PetHos p = new PetHos();
		//Cat cat = new Cat();
		//p.curePet(cat);
		Dog d = new Dog();
		p.curePet(d);
	}
	
}
