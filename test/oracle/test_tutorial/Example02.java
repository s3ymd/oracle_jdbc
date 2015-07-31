package oracle.test_tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example02 extends DatabaseExample {

	@Before
	public void setUp() {
		// sql()メソッドで、sqlを実行できます。
		sql("CREATE TABLE test (id INT)");
	}
	
	@Test
	public void test1() {
		sql("INSERT INTO test VALUES (1)");
		sql("INSERT INTO test VALUES (2)");
		sql("INSERT INTO test VALUES (3)");
		
		// print()メソッドで、SELECT文の実行結果を表示できます。
		print("SELECT * FROM test");
	}
	
	@After
	public void tearDown() {
		sql("DROP TABLE test");
	}

}

