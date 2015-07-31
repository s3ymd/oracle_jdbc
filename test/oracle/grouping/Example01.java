package oracle.grouping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example01 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("create table items (id int, name varchar2(100), price int, genre_id int)");
	}
	
	@Test
	public void test() {
		// ジャンル1: 食品
		sql("insert into items values (1, 'food1', 100, 1)");
		sql("insert into items values (2, 'food2', 200, 1)");
		// ジャンル2: 書籍
		sql("insert into items values (3, 'book1', 1000, 2)");
		sql("insert into items values (4, 'book2', 2000, 2)");
		
		print("select genre_id, avg(price) from items group by genre_id");
		
	}

	@After
	public void tearDown() {
		sql("drop table items");
	}

}

