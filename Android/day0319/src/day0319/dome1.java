package day0319;

public class dome1 {
	static int i1;
	int i2;
	public static void test1() {
		System.out.println("static");
	}
	public void test2() {
		System.out.println("dynamic");
	}

	public static int getI1() {
		return i1;
	}
	public static void setI1(int i1) {
		dome1.i1 = i1;
	}
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
