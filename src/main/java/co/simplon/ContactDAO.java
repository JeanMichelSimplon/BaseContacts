package co.simplon;

import java.util.List;

public interface ContactDAO {

	public List<String> findEmailsByContactType(String type) throws Exception;

}
