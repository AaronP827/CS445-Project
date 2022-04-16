
public class Reports {
	private String rid;
	private String name;
	
	public Reports(String rid, String name) {
		this.setRid(rid);
		this.setName(name);
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
