package oracle.ordering;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example01 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items (id INT, name VARCHAR2(100), price INT, genre_id INT)");
	}
	
	@Test
	public void test() {
		comment("ジャンル1: 食品");
		sql("INSERT INTO items VALUES (1, 'food1', 100, 1)");
		sql("INSERT INTO items VALUES (2, 'food2', 200, 1)");
		
		comment("ジャンル2: 書籍");
		sql("INSERT INTO items VALUES (3, 'book1', 1000, 2)");
		sql("INSERT INTO items VALUES (4, 'book2', 2000, 2)");
		
		comment("価格が安い順（昇順）で並べ替え");
		print("SELECT * FROM items ORDER BY price ASC");
		
		comment("価格が高い順（降順）で並べ替え");
		print("SELECT * FROM items ORDER BY price DESC");
		
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

