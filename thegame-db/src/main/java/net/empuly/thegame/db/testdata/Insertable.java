package net.empuly.thegame.db.testdata;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

public abstract class Insertable {

	private boolean hasBeenInserted = false;

	public final void insert(final DataSource datasource) {
		if (!hasBeenInserted) {
			hasBeenInserted = true;
			insertThis(datasource);

			for (final Insertable row : getInsertableDependencies()) {
				row.insert(datasource);
			}
		}
	}

	protected Collection<? extends Insertable> getInsertableDependencies() {
		return new ArrayList<Insertable>();
	}

	protected abstract void insertThis(DataSource datasource);

	void reset() {
		this.hasBeenInserted = false;
		for (final Insertable row : getInsertableDependencies()) {
			row.reset();
		}

	}

}
