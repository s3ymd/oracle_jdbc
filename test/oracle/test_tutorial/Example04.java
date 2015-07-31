package oracle.test_tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example04 extends DatabaseExample {

	@Before
	public void setUp() {
		// 長いSQLは、途中で改行することができます。
		// TODO 下記の文字列の test の直後に改行を入れてください。
		sql("CREATE TABLE test (a INT, b INT, c INT, d INT, e INT)");
	}
	@Test
	public void test() {
		// TODO 下記の文字列のVALUESの直前に改行を入れてください。
		sql("INSERT INTO test (a, b, c, d, e) VALUES (1, 2, 3, 4, 5)");
	}
	
	@After
	public void tearDown() {
		sql("DROP TABLE test");
	}

}

