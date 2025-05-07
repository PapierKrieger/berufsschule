package de.gc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Bsp_Select1 {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         final Statement statement = con.createStatement();

         final String sql1 = "desc lieferant";
         final ResultSet rs = statement.executeQuery(sql1);

         final ResultSetMetaData md = rs.getMetaData();
         final int colcount = md.getColumnCount();
         while (rs.next()) {
            for (int i = 1; i <= colcount; i++) {
               final Object obj = rs.getObject(i);
               System.out.print(obj == null ? "null" : obj.toString());
               System.out.print("\t");
            }
            System.out.println();
         }

         Util.close(statement);
         Util.close(con);

      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
