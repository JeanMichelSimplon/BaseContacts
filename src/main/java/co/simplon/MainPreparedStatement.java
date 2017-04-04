package co.simplon;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class MainPreparedStatement {

	static String databaseUrl = "jdbc:oracle:thin:ANNUAIRE/ANNUAIRE@localhost:1521:xe";

	public static void main(String[] args) throws Exception {

		DriverManager.registerDriver(new OracleDriver());

		String requeteSql = "select hobbies.hobby as hobby, contacts.fname as fname from hobbies "
				+ "join contacts on hobbies.CONTACT_ID = contacts.ID "
				+ "where contacts.CONTACT_TYPE like ? and contacts.lname like ?";
		Connection connexion = DriverManager.getConnection(databaseUrl);
		Statement requete = connexion.createStatement();
		PreparedStatement stringStatement = connexion.prepareStatement(requeteSql);

		Scanner saisie = new Scanner(System.in);
		
		System.out.println("saisir type contact : ");
		String typeContact = saisie.next();
		stringStatement.setString(1, typeContact);
		
		System.out.println("Saisir nom de famille : ");
		String nom = saisie.next();
		stringStatement.setString(2, nom);

		// stringStatement.setString(1, args[0]);
		// stringStatement.setString(2, args[1]);

		// System.out.println("___ " + stringStatement);
		ResultSet resultat = stringStatement.executeQuery();
		while (resultat.next()) {
			String hobby = resultat.getString(1);
			String fname = resultat.getString(2);
			System.out.println(hobby + " " + fname);
		}
		resultat.close();
		requete.close();
		connexion.close();
		saisie.close();
	}

}