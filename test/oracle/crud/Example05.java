package oracle.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example05 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id       INT, "
				+ "  name     VARCHAR2(100),"
				+ "  price    INT"
				+ ")");
		sql("INSERT INTO items VALUES (1, 'りんご', 100)");
		sql("INSERT INTO items VALUES (2, 'みかん', 200)");
		sql("INSERT INTO items VALUES (3, 'バナナ', 300)");
	}
	
	@Test
	public void test1() {
		print("SELECT * FROM items");
		comment("みかんの価格を250円にする");
		sql("UPDATE items SET price = 250 WHERE id = 2");
		print("SELECT * FROM items");
	}	
	
	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

