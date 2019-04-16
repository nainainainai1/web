package day0328;

public class AnmialMiror extends Miror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnmialMiror anmialMiror = new AnmialMiror();
		Cat cat = new Cat();
		cat.clazz = "√®¿‡";
		cat.name ="øß∑∆√®";
		anmialMiror.zhaoyao(cat);
	}

	@Override
	public void zhaoyao(Anmial anmial) {
			System.out.println(anmial.clazz+" "+anmial.name);
		}
		
		
	}

	

