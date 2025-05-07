package de.gc.jdbc.csv;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import de.gc.jdbc.Util;

public class Bsp_cvsjdbc_PLZ1 {

   public static void main(final String[] args) {

      try {
         final Connection con = DriverManager.getConnection(
               "jdbc:relique:csv:src/main/resources/csv?separator=,");
         System.out.println("... connected");

         final DatabaseMetaData meta = con.getMetaData();

         System.out.format("DatabaseMajorVersion   : %s%n",
               meta.getDatabaseMajorVersion());
         System.out.format("DriverName             : %s%n",
               meta.getDriverName());
         System.out.format("DriverVersion          : %s%n",
               meta.getDriverVersion());
         System.out.format("JDBCMajorVersion       : %s%n",
               meta.getJDBCMajorVersion());
         System.out.format("JDBCMinorVersion       : %s%n",
               meta.getJDBCMinorVersion());

         Util.close(con);
      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
