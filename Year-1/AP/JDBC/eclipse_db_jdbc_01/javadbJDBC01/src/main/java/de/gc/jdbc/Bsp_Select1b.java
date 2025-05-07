package de.gc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bsp_Select1b {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         final Statement statement = con.createStatement();

         final String sql1 = "desc lieferant";
         final ResultSet rs = statement.executeQuery(sql1);

         Util.printRs(rs);

         Util.close(statement);
         Util.close(con);

      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
