import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) throws SQLException {

		String host = "http://127.0.0.1";
		String port = "42611";
		Connection c =DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/QADB", "postgres", "bcwpc4746g");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM employees WHERE eid=100;");
		while(rs.next()) { //rs.next() is like what we do for SET, move to first index
			
			System.out.println(rs.getString("efname")); //we can use this DB output as an input to any of out test. so this how we do data driven testing not only through excel but also through Database
		
		}
	}

}
