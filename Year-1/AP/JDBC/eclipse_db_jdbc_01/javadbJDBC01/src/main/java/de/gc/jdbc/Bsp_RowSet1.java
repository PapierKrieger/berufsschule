package de.gc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class Bsp_RowSet1 {

	private static class ExampleListener implements RowSetListener {

		@Override
		public void cursorMoved(final RowSetEvent event) {
			System.out.println("# cursorMoved event");
		}

		@Override
		public void rowChanged(final RowSetEvent event) {
			System.out.println("# rowChanged event");
		}

		@Override
		public void rowSetChanged(final RowSetEvent event) {
			System.out.println("# rowSetChanged event");
		}
	}

	public static void main(final String[] args) {

		try {
			final Connection con = Util.getConnection("gm3");
			System.out.println("... connected");

			final CachedRowSet crs = RowSetProvider.newFactory()
					.createCachedRowSet();
			crs.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			crs.setCommand("SELECT id, name FROM mitarbeiter");
			crs.execute(con);

			crs.addRowSetListener(new ExampleListener());
			while (crs.next()) {
				System.out.print("id=" + crs.getString(1));
				System.out.println(" name=" + crs.getString(2));
			}

			Util.close(con);
		} catch (final Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}
}
