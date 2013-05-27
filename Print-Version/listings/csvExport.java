/**
  * Exportfunktion einer CSV-Datei für die gesamte Schuelerliste
  * 
  * @return Facelet "users"
  */
public String csvDownloadStudents() {

  String filename = "Schuelerliste_Alle.csv";

  try {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();

    ec.responseReset();
    ec.setResponseContentType("text/comma-separated-values");
    ec.setResponseHeader("Content-Disposition",
		    "attachment; filename=\"" + filename + "\"");

    OutputStream os = ec.getResponseOutputStream();
    PrintStream ps = new PrintStream(os);

    List<User> users = dbh.listUsers();

    for (User user : users) {
      ps.print(user.get_vorname() + ";" + user.get_nachname() + ";"
	+ user.get_geburtstag() + ";" + user.get_konfession()
	+ ";" + user.get_klasse() + ";" + user.get_username()
	+ ";" + user.get_passwort() + "\n");
    }

    ps.flush();
    ps.close();

    fc.responseComplete();
  } catch (IOException ex) {
    System.out.println("File Export Error: " + ex);
  }
  return "users";
}