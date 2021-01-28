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
by clicking security then right clicking logins in springbootdb. It needs to be created for SQL server Authentication.<br />
Also the server needs to e open for SQL Server authentication<br />
# Screenshots to help<br />
How to create user.<br />
![springbootdb 1](https://user-images.githubusercontent.com/77251099/106119509-5a088b80-6166-11eb-9659-d7eab3a7a4f0.png)<br />
![springbootdb 2](https://user-images.githubusercontent.com/77251099/106119512-5b39b880-6166-11eb-85e0-fe5d772fb642.png)<br />
![springbootdb 3](https://user-images.githubusercontent.com/77251099/106119511-5aa12200-6166-11eb-9cd9-7f1e08e33c01.png)<br />
How to open SQL Server Authentication<br />
![springbootdb 4](https://user-images.githubusercontent.com/77251099/106119915-c97e7b00-6166-11eb-8e10-118a528f0875.png)<br />
![springbootdb 5](https://user-images.githubusercontent.com/77251099/106119919-ca171180-6166-11eb-8d83-f0416381cfdf.png)

