package co.simplon;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDAO {

	public static void main(String[] args) throws Exception {
		final Logger monlogger = Logger.getLogger("monLogger");
		ContactDAO dao = new JdbcContactDAO();
		String type = args[0];
		List<String> emails = dao.findEmailsByContactType(type);
		for (String email : emails) {
//			System.out.println(email);
			monlogger.log(Level.INFO, "Recherche des email des contacts de type "+email);
		}

	}
}
