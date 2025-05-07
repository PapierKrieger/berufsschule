package de.gc.jdbc;

import java.sql.Connection;

public class Bsp_PreparedStatementLIEFERANT2 {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         // TODO Prepared Statement erzeugen

         // TODO Werte zuweisen: alle Namen die mit 'N' beginnen

         // TODO Daten anzeigen

         // TODO Werte zuweisen: alle Namen die mit 'M' beginnen

         // TODO Daten anzeigen

         Util.close(con);
      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
