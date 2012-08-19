package net.empuly.thegame.db.testdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Scope("prototype")
public class TestDataInserter {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private LokaleDatabank lokaleDatabank;

	private List<Insertable> insertables = new ArrayList<Insertable>();

	public void clearAndInsert() {
		for (final Insertable insertable : insertables) {
			insertable.reset();
		}

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(final TransactionStatus status) {
				lokaleDatabank.deleteAll();
				insertInsertables();
			}

			
		});
	}

	public void executeQuery(final String query) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(final TransactionStatus status) {
				final Map<String, Object> hashMap = new HashMap<>();
				jdbcTemplate.queryForLong(query, hashMap);
			}
		});
	}
	
	

	public void insert() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(final TransactionStatus status) {
				insertInsertables();
			}
		});
	}

	public TestDataInserter with(final Insertable... insertables) {
		return with(Arrays.asList(insertables));
	}
	
	private void insertInsertables() {
		for (final Insertable insertable : insertables) {
			insertable.insert(datasource);
		}
	}

	private TestDataInserter with(final List<Insertable> insertables) {
		this.insertables = insertables;
		return this;
	}

	public void clear() {
		for (final Insertable insertable : insertables) {
			insertable.reset();
		}

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(final TransactionStatus status) {
				lokaleDatabank.deleteAll();
			}

			
		});
		
	}

}
