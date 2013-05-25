public class UserBean implements Serializable {
...
	public static class User implements Serializable {
		DatabaseHandler dbh = new DatabaseHandler();
		private static final long serialVersionUID = 1L;

		private int _id;
		private String _nachname;
		private String _vorname;
		private String _geburtstag;
		private String _konfession;
		private String _klasse;
		private String _username;
		private String _passwort;
		private String _rolle; // default
		private boolean _canEdit;

		private int _grade_id;
		private Double _grade_note;
		private Double _grade_fachwissen;
		private Double _grade_sozial;
		private Double _grade_personal;
		private Double _grade_methodisch;
		private String _grade_bemerkung;

		private String _termin1;
		private String _termin2;
		private String _termin3;
		private String _termin4;
		private String _termin5;
		private String _termin6;
		private String _termin7;
		private String _termin8;
		private String _termin9;
		private String _termin10;
		private int _grade_kursid;
		private int _grade_jahr;
		private int _grade_tertial;

		public User(int id, String vorname, String nachname, String geburtstag,
				String konfession, String klasse, String username,
				String passwort, String rolle, boolean canEdit) {
			_id = id;
			_nachname = nachname;
			_vorname = vorname;
			_geburtstag = geburtstag;
			_konfession = konfession;
			_klasse = klasse;
			_username = username;
			_passwort = passwort;
			_rolle = rolle;
			_canEdit = false;
		}
...
		public int get_id() {
			return _id;
		}
		public void set_id(int _id) {
			this._id = _id;
		}
		public String get_nachname() {
			return _nachname;
		}
		public void set_nachname(String _nachname) {
			this._nachname = _nachname;
		}
		public String get_vorname() {
			return _vorname;
		}
		public void set_vorname(String _vorname) {
			this._vorname = _vorname;
		}
...