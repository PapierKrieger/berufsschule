package de.gc.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Bsp_Connect2 {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         final DatabaseMetaData meta = con.getMetaData();
         System.out.format("Driver : %s %s.%s\n", meta.getDriverName(),
               meta.getDriverMajorVersion(), meta.getDriverMinorVersion());
         System.out.format("DB     : %s %s.%s (%s)\n",
               meta.getDatabaseProductName(), meta.getDatabaseMajorVersion(),
               meta.getDatabaseMinorVersion(),
               meta.getDatabaseProductVersion());
         Util.close(con);

      } catch (final SQLException e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
