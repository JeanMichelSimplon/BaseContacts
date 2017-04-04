package co.simplon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class JdbcContactDAO implements ContactDAO {

	@Override
	public List<String> findEmailsByContactType(String type) throws Exception {
		String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970";
		String requeteSql = "SELECT fname,lname,email FROM CONTACTS where CONTACT_TYPE = ? order by email";
		DriverManager.registerDriver(new Driver());
		Connection connexion = DriverManager.getConnection(databaseUrl,
				"sql8157970", "GTyyUfvfQ6");
		PreparedStatement requete = connexion.prepareStatement(requeteSql);
		requete.setString(1, type);
		ResultSet resultat = requete.executeQuery();
		List<String> emails = new ArrayList<String>();
		while (resultat.next()) {
			emails.add(resultat.getString("email"));
		}
		requete.close();
		connexion.close();
		return emails;
	}

}
