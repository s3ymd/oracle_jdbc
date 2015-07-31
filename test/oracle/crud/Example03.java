package oracle.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example03 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id       INT, "
				+ "  name     VARCHAR2(100),"
				+ "  price    INT,"
				+ "  genre_id INT"
				+ ")");
		sql("INSERT INTO items VALUES (1, 'apple', 100, 1)");
		sql("INSERT INTO items VALUES (2, 'banana', 200, 1)");
		sql("INSERT INTO items VALUES (3, 'book1', 3000, 2)");
		sql("INSERT INTO items VALUES (4, 'book2', 4000, 2)");
	}
	
	@Test
	public void test1() {
		comment("genre_id列の重複を取り除いて出力 (全部で何種類のgenre_idがあるかを調べる)");
		print("SELECT DISTINCT genre_id FROM items");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

