References - 

Udemy - Spring Framework 6 and Spring Boot 3

Progress: 

1. Maven: Done.

        Understand what Maven does - Project Management and Comprehension tool - Helps with handling Dependencies, Compiling, Running, Debugging, Testing, Packaging and Deploying

        Command Line Option is available

        Most popular IDEs have build-in Maven support - VSCode, IntelliJ, Eclipse, etm., 

        Any Configuration changes you need to make should be made in the "pom.xml" file

        pom.xml is simplified. An advanced version with more control is hidden by default. Right Click -> Maven -> Effective POM to see the POM that Maven uses internally.  Any changes in POM is reflected in Effective POM.

    Create a new Maven Project "MavenDemo"

    Practice updating the xml file:

        Add a dependency - In this case I've added a Mysql connector to the xml file

        Reloading the Maven build, adds the dependencies to the source. 

    Learn about Archetypes:

        Archetypes are pre-built configurations that work for certain types of application. ex: Webapp architech will already have the structure of a webapp and will import the necessary dependencies. You can make changes if necessary. 

    Dependencies: 

        Dependencies are stored in the .m2 file in your system. In Linux it is in the root folder. "~/.m2"

2. JDBC - Java Database Connectivity: 

        It is an API - that gives you the ability to connect to a database from your Java application. 

        The companies that make RDBMS (Relational DataBase Management System) are responsible for updating the implementation of the connectivity, and we as developers are only given the interface that works with the implementation. 

    Set up a database "appdb"

    Create a Java Project "JDBCproject"

    Import the JDBC driver for the particular DBMS, in this case mysql by adding it to the Maven pom.xml file. 

    Import Java SQL classes:

        import java.sql.*;

    Create a connection:

        Connection connection = DriverManager.getConnection(<host>, <user>, <pass>)

        // Host - "jdbc:<dbms-name>://<hostname>:<port>/<database-name>"

        // ex: jdbc:mysql://localhost:3306/appdb

    Create a Statement:

        Statement statement = connection.createStatement();

        PreparedStatement statement = connection.prepareStatement(sql-query);

        // PreparedStatement, unlike Statement can be defined once and the values can be changed before execution using .setInt, .setString. ? is used as a placeholder for values. 

    Execute Statement:

        ResultSet output = statement.executeQuery(<sql-query>); // executeQuery reads the data from database according to query and returns a table. SELECT statement goes here 

        boolean status = statement.execute(<sql-query>); // UPDATE, DELETE, ALTER, INSERT queries go here. - Anything that affects the database. 

    Process Data:

        output.next() - Goes to the next row. 

        output.getString("<column-name>"); // Returns the data in the selected row in the passed column. 

        getInt() - returns int. 

    Close Connection:

        connection.close();

