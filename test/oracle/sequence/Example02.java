package oracle.sequence;
//package oracle.sequence;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import oracle.DatabaseExample;
//
//// シーケンスを使う
//public class Example11 extends DatabaseExample {
//
//	@Before
//	public void setUp() {
//		try {
//		sql("DROP TRIGGER t_trigger2");
//		} catch (Exception e) {}
//		try {
//		sql("DROP SEQUENCE items_seq");
//		} catch (Exception e) {}
//		try {
//		sql("DROP TABLE items");
//		} catch (Exception e) {}
//
//		sql("CREATE SEQUENCE items_seq");
// 
//		sql("CREATE TABLE items (\n"
//		+ "  id\tINT,\n"
//		+ "  name\tVARCHAR2(100)\n"
//		+ ")");
//		 
//		sql("CREATE TRIGGER t_trigger2\n"
//		+"  BEFORE INSERT\n"
//		+"  ON items\n"
//		+"  FOR EACH ROW\n"
//		+"  WHEN (new.id is null)\n"
//		+"BEGIN\n"
//		+"  SELECT items_seq.nextval INTO :new.id FROM DUAL;\n"
//		+"END t_trigger2");
//
//	}
//	
//	@Test
//	public void test() {
//		sql("INSERT INTO items (name) values ('りんご')");
//		print("SELECT * FROM items");
//	}
//
//	@After
//	public void tearDown() {
//		try {
//		sql("DROP TRIGGER t_trigger2");
//		} catch (Exception e) {}
//		sql("DROP SEQUENCE items_seq");
//		sql("DROP TABLE items");
//	}
//
//}
//
