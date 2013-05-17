private static Logger logger = Logger.getLogger(ImportBean.class
			.getCanonicalName());
...

  logger.info("File type: " + file.getContentType());
  logger.info("File name: " + file.getName());
  logger.info("File size: " + file.getSize() + " bytes");

...

try{ ... }

catch (Exception e) {
   
   logger.info("Upload fehlgeschlagen\n" + e.getMessage());

}