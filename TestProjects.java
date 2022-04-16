import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class TestProjects {
	@Test
	void test_users() {
		Users u = new Users("testU", "name", "street", "zip", "phone", "pic", true, "date");
		assertEquals("name", u.getName());
		assertEquals("street", u.getStreet());
		assertEquals("zip", u.getZip());
		assertEquals("phone", u.getPhone());
		assertEquals("pic", u.getPicture());
		assertEquals("date", u.getDateCreated());
		assertEquals(true, u.isActive());
		assertEquals(u.getUid() + ", " + u.getName() + ", " 
		        + u.getStreet() + ", " + u.getZip() + ", " + u.getPhone() + 
		        ", " +u.getPicture() + ", " + Boolean.toString(u.isActive()) 
		        + ", " + u.getDateCreated(), u.toString());
	}
	@Test
	void test_asks() {
		String[] zip = {"zip"};
		Ask a = new Ask("uid", "aid", "description", "start", "end", zip, true, "date");
		assertEquals("uid", a.getUid());
		assertEquals("aid", a.getPid());
		assertEquals("description", a.getDescription());
		assertEquals("start", a.getStartDate());
		assertEquals("end", a.getEndDate());
		assertEquals(true, a.isActive());
		assertEquals("date", a.getDateCreated());
		assertEquals("ask", a.getType());
	}
	@Test
	void test_give() {
		String[] zip = {"zip"};
		Give g = new Give("uid", "gid", "description", "start", "end", zip, true, "date");
		assertEquals("uid", g.getUid());
		assertEquals("gid", g.getPid());
		assertEquals("description", g.getDescription());
		assertEquals("start", g.getStartDate());
		assertEquals("end", g.getEndDate());
		assertEquals(true, g.isActive());
		assertEquals("date", g.getDateCreated());
		assertEquals("give", g.getType());
	}
	@Test
	void test_notes() {
		Notes n = new Notes("uid", "nid", "ask", "to", "toID", "description", "date");
		assertEquals("uid", n.getUid());
		assertEquals("nid", n.getNid());
		assertEquals("description", n.getDescription());
		assertEquals("date", n.getDateCreated());
		assertEquals("to", n.getToUserID());
		assertEquals("toID", n.getToID());
	}
	@Test
	void test_thanks() {
		Thanks t = new Thanks("uid", "tid", "to", "description", "date");
		assertEquals("uid", t.getUid());
		assertEquals("tid", t.getTid());
		assertEquals("description", t.getDescription());
		assertEquals("date", t.getDateCreated());
	}
}
