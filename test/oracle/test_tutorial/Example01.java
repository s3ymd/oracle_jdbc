package oracle.test_tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oracle.DatabaseExample;

public class Example01 extends DatabaseExample {

	// 「@Before」アノテーションが付いたメソッドは、
	// 「@Test」アノテーションが付いたメソッドに先立って実行されます。
	@Before
	public void setUp() {
		System.out.println("setUp()が実行されました");
	}
	
	@Test
	public void test1() {
		System.out.println("test1()が実行されました");
	}
	
	// 「@Before」アノテーションが付いたメソッドは、
	// 「@Test」アノテーションが付いたメソッドにつづいて実行されます。
	@After
	public void tearDown() {
		System.out.println("tearDown()が実行されました");
	}

}

