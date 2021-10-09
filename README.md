# BloodBank-BE (Java Spring/Boot Application with SQL Server database)

IDE - Eclipse:
	1. Go to Help > Eclipse Marketplace...
	2. In the Search tab, search for "Spring Tools".
	3. Install the Spring Tools Suite (Spring Tools 4 - 4.12.0.RELEASE, at the time of this documentation).

Bootstrapping the application:
	1. Go to File > New > Project...
	2. In the wizard opened, select Spring Boot > Spring Starter Project and click "Next".
	3. Details filled:
		a) Type - Maven Project
		b) Packaging - Jar
		c) Java Version - 17
		d) Language - Java
		e) Enter all the other fields and click Next
	4. In the dependencies wizard, the dependencies selected:
		a) Java Mail Sender
		b) MS SQL Server Driver
		c) Spring Boot Actuator
		d) Spring Boot Dev Tools
		e) Spring Data JPA
		f) Spring Web
		g) Spring for Apache Kafka
Initial Configurations to run the application:
	1. Update application.properties with the connection to database
		a) spring.datasource.url=jdbc:sqlserver://<server_name>;databaseName=<db_name>;integratedSecurity=true
		b) spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
		c) spring.jpa.hibernate.ddl-auto = none
	2.  Connecting Java (JDBC) to SQL Server needs "mssql-jdbc_auth" dll file.
		Since Java 17 is used, download mssql-jdbc_auth-9.2.1.x64.dll from official microsoft JDBC downloads
		and place it in Java's bin folder (Java > jdk-17 > bin)
Now the application should run with no issues