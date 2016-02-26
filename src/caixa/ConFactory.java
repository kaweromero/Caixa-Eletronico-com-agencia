package caixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
	public static final int MYSQL = 0;
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	public static final int POSTGRESQL = 1;
	private static final String PostgreSQLDriver = "org.postgresql.Driver";

	public static Connection conexao(String url, String nome, String senha,
			int banco) throws ClassNotFoundException, SQLException {
		switch (banco) {
		case MYSQL:
			Class.forName(MySQLDriver);
			break;
		case POSTGRESQL:
			Class.forName(PostgreSQLDriver);
		}
		return DriverManager.getConnection(url, nome, senha);
	}
}