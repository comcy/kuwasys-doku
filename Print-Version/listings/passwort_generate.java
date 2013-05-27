/**
* Generiert Passwort fuer aktuellen User
* 
* @return password
*/
public static String createPassword() {
  SecureRandom random = new SecureRandom();
  String password = new BigInteger(32, random).toString(32);
  System.out.println("Passwort: " + password);
  return password;
}