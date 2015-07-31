package oracle.constraints;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// DEFAULT制約
public class Example06 extends DatabaseExample {

	@Before
	public void setUp() {
		
		sql("CREATE TABLE items ("
				+ "  id INT, "
				+ "  name VARCHAR2(100),"
				+ "  price INT DEFAULT 0"
				+ ")");
	}

	@Test
	public void test() {
		comment("price列の値を省略して行を追加");
		sql("INSERT INTO items (id, name) VALUES (1, 'りんご')");

		comment("price列の値に DEFAULT を指定して行を追加");
		sql("INSERT INTO items VALUES (2, 'みかん', DEFAULT)");

		comment("price列の値を明示的に指定して行を追加");
		sql("INSERT INTO items VALUES (3, 'バナナ', 100)");
		
		print("SELECT * FROM items");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

