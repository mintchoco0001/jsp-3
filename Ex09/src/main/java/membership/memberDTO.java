package membership;

public class memberDTO {
	private String id;
	private String pw;
	private String name;
	private String regidate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "memberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", regidate=" + regidate + "]";
	}
}
