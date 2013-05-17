@ManagedBean(name = "importBean")
@RequestScoped
public class ImportBean implements Serializable {
	...
	public void doImport() {

		// Stringvariablen fuer ausgelesene Daten
		String line = "";
		String klasse = ""; // (1)
		String nname = ""; // (2)
		String vname = ""; // (3)
		String geb = ""; // (4)
		String konf = ""; // (5)
		String role = "schueler"; // (6)

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					file.getInputStream(), "ISO-8859-1"));
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			line = reader.readLine(); // erste Zeile ueberspringen
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				st = new StringTokenizer(line, ","); // Trennzeichen
				while (st.hasMoreTokens()) {
					tokenNumber++;
					switch (tokenNumber) {
					case 1:
						klasse = st.nextToken().replaceAll("'", "");
					case 2:
						nname = st.nextToken().replaceAll("'","");
					case 3:
						vname = st.nextToken().replaceAll("'","");
					case 4:
						geb = st.nextToken().replaceAll("'", "");
					case 5:
						konf = st.nextToken().replaceAll("'", "");
					}
				}
				dbh.addUser(klasse, nname, vname, geb, konf, role);
				tokenNumber = 0;
			}
			reader.close();
		...
	}
	...
}
