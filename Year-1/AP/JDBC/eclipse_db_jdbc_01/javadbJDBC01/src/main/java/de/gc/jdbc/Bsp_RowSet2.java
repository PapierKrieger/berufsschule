package de.gc.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class Bsp_RowSet2 {

	public static void main(final String[] args) {

		try {
			final Connection con = Util.getConnection("gm3");
			System.out.println("... connected");

			final WebRowSet wrs = RowSetProvider.newFactory()
					.createWebRowSet();
			wrs.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			wrs.setCommand("SELECT * FROM mitarbeiter");
			wrs.execute(con);

			wrs.writeXml(new FileOutputStream("target/rowset.xml"));
			System.out.println("Datei erzeugt");

			Util.close(con);
		} catch (final Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}
}
