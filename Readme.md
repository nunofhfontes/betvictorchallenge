
This project was made by Nuno Fontes, 14/08/2017 Lisbon Portugal

Spring Boot was adopted since no specific Java framework was required.

For data persistence, Postgresql was used.
The Summary object is persisted, therefore it must be defined on the database. Summary object can be found
on com.challenge.domain package

Database summary table:

id -> serial
insertiondate ->	timestamp
freqword -> text
avgparagrize ->	float8
avgparagproctime -> float8
totalprocessingtime -> float8



