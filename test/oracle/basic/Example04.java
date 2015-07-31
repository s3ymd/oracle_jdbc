package oracle.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example04 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "id    INT, "
				+ "name  VARCHAR2(100), "
				+ "price INT,"
				+ "weight NUMBER(5, 2)"
				+ ")");
	}
	
	@Test
	public void test() {
		comment("小数を入力");
		sql("INSERT INTO items VALUES (1, 'apple', 100, 123.45)");
		sql("INSERT INTO items VALUES (2, 'banana', 200, 234.56)");
		sql("INSERT INTO items VALUES (3, 'orange', 300, 345.67)");
		
		print("SELECT * FROM items");
		
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

