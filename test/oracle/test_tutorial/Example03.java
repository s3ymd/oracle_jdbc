package oracle.test_tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example03 extends DatabaseExample {

	@Before
	public void setUp() {
		// comment()メソッドで、コメントを出力できます。
		comment("表を作成します");
		sql("CREATE TABLE test (id INT)");
	}
	
	@Test
	public void test1() {
		comment("テストデータを入力します");
		sql("INSERT INTO test VALUES (1)");
		sql("INSERT INTO test VALUES (2)");
		sql("INSERT INTO test VALUES (3)");
		
		comment("表のデータをすべて出力します");
		print("SELECT * FROM test");
	}
	
	@After
	public void tearDown() {
		comment("表を削除します");
		sql("DROP TABLE test");
	}

}

