package day0321;
//����ͨ���̳и���,ͨ��extends�ؼ������̳�ĳһ����
//java�ܲ��ܶ�̳У�������,ֻ�ܵ��̳�
public class Dog extends Aminal{
	//������д�Ǵ����ڼ̳�������
	//��ͬ���������������б�һ�£� 
	//��С��ȣ�����ֵ���͡��׳����쳣��
	//һ���ȣ�Ȩ�����η���
	//��������д�������������Ϊ����
	public void eat() {
		System.out.println("Dog eat ��ͷ");
	}
	//�ṩһ���������ڵ��ø����eat����
	//super��ʾ��ǰ�ĸ�����������
	public void superMethod() {
		super.eat();
		System.out.println("superClazz="+super.clazz);
	}
	
	//����������:ͬһ�����е�ͬһ����Ϊ�Ĳ�ͬ��ʵ�ַ�ʽ
	//���������ش�����ͬһ������
	public void eat(String food) {
		System.out.println("Dog eat "+food);
	}
	
}
