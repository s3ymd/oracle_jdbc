package oracle.constraints;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// UNIQUE制約
public class Example03 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items (\n"
				+ "  id\tINT, \n"
				+ "  name\tVARCHAR2(100) UNIQUE\n"
				+ ")");
	}

	@Test
	public void test() {
		sql("INSERT INTO items VALUES (1, 'apple')");
		try {
			sql("INSERT INTO items VALUES (2, 'apple')");
			fail();
		} catch (Exception e) {}
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

