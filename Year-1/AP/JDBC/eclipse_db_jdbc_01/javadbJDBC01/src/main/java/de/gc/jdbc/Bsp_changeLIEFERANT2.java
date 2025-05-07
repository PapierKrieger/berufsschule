package de.gc.jdbc;

import java.sql.Connection;

public class Bsp_changeLIEFERANT2 {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         // TODO Datensätze ändern

         // TODO Daten der Tabelle LIEFERANT2 anzeigen

         Util.close(con);
      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
