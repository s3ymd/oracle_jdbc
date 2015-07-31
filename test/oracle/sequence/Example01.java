package oracle.sequence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// シーケンスを使う
public class Example01 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items (\n"
				+ "  id\tINT, \n"
				+ "  name\tVARCHAR2(100)\n"
				+ ")");
		sql("CREATE SEQUENCE items_seq");
	}
	
	@Test
	public void test() {
		sql("INSERT INTO items VALUES (items_seq.nextval, 'apple')");
		sql("INSERT INTO items VALUES (items_seq.nextval, 'banana')");
		sql("INSERT INTO items VALUES (items_seq.nextval, 'orange')");
		
		print("SELECT * FROM items");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
		sql("DROP SEQUENCE items_seq");
	}

}

