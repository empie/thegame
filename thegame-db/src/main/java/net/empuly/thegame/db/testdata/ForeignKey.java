package net.empuly.thegame.db.testdata;

import javax.sql.DataSource;

public class ForeignKey<Id extends Object, someRowType extends RowWithId<Id>> {

	private someRowType someRow;

	private ForeignKey() {
	}

	public static <I extends Object, S extends RowWithId<I>> ForeignKey<I, S> foreignKey(S value) {
		ForeignKey<I, S> foreignKey = new ForeignKey<I, S>();
		foreignKey.setRow(value);
		return foreignKey;
	}

	public static <I extends Object, S extends RowWithId<I>> ForeignKey<I, S> foreignKey() {
		return new ForeignKey<I, S>();
	}

	public void setRow(someRowType someRow) {
		this.someRow = someRow;
	}

	public someRowType getSomeRow() {
		return someRow;
	}

	public Id insertAndGetId(DataSource datasource) {
		if (someRow == null) {
			return null;
		}
		someRow.insert(datasource);
		return someRow.getId();
	}

}

