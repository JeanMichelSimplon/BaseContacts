package co.simplon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class MainMysql {
	static String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970";

	public static void main(String[] args) throws Exception {

		String requeteSql = "SELECT email FROM CONTACTS where CONTACT_TYPE = ?";
		DriverManager.registerDriver(new Driver());
		Connection connexion = DriverManager.getConnection(databaseUrl,"sql8157970","GTyyUfvfQ6");
		PreparedStatement requete = connexion.prepareStatement(requeteSql);
		requete.setString(1,args[1]);			
		ResultSet resultat = requete.executeQuery();
	
		while (resultat.next()) {
			String maVariable = resultat.getString("email");
			System.out.println(maVariable);
		}
		resultat.close();
		requete.close();
		connexion.close();
	}
}
