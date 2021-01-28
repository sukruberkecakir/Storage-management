# Storage management 
 Programming Languages Course Final Project
 
# How to run<br />
 First download the code
 SQL Server Management Studio needs to be installed on your pc.<br />
 create a database named springbootdb<br />
 In the directory of the project run cmd<br />
 Type;<br />
 gradlew.bat bootRun
 <br />
 <br />
 After starting project firstly<br />
 open applications.property file and change spring.jpa.hibernate.ddl-auto=create<br />
 "create" to "none"<br />
 open a browser and type http://localhost:8080/ <br />
 It will direct you to the home page <br />
 then register to get ADMIN role to your user via SQL <br />
 In order to use full capabilities open  SQL Server Management Studio<br />
 Open a new Query<br />
 Execute these lines in order<br />
 Firstly;<br />
insert into roles(role_name)<br />
values('USER')<br />
insert into roles(role_name)<br />
values('ADMIN')<br />
Then execute;<br />
insert into users_roles(user_id,role_id)<br />
values(1,2)<br />
insert into users_roles(user_id,role_id)<br />
values(1,2)<br />

# Keep in mind that<br />
TCP/IP protocol needs to be active and TCP Port needs to be 1433<br />
Also a login need to be created in order to reach sql server<br />
that has a name root and password 1234. It can be done in SQL Server Management Studio<br />
by right clicking logins in springbootdb. Also the server needs to e open for SQL Server authentication<br />
