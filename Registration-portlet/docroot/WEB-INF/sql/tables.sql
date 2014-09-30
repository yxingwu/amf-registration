create table amf_MonitorEvent (
	eventId LONG not null primary key,
	userId LONG,
	ip VARCHAR(75) null,
	eventDate DATE null,
	eventType INTEGER
);