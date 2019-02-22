Deliverable 4 is a combination of JDBC access between java and a mysql database.
We use JavaFX to create a GUI which gathers user input and sends it to a mysql
database via JDBC to get a result.

As of this moment (Fri, Feb 22) the program takes two command line arguments.
   - First, the url of the database
     - "jdbc:mysql://localhost:<port>/<DB>"
     - Note <port> and <DB>. I'm pretty sure the port is optional, and the DB
       is whatever you've named the DB on your system. Mine is TripleCrown.
     - You may notice that I didn't include all the other things that
       are concatenated on the end of the url in the examples, those can be
       used or omitted, your choice.
       
   - Second argument is the driver location
     - com.mysql.cj.jdbc.Driver
     
To execute queries via the command line:

java -cp lib/mysql-connector-java-8.0.15.jar:classes ser322.TripleCrownDatabase "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&&useSSL=false&&allowPublicKeyRetrieval=true &&useLegacyDatetimeCode=false&&serverTimezone=America/New_York" root Millie6667! com.mysql.cj.jdbc.Driver

If you have ant installed on your system:
   - Use "ant targets" to get a list of targets
   - Use "ant execute"
