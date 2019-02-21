Deliverable 4 is a combination of JDBC access between java and a mysql database.
We use JavaFX to create a GUI which gathers user input and sends it to a mysql
database via JDBC to get a result.

To execute queries via the command line:
QUERY 1:
java -cp lib/mysql-connector-java-8.0.15.jar;. ser322.TripleCrownDatabase "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&&useSSL=false&&allowPublicKeyRetrieval=true &&useLegacyDatetimeCode=false&&serverTimezone=America/New_York" root Millie6667! com.mysql.jdbc.Driver query1

QUERY 2:
java -cp lib/mysql-connector-java-8.0.15.jar;. ser322.TripleCrownDatabase "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&&useSSL=false&&allowPublicKeyRetrieval=true &&useLegacyDatetimeCode=false&&serverTimezone=America/New_York" root Millie6667! com.mysql.jdbc.Driver query2 569

INSERT:
java -cp lib/mysql-connector-java-8.0.15.jar;. ser322.TripleCrownDatabase "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&&useSSL=false&&allowPublicKeyRetrieval=true &&useLegacyDatetimeCode=false&&serverTimezone=America/New_York" root Millie6667! com.mysql.jdbc.Driver insert 6 4 65

If you have ant installed on your system:
   - Use "ant targets" to get a list of targets
   - Default execution of the application connects to the database using
     user: root, pass: root and executes query1
   - Use "ant execute -Duser=<yourUserName> -Dpass=<yourPass> -Dmethod=<method>"
     if you want to run a different method, or your login credentials are not
     root, root
