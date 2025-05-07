package de.gc.jdbc.csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import de.gc.jdbc.Util;

public class Bsp_cvsjdbc_PLZ2 {

   public static void main(final String[] args) {

      try {
         final Connection con = DriverManager.getConnection(
               "jdbc:relique:csv:src/main/resources/csv?separator=,");
         System.out.println("... connected");

         final Statement st = con.createStatement();
         final ResultSet rs = st.executeQuery("""
               SELECT *
               FROM zuordnung_plz_ort_landkreis
               LIMIT 10;
               """);
         Util.printRs(rs);
         Util.close(con);
      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
