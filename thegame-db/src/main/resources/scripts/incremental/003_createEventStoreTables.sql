drop table Event if exists;

drop table EventSource if exists;

create table EventSource (
	eventSourceId varchar(36) primary key, 
	eventSourceType varchar(512) not null, 
	versie bigint not null, 
	volgendVrijEventVolgnummer bigint not null);

create table Event (
	eventSourceId varchar(36) not null, 
	eventVolgnummer bigint not null, 
	tijdstipToevoeging timestamp not null, 
	data LONGVARCHAR not null, 
	primary key (eventSourceId, eventVolgnummer), 
	foreign key (eventSourceId) references EventSource (eventSourceId));