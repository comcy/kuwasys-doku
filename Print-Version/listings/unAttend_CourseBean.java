DatabaseHandler dbh = new DatabaseHandler();
...		
public String unAttendCourse(){
	dbh.removeFromGradelist(dbh.getUserId(),_id);
	return "courses";
}