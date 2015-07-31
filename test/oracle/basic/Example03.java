package oracle.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example03 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id   INT, "
				+ "  name VARCHAR2(100)"
				+ ")");
	}
	
	@Test
	public void test4() {
		comment("name列の値を省略");
		sql("INSERT INTO items (id) VALUES (1)");
		
		comment("id列の値を省略");
		sql("INSERT INTO items (name) VALUES ('りんご')");
		
		print("SELECT * FROM items");
	}
	

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

