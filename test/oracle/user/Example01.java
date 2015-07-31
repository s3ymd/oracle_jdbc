package oracle.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// ユーザーの作成
public class Example01 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE USER taro IDENTIFIED BY taro");
	}
	
	@Test
	public void test() {
	}

	@After
	public void tearDown() {
		sql("DROP USER taro");
	}

}

