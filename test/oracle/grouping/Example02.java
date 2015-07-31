package oracle.grouping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example02 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE products ("
				+ "  id       INT, "
				+ "  name     VARCHAR2(100),"
				+ "  lang     VARCHAR2(100),"
				+ "  db       VARCHAR2(100)"
				+ ")");
		sql("INSERT INTO products VALUES (1, '在庫管理システム', 'C#', 'Oracle')");
		sql("INSERT INTO products VALUES (2, '人事システム', 'Java', 'MySQL')");
		sql("INSERT INTO products VALUES (3, '社員管理システム', 'PHP', 'Oracle')");
		sql("INSERT INTO products VALUES (4, '書籍管理システム', 'C#', 'Oracle')");
		sql("INSERT INTO products VALUES (5, 'ファイル管理システム', 'PHP', 'MySQL')");
		sql("INSERT INTO products VALUES (6, '勤務システム', 'C#', 'Oracle')");
		sql("INSERT INTO products VALUES (7, '注文システム', 'PHP', 'Oracle')");
	}
	
	@Test
	public void test1() {
		comment("lang列 と genre_id列でグループ化し、グループごとの件数を数える");
		print("SELECT lang, db, count(*) FROM products GROUP BY lang, db");
	}

	@After
	public void tearDown() {
		sql("DROP TABLE products");
	}

}

