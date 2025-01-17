package AbstractFactory;

public class AdminUser extends User {

	public AdminUser(UserFactory factory, String username, String password) {
		super(username, password);
		this.factory = factory;
	}

	@Override
	public String toString() {
		return getUsername() + "(Admin)";
	}
	
	@Override
	public void administer() {
		System.out.println(getUsername() + " is Administring");
	}
	
	@Override
	public void browse() {
		System.out.println(getUsername() + " is Browsing");
	}
	
	@Override
	public void visit() {
		System.out.println(getUsername() + " is Visiting");
	}

	@Override
	public void make() {
		priviledge = factory.setPriviledge();
	}

}
