package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class DatabaseExample {

	private static final String URL = "jdbc:oracle:thin:@192.168.141.32:1521:xe";
	private static final String USER = "sssuser";
	private static final String PASSWORD = "systemsss";

	private static Connection connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("データベース接続に失敗しました");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("データベース切断に失敗しました");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void comment(String comment) {
		System.out.println("-- " + comment);
	}

	public void sql(String sql) {
		sql(sql, null);
	}

	public void sql(String sql, ResultHandler handler) {
		System.out.print(sql + ";");
		try (Statement st = connection.createStatement()) {
			if (handler == null) {
				st.execute(sql);
			} else {
				try (ResultSet rs = st.executeQuery(sql)) {
					Table table = new Table();
					table.setResultSet(rs);
					handler.handleResult(table);
				}
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.print(" -- ");
			System.out.println(e.getMessage().trim());
			throw new RuntimeException(e);
		}
	}

	public void print(String sql) {
		sql(sql, (table) -> {
			System.out.println();
			System.out.println(table);
		});

	}

	public void rollback() {
		try {
			System.out.println("ROLLBACK;");
			connection.rollback();
		} catch (SQLException e) {
			System.out.print(" -- ");
			System.out.println(e.getMessage().trim());
			throw new RuntimeException(e);
		}
	}


	public void commit() {
		try {
			System.out.println("COMMIT;");
			connection.commit();
		} catch (SQLException e) {
			System.out.print(" -- ");
			System.out.println(e.getMessage().trim());
			throw new RuntimeException(e);
		}
	}

	public void beginTransaction() {
		try {
			System.out.println("BEGIN TRANSACTION;");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.print(" -- ");
			System.out.println(e.getMessage().trim());
			throw new RuntimeException(e);
		}
	}

	interface ResultHandler {
		public void handleResult(Table table);
	}

	static class Table {
		private List<String> fieldNames = new ArrayList<>();
		private List<Object[]> rows = new ArrayList<>();

		public void setResultSet(ResultSet rs) throws SQLException {
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i = 0; i < columns; i++) {
				fieldNames.add(md.getColumnName(i + 1));
			}
			
			while (rs.next()) {
				Object[] row = new Object[columns];
				for (int i = 0; i < columns; i++) {
					// System.out.println(md.getColumnTypeName(i + 1));
					if (md.getColumnType(i + 1) == Types.NUMERIC && md.getPrecision(i + 1) == 0) {
						row[i] = rs.getInt(i + 1);
						if (rs.wasNull()) {
							row[i] = null;
						}
					} else {
						row[i] = rs.getObject(i + 1);
					}
				}
				rows.add(row);
			}
		}

		public Object get(int row, int column) {
			if (row >= rows.size()) {
				System.out.println("error: 指定された行は存在しません:" + row);
				return null;
			}
			Object[] r = rows.get(row);
			if (column >= r.length) {
				System.out.println("error: 指定された列は存在しません: " + column);
				return null;
			}
			return r[column];
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(System.lineSeparator());
			for (String s: fieldNames) {
				sb.append(String.format("|%s\t", s));
			}
			sb.append("|");
			sb.append(System.lineSeparator());
			for (@SuppressWarnings("unused") String s: fieldNames) {
				sb.append("+-------");
			}
			sb.append("+");
			sb.append(System.lineSeparator());
			for (Object[] row : rows) {
				for (Object o : row) {
					if (o == null) {
						o = "(null)";
					}
					sb.append(String.format("|%s\t", o));
				}
				sb.append("|");
				sb.append(System.lineSeparator());
			}
			return sb.toString();
		}
	}

}
