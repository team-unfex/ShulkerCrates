package nl.skelic.sc.mysql;

public class SCMySQLCRATES {

	private String table = "SC_Crates";
	private SCMySQL mysql;
	
	public void check() {
		try {
			mysql.updateTable("CREATE TABLE IF NOT EXISTS " + table + "(UUID VARCHAR(64))");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
