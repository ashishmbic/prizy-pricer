Requirement:
1) Java 1.8
2) PostGreSql

Steps to setup:

1) Restore database "jBilling" either from jBilling.sql or jBillingDB.backup.
2) Go to <path>\jBilling
3) Run command "mvn package" in cmd. This will run all the tests and will package the project in a jar and will place the jar in \target folder.
4) Execute the following command in cmd: "java -jar <path>\jBilling\target\jBilling-0.0.1-SNAPSHOT.jar"

Note: Default Server Port is 8080 and Default DB port is 5432. In case of any conflict, please make the necessary changes in "src\main\resources\application.properties". For other DB configuration changes, please edit the same file.



                                          -------Thank You-------

