package oracle.constraints;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// 主キー制約
public class Example01 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items (\n"
				+ "  id\tINT PRIMARY KEY, \n"
				+ "  name\tVARCHAR2(100)\n"
				+ ")");
	}

	@Test
	public void test() {
		sql("INSERT INTO items VALUES (1, 'apple')");
		try {
			sql("INSERT INTO items VALUES (1, 'orange')");
			fail();
		} catch (Exception e) {}
		try {
			sql("INSERT INTO items VALUES (NULL, 'banana')");
			fail();
		} catch (Exception e) {}
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

