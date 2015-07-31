package oracle.ordering;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example02 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items (id INT, name VARCHAR2(100), price INT, genre_id INT)");
	}
	
	@Test
	public void test() {
		comment("ジャンル1: 食品");
		sql("INSERT INTO items VALUES (1, 'food3', 3000, 1)");
		sql("INSERT INTO items VALUES (2, 'food2', 2000, 1)");
		sql("INSERT INTO items VALUES (3, 'food1', 1000, 1)");

		comment("ジャンル2: 書籍");
		sql("INSERT INTO items VALUES (4, 'book1', 1000, 2)");
		sql("INSERT INTO items VALUES (5, 'book2', 2000, 2)");
		sql("INSERT INTO items VALUES (6, 'book3', 3000, 2)");
		
		comment("ジャンル3: DVD");
		sql("INSERT INTO items VALUES (7, 'dvd3', 3000, 3)");
		sql("INSERT INTO items VALUES (8, 'dvd2', 2000, 3)");
		sql("INSERT INTO items VALUES (9, 'dvd1', 1000, 3)");
		
		comment("価格の昇順、ジャンルの昇順で並び替え");
		print("SELECT * FROM items ORDER BY price ASC, genre_id ASC");
		
		comment("ジャンルの昇順、価格の昇順で並び替え");
		print("SELECT * FROM items ORDER BY genre_id ASC, price ASC");
		
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

