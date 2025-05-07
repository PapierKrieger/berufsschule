package de.gc.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Bsp_Statement {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         final DatabaseMetaData meta = con.getMetaData();
         System.out.format("%s %s.%s (%s)\n", meta.getDatabaseProductName(),
               meta.getDatabaseMajorVersion(), meta.getDatabaseMinorVersion(),
               meta.getDatabaseProductVersion());
         System.out.println("TYPE_FORWARD_ONLY       : "
               + meta.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
         System.out.println("TYPE_SCROLL_INSENSITIVE : "
               + meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
         System.out.println("TYPE_SCROLL_SENSITIVE   : "
               + meta.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
         System.out.println("TYPE_FORWARD_ONLY       + CONCUR_READ_ONLY   : "
               + meta.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY));
         System.out.println("TYPE_FORWARD_ONLY       + CONCUR_UPDATABLE   : "
               + meta.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_UPDATABLE));
         System.out.println("TYPE_SCROLL_INSENSITIVE + CONCUR_READ_ONLY   : "
               + meta.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY));
         System.out.println("TYPE_SCROLL_INSENSITIVE + CONCUR_UPDATABLE   : "
               + meta.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE));
         System.out.println("TYPE_SCROLL_SENSITIVE   + CONCUR_READ_ONLY   : "
               + meta.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_READ_ONLY));
         System.out.println("TYPE_SCROLL_SENSITIVE   + CONCUR_UPDATABLE   : "
               + meta.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE));
         Util.close(con);
      } catch (final Exception e) {
         System.out.println("Fehler: " + e.getMessage());
      }
   }
}
