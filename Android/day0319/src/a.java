
public class a {
	private String name;
	private String sex;
	private String height;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public a(String name, String sex, String height) {
		super();
		this.name = name;
		this.sex = sex;
		this.height = height;
	}

	public a() {
		super();
	}

	@Override
	public String toString() {
		return "a [name=" + name + ", sex=" + sex + ", height=" + height + "]";
	}

}
