public void removeFromGradelist(int userId, int kursId) {
	try {
		SQLConnection();
		statement = connection.createStatement();
		statement.executeUpdate("DELETE FROM gradelist WHERE gradelist_userid=" + userId + " AND gradelist_kursid=" + kursId + ";");
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	SQLConnectionClose();
}
