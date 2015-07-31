package oracle.alter_table;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example05 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id       INT, "
				+ "  name     VARCHAR2(100), "
				+ "  genre_id INT"
				+ ")");
	}
	
	@Test
	public void test1() {
		sql("INSERT INTO items VALUES (1, 'apple', 1)");
		sql("INSERT INTO items VALUES (2, 'banana', 1)");
		sql("INSERT INTO items VALUES (3, 'orange', 1)");
		
		comment("items表の名前をt_itemに変更");
		sql("ALTER TABLE items RENAME TO t_item");
		
		print("SELECT * FROM t_item");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE t_item");
	}

}

