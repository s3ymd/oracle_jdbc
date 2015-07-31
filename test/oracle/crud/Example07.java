package oracle.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example07 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items ("
				+ "  id       INT, "
				+ "  name     VARCHAR2(100),"
				+ "  price    INT"
				+ ")");
		sql("INSERT INTO items VALUES (1, 'りんご', 100)");
		sql("INSERT INTO items VALUES (2, 'みかん', 200)");
		sql("INSERT INTO items VALUES (3, 'バナナ', 300)");
	}
	
	@Test
	public void test1() {
		print("SELECT * FROM items");
		
		comment("すべての行を削除する(トランザクションを使用、DELETEを使用)");
		beginTransaction();
		sql("DELETE FROM items");
		print("SELECT * FROM items");
		
		comment("ロールバックして、削除したデータをもとに戻すことができる");
		rollback();
		print("SELECT * FROM items");
	}	
	
	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

