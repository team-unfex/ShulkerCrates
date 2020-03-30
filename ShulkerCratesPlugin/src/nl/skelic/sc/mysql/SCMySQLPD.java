package nl.skelic.sc.mysql;

public class SCMySQLPD {

	private String table = "SC_PlayerData";
	private SCMySQL mysql;
	
	public void check() {
		try {
			mysql.updateTable("CREATE TABLE IF NOT EXISTS " + table + "(PlayerUUID VARCHAR(64))");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
