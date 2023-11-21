package dynamicProject;

public class Users {
	private int idUsers;
	private String fname;
	private String lname;
	private String adresse;
	private String tel;
	private int age;
	private String sexe;
	
	public Users(int idUsers, String fname, String lname, String adresse, String tel, int age, String sexe) {
		super();
		this.idUsers = idUsers;
		this.fname = fname;
		this.lname = lname;
		this.adresse = adresse;
		this.tel = tel;
		this.age = age;
		this.sexe = sexe;
	}
	
	public Users(int idUsers, String fname, String lname) {
		super();
		this.idUsers = idUsers;
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getIdUsers() {
		return idUsers;
	}

}
