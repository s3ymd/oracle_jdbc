package oracle.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// NULL値の設定
public class Example02 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id   INT, "
				+ "  name NVARCHAR2(2000)"
				+ ")");
	}
	
	@Test
	public void test3() {
		sql("INSERT INTO items VALUES (1, NULL)");
		sql("INSERT INTO items VALUES (2, '')");
		sql("INSERT INTO items VALUES (NULL, 'みかん')");
		
		print("SELECT * FROM items");
	}
	

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

