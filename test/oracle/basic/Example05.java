package oracle.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example05 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id         INT, "
				+ "  name       VARCHAR2(100), "
				+ "  price      INT, "
				+ "  created_at DATE"
				+ ")");
	}
	
	@Test
	public void test() {
		comment("年月日を入力する例");
		sql("INSERT INTO items VALUES (1, 'apple', 100, '2015-01-02')");
		
		comment("年月日・時分秒を入力する例");
		sql("INSERT INTO items VALUES (2, 'banana', 200, to_date('2015-01-02 12:34:56', 'yyyy-mm-dd hh24:mi:ss'))");
		
		print("SELECT * FROM items");
		
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

