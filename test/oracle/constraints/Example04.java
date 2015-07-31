package oracle.constraints;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

// CHECK制約
public class Example04 extends DatabaseExample {

	@Before
	public void setUp() {
		sql("CREATE TABLE items (\n"
				+ "  id\tINT, \n"
				+ "  name\tVARCHAR2(100),\n"
				+ "  price\tINT CHECK(price >= 0)\n"
				+ ")");
	}

	@Test
	public void test() {
		sql("INSERT INTO items VALUES (1, 'apple', 100)");
		try {
			sql("INSERT INTO items VALUES (2, 'banana', -1)");
			fail();
		} catch (Exception e) {}
	}

	@After
	public void tearDown() {
		sql("DROP TABLE items");
	}

}

