package dai0402;

public class IronMan implements Belt,Jacket,Shoes,Bottling,Headshoulder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IronMan ironman = new IronMan();
		ironman.show();
	}

	@Override
	public void headshoulder() {
		// TODO Auto-generated method stub
		System.out.println("��������+100");
	}

	@Override
	public void bottling() {
		// TODO Auto-generated method stub
		System.out.println("�������+100");
	}

	@Override
	public void shoes() {
		// TODO Auto-generated method stub
		System.out.println("�ƶ��ٶ�+100");
	}

	@Override
	public void jacket() {
		// TODO Auto-generated method stub
		System.out.println("��������+100");
	}

	@Override
	public void belt() {
		// TODO Auto-generated method stub
		System.out.println("����+100");
	}
	public void show() {
		headshoulder();belt();jacket();shoes();bottling();
		
	}
}
