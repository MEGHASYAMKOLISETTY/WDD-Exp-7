

import java.io.IOException;
import java.io.PrintWriter;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/test";
        String createTable = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id integer PRIMARY KEY,\n"
            + " username text NOT NULL,\n"
            + " password text NOT NULL\n"
            + ");"; 
        try (Connection conn = DriverManager.getConnection(url);
            Statement createTableStmt = conn.createStatement()) {
            createTableStmt.execute(createTable);
            Statement insertUserStmt = conn.createStatement();
            insertUserStmt.execute("INSERT INTO users (username, password) VALUES ('test', 'test');");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
		PrintWriter out = response.getWriter();
		out.println(" Authenticated");
	}
}
