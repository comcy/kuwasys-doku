public void SQLConnection() {
  try {
    InitialContext cxt = new InitialContext();
      DataSource ds = (DataSource) cxt
	.lookup("java:/comp/env/jdbc/postgres");
      connection = ds.getConnection();
      System.out.println("DB open");
      statement = connection.createStatement();
      result = statement.executeQuery("SELECT VERSION()"); // DEBUG
      if (result.next()) {
	System.out.println(result.getString(1)); // DEBUG
      }
  } catch (SQLException ex) {
    System.out.println("Error during DB connection " + ex);
    ex.printStackTrace();
  } catch (NamingException ex) {
    System.out.println("Error during DB connection " + ex);
    ex.printStackTrace();
  }
} 
