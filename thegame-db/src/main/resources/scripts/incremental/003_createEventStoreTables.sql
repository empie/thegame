drop table event if exists;

drop table event_source if exists;

create table event_source (
	eventSourceId varchar(36) primary key, 
	eventSourceType varchar(512) not null, 
	versie bigint not null, 
	volgendVrijEventVolgnummer bigint not null);

create table event (
	eventSourceId varchar(36) not null, 
	eventVolgnummer bigint not null, 
	tijdstipToevoeging timestamp not null, 
	data LONGVARCHAR not null, 
	primary key (eventSourceId, eventVolgnummer), 
	foreign key (eventSourceId) references event_source (eventSourceId));