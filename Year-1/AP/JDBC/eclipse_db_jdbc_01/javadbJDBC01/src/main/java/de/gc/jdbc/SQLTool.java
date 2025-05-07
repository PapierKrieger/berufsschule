package de.gc.jdbc;

import java.sql.SQLException;

public class SQLTool {

   public static boolean ignoreSQLException(final String sqlState) {

      if (sqlState == null) {
         System.out.println("The SQL state is not defined!");
         return false;
      }

      // X0Y32: Jar file already exists in schema
      if (sqlState.equalsIgnoreCase("X0Y32")) {
         return true;
      }

      // 42Y55: Table already exists in schema
      if (sqlState.equalsIgnoreCase("42Y55")) {
         return true;
      }

      return false;
   }

   public static void printSQLException(final SQLException ex) {

      for (final Throwable e : ex) {
         if (e instanceof SQLException) {
            if (!ignoreSQLException(((SQLException) e).getSQLState())) {

               // e.printStackTrace(System.err);
               System.err.println("SQLState  : " + ((SQLException) e).getSQLState());
               System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
               System.err.println("Message   : " + e.getMessage());

               Throwable t = ex.getCause();
               while (t != null) {
                  System.out.println("Cause     : " + t);
                  t = t.getCause();
               }
            }
         }
      }
   }
}
