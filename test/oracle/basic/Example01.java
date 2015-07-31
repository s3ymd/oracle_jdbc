package oracle.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example01 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id   INT, "
				+ "  name VARCHAR2(100)"
				+ ")");
	}
	
	@Test
	public void test1() {
		sql("INSERT INTO items VALUES (1, 'apple')");
		sql("INSERT INTO items VALUES (2, 'banana')");
		sql("INSERT INTO items VALUES (3, 'orange')");
		
		print("SELECT * FROM items");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

