package net.empuly.thegame.db.testdata;

import javax.sql.DataSource;

public class ForeignKey<Id extends Object, someRowType extends RowWithId<Id>> {

	private someRowType someRow;

	private ForeignKey() {
	}

	public static <Id extends Object, someRowType extends RowWithId<Id>> ForeignKey<Id, someRowType> foreignKey(someRowType value) {
		ForeignKey<Id, someRowType> foreignKey = new ForeignKey<Id, someRowType>();
		foreignKey.setRow(value);
		return foreignKey;
	}

	public static <Id extends Object, someRowType extends RowWithId<Id>> ForeignKey<Id, someRowType> foreignKey() {
		return new ForeignKey<Id, someRowType>();
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
