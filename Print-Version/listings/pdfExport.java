/**
* Exportfunktion einer PDF-Datei fuer die Klassenliste des betreffenden
* Lehrers mit den Usernamen und Passwoertern
* 
* @return Facelet "users"
* @throws IOException
*/
public String pdfDownloadClass() throws IOException {

...

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

    ...
    
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
    ...

    tableHead.addCell(cellVName);
    ...

    doc.add(tableHead);

    for (User user : users) {

      PdfPCell cellVNameDyn = new PdfPCell(new Paragraph(
      user.get_vorname(), font3));
      ...
      tableCont.addCell(cellVNameDyn);
      ...
    }
    
    doc.add(tableCont);
    doc.close();
    os.flush();
    os.close();
    fc.responseComplete();
...

}