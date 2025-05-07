package de.gc.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bsp_Connect {

   public static void main(final String[] args) {

      try {
         final Connection con = DriverManager.getConnection(
               "jdbc:mariadb://localhost:3306/gm3?allowMultiQueries=true",
               "test", "");
         System.out.println("... connected");

         final DatabaseMetaData meta = con.getMetaData();
         System.out.format("Driver : %s %s.%s\n", meta.getDriverName(),
               meta.getDriverMajorVersion(), meta.getDriverMinorVersion());
         System.out.format("DB     : %s %s.%s (%s)\n",
               meta.getDatabaseProductName(), meta.getDatabaseMajorVersion(),
               meta.getDatabaseMinorVersion(),
               meta.getDatabaseProductVersion());
         con.close();

      } catch (final SQLException e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
