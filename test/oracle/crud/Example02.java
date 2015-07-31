package oracle.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example02 extends DatabaseExample {

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
		comment("price列の代わりに、定数50を出力。");
		print("SELECT id AS \"商品番号\", name AS \"商品名\", "
				+ "50 AS \"特別価格\", genre_id AS \"ジャンル\" "
				+ "FROM items");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

