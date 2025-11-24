create table College_Student (
	studentId LONG not null primary key,
	name VARCHAR(75) null,
	branch VARCHAR(75) null,
	year INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);