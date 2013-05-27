/**
* Exportfunktion einer PDF-Datei fuer die Klassenliste des betreffenden
* Lehrers mit den Usernamen und Passwoertern
* 
* @return Facelet "users"
* @throws IOException
*/
public String pdfDownloadClass() throws IOException {

  String filename = "Klassen_Passwortliste_"
  + dbh.showUserClass(dbh.getUserId()) + ".pdf";

  try {

    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    OutputStream os = ec.getResponseOutputStream();

    // Dateiinformationen setzen
    ec.responseReset();
    ec.setResponseContentType("application/pdf");
    ec.setResponseCharacterEncoding("utf-8");
    ec.setResponseHeader("Expires", "0");
    ec.setResponseHeader("Cache-Control",
    "must-revalidate, post-check=0, pre-check=0");
    ec.setResponseHeader("Pragma", "public");
    ec.setResponseHeader("Content-Disposition",
    "attachment; filename=\"" + filename + "\"");

    Document doc = new Document();

    PdfWriter.getInstance(doc, os);

    // Schriftarten definieren
    // Helvetica, fett
    Font font1 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    // Courier kursiv
    Font font2 = new Font(Font.FontFamily.COURIER, 16);
    // Roman, normal
    Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    // Roman, fett
    Font font4 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    String relativeWebPath = "/resources/img/header.jpg";
    ServletContext servletContext = (ServletContext) ec.getContext();
    String absoluteDiskPath = servletContext
    .getRealPath(relativeWebPath);

    Image headerImage = Image.getInstance(absoluteDiskPath);
    headerImage.scaleToFit(500, 150);

    // List<User> anlegen
    List<User> users = dbh.listClassesTeacher(dbh.getUserId());

    // Tabellen-Objekt anlegen
    PdfPTable tableHead = new PdfPTable(4); // 4 Spalten
    PdfPTable tableCont = new PdfPTable(4); // 4 Spalten
    tableHead.setWidthPercentage(100);
    tableCont.setWidthPercentage(100);
    tableHead.setSpacingBefore(10f);

    doc.open(); // Dokument beginnen

    doc.add(headerImage);
    doc.add(new Paragraph("Passwortliste der Klasse: ", font1));
    doc.add(new Paragraph(dbh.showUserClass(dbh.getUserId()), font2));
    doc.add(new Paragraph("Klassenlehrer : ", font1));
    doc.add(new Paragraph(dbh.showUserFullName(dbh.getUserId()), font2));

    PdfPCell cellVName = new PdfPCell(new Paragraph("Vorname", font4));
    PdfPCell cellNName = new PdfPCell(new Paragraph("Nachname", font4));
    PdfPCell cellUsername = new PdfPCell(new Paragraph("Username",
    font4));
    PdfPCell cellPasswort = new PdfPCell(new Paragraph("Passwort",
    font4));

    tableHead.addCell(cellVName);
    tableHead.addCell(cellNName);
    tableHead.addCell(cellUsername);
    tableHead.addCell(cellPasswort);

    doc.add(tableHead);

    for (User user : users) {

    PdfPCell cellVNameDyn = new PdfPCell(new Paragraph(
    user.get_vorname(), font3));
    PdfPCell cellNNameDyn = new PdfPCell(new Paragraph(
    user.get_nachname(), font3));
    PdfPCell cellUsernameDyn = new PdfPCell(new Paragraph(
    user.get_username(), font3));
    PdfPCell cellPasswortDyn = new PdfPCell(new Paragraph(
    user.get_passwort(), font3));

    tableCont.addCell(cellVNameDyn);
    tableCont.addCell(cellNNameDyn);
    tableCont.addCell(cellUsernameDyn);
    tableCont.addCell(cellPasswortDyn);
    }
    doc.add(tableCont);

    doc.close();

    os.flush();
    os.close();

    fc.responseComplete();
    
  } catch (DocumentException de) {
      System.out.println("Error during PDF creation: " + de);
  } catch (IOException ioe) {
      System.out.println("Error during PDF creation: " + ioe);
  }
  return "users";
}