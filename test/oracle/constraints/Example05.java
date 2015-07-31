package oracle.constraints;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// 外部キー制約
public class Example05 extends DatabaseExample {

	@Before
	public void setUp() {
		
		sql("CREATE TABLE genres (\n"
				+ "  id\tINT\tPRIMARY KEY, \n"
				+ "  name\tVARCHAR2(100)"
				+ ")");
		sql("CREATE TABLE items (\n"
				+ "  id\tINT, \n"
				+ "  name\tVARCHAR2(100),\n"
				+ "  genre_id\tINT\tREFERENCES genres (id)"
				+ ")");
	}

	@Test
	public void test() {
		sql("INSERT INTO genres VALUES (1, '食品')");
		sql("INSERT INTO genres VALUES (2, '書籍')");
		sql("INSERT INTO items VALUES (1, 'りんご', 1)");
		sql("INSERT INTO items VALUES (2, 'みかん', 1)");
		sql("INSERT INTO items VALUES (3, 'Java入門', 2)");
		sql("INSERT INTO items VALUES (4, 'Oracle入門', 2)");
		sql("INSERT INTO items VALUES (5, 'PHP入門', NULL)");
		try {
			sql("INSERT INTO items VALUES (6, 'バナナ', 3)");
			fail();
		} catch (Exception e) {}
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
		sql("DROP TABLE genres");
	}

}

