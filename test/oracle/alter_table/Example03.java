package oracle.alter_table;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example03 extends DatabaseExample {

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
		
		comment("genre_id列の名前をcategory_idに変更");
		sql("ALTER TABLE items RENAME COLUMN genre_id TO category_id");
		
		print("SELECT * FROM items");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

