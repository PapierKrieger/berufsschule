package de.gc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bsp_Ex2 {

   public static void main(final String[] args) {

      try {
         final Connection con = Util.getConnection("gm3");
         System.out.println("... connected");

         final Statement st = con.createStatement();
         final ResultSet rs = st.executeQuery("SELECT * FROM GIBTESNICHT");

         Util.close(con);
      } catch (final SQLException e) {
         SQLTool.printSQLException(e);
      }
   }
}
