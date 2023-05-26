package io.quarkus.qeex.api.exceptions;

public class QeexFields
{
   public QeexFields(String projectName, int id, int code, String message, String language)
   {
      this.projectName = projectName;
      this.id = id;
      this.code = code;
      this.message = message;
      this.language = language;
   }

   public String projectName;
   public int id;
   public int code;
   public String message;
   public String language;
}
