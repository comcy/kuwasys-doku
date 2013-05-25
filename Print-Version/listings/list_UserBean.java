package de.schillerschule.kuwasys20.User;
...
/**
 * Klasse für User-Handling im System
 * 
 * @author cy
 * 
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

	FacesContext context = FacesContext.getCurrentInstance();
	private static Logger logger = Logger.getLogger(UserBean.class.getCanonicalName());
	private static final long serialVersionUID = 2L;
	DatabaseHandler dbh = new DatabaseHandler();
...
	public List<User> getUsers() {
		if (context.getExternalContext().isUserInRole("admin"))
			return dbh.listUsers();
		else
			return null;
	}

	public List<User> getSchedule() {
		if (context.getExternalContext().isUserInRole("admin"))
			return dbh.listClassesSchedule();
		if (context.getExternalContext().isUserInRole("lehrer"))
			return dbh.listClassesTeacherSchedule(dbh.getUserId());
		else
			return null;
	}

	public List<User> getTeacherClass() {
		if (context.getExternalContext().isUserInRole("admin"))
			return dbh.listClasses();
		if (context.getExternalContext().isUserInRole("lehrer"))
			return dbh.listClassesTeacher(dbh.getUserId());
		else
			return null;
	}
...
	/**
	 * Username des aktuellen Users zurückgeben
	 * 
	 * @return username
	 */
	public String showUserFullName() {
		String username = dbh.showUserFullName();
		return username;
	}

	public String showUserFirstname() {
		String username = dbh.showUserFullName();
		return username;
	}

...