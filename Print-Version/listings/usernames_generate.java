 /**
 * createUsername: zum automatischen erstellen des Usernamens aus dem echten
 * Vor- und Nachnamen
 * 
 **/
public String createUsername(String vname, String nname) {
  
  // Marker fuer aktuellen Usernamen
  boolean isCurrentUsername = true;
      
    String username = "";
    String usernameDB = "";
    
    vname = vname.substring(0, 2);
    nname = nname.substring(0, 3);
    while (isCurrentUsername) {
      for (int i = 1; i < 1000; i++) {
	username = nname + vname + i;
	// Pruefen ob erstellter Name in DB schon vorhanden
	try {
	  // Check ob users_id bereits vorhanden:
	  statement = connection.createStatement();
	  result = statement
	  .executeQuery("SELECT users_username FROM users "
	  "WHERE users_username = '" + username
	  "';");
	  while (result.next()) {
	    usernameDB = result.getString(1);
	  }
	  if (username.equals(usernameDB)) {
	    isCurrentUsername = true;
	  } else {
	    isCurrentUsername = false;
	    break;
	  }
	  catch (SQLException ex) {
	    ex.printStackTrace();
	  }
	}
    }
    System.out.println("Username: " + username);
    return username;
}