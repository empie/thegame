--SpelId is PK van SpelSnapshot tabel --> ineens unique + index
ALTER TABLE spelSnapshot ADD PRIMARY KEY (spelId);