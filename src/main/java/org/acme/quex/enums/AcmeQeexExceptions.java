package org.acme.quex.enums;

import io.quarkus.qeex.api.exceptions.QeexFields;
import io.quarkus.qeex.api.exceptions.QeexInterface;
import io.quarkus.qeex.api.exceptions.QeexWebException;

public enum AcmeQeexExceptions implements QeexInterface
{
   UNO(new QeexFields("ACME", 1, 404, "item not found", "it")),
   DUE(new QeexFields("ACME", 2, 404, "item not found", "it"));

   public QeexFields fields;

   private AcmeQeexExceptions(QeexFields fields)
   {
      this.fields = fields;
   }

   public QeexWebException get()
   {
      return this.get(this);
   }

}
