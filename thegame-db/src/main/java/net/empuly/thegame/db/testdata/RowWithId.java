package net.empuly.thegame.db.testdata;

public abstract class RowWithId<SomeIdType extends Object> extends Row {
	
	private SomeIdType id;
	
	public RowWithId(String tableName) {
		super(tableName);
	}
	
	protected void withId(SomeIdType id) {
		this.id =id;
	}
	
	public SomeIdType getId() {
		return id;
	}

}
