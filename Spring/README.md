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

2. JDBC - Java Database Connectivity: Done.

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

3. Spring Framework: 

        IoC - Inversion of Control - As a developer, you don't want to have control over creation, maintenance and deletion of objects. You delegate the control work to Spring. For this, Spring has IoC container. // This is a principle.

        DI - Dependency Injection - Injecting dependencies such as classes, objects, etc,. 

        // This is Design Pattern concepts.

    Implement Dependency Injection using Spring Boot:

        Get the ApplicationContext by the return of the SpringApplication.run() method. This gives you access to the IoC container. 

            ApplicationContext context = SpringApplication.run(******);

        Create a class and annotate it as @Component - This tells Spring that spring should manage this object and not the developer. 

        Get the object from Spring using: <Class-name> <object-name> = context.getBean(<Class-name>.class); // The same as Coder coder = new Coder

        Use the @Autowired annotation to make Spring automatically associate a field with classes that have been annotated as components

        main function has the application context to getBeans from, other classes don't need this context, so we use @Autowired

    Understanding Spring Framework: 

        Using only Spring doesn't give you the context object and other annotation tools. You need to configure them manually

        Manually inject spring context dependency into the maven project. 

        Learn to use XML to get the context:

            new ClassPathXmlApplicationContext(); // will create a container for you and give you the context. 

            Create an XML file in the resources folder in main folder {

                <beans xmlns="http://www.springframework.org/schema/beans"

                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

                xsi:schemaLocation="http://www.springframework.org/schema/beans

                https://www.springframework.org/schema/beans/spring-beans.xsd">

                    <bean id="coder" class="com.octavioi.Coder"></bean> // They are referenced in singleton scope. i.e: For any call to getBeans we get the same object. Alternatively, we declare scope to be prototype, if we want a new object to be created everytime we get Beans.

                    <bean id="<id>" class="com.<package>.<class-name>" scope="prototype"></bean> // Prototype bean

                    <bean id="laptop" class="com.octavioi.Laptop"></bean>  // These define the objects that Spring needs to handle.

                    // You can also assign values to fields in a class. 

                    <bean id="laptop" class="com.octavioi.Laptop">
                        <property name="cores" value="4"></property> // This is setter injection - The property should have a setter value is used for primitive types
                        <property name="cores" ref="core1"></property> // ref is used for object injection into a field - core1 should be id of another bean

                        <constructor-arg ref="laptop"/> // This is constructor injection, we can pass values to constructor 

                        // Constructor arguments should be in sequence
                    </bean> 

                    // You can also specify autowire="byName" for any property names to be autowired by the name of their ids. you can also autowire by type. 
                    // If there is ambiguity, use the primary="true" in one of the ambiguous objects for it to take preference. 
                    // Explicit passing of reference will take precedence over any autowiring. Autowiring doesn't need explicit reference 

                    <bean id="desktop" class="com.octavioi.Desktop" lazy-init="true"/> // Lazy-Init makes sure that the object isn't initialized until the point it used

                    // You can get bean byType or byName

                    // If only one object needs a bean, you shouldn't declare it for the whole App.
                    // In that case, we declare it in an Inner Bean

                    <bean id="laptop1" class="com.octavio.Laptop">
                        <property name="core">
                            <bean id="core1" class="com.octavioi.Core"/>
                        </property>
                    </bean>
                    


                </beans>
            }
    
        Learn to use Java Config to get the context:
            
            Create a Java File and pass it as an argument to AnnotationConfigApplicationContext() constructor to get context from config file. 

            In the file, you can define beans as methods {
                
                @Bean

                public <ClassName> <default-bean-name/method-name>() {
            
                    return new <class-constructor>();
            
                }
            
            }

            Bean annotations can also have arguments to specify name of bean

            You can also change the scope of Bean with @Scope annotation {
                
                @Bean

                @Scope(value="prototype")
            
            }

            // By default Scope is singleton - only one object is created.

            // Prototype creates a new object everytime getBean is called on this Bean.

            Create a Bean with other objects. You can pass one method to another. 

            // @Primary annotation can be used to define primary bean in case of ambiguity. 

            // @Qualifier("id/name") annotation can also be used in case of ambiguity

        Learn to use Annotations only:

            Here, you define within the Class that they should be used by Spring and Spring will pick up on it

            Use @Component on your classes to let Spring know to manage them. 

            Use @Primary on your classes to specify preference in case of ambiguity

            Use @ComponentScan("base-package-name") in the config file to scan the files for the above mentioned annotations

            @Component("name") can be used to give bean names

            Use @Scope on your classes to declare scope - singleton/prototype

            Use @Value("value") on your fields to provide default value

4. Do the above project using spring boot:

    The same annotations need to be used, but this time Spring Boot will automatically configure everything based on our annotations

    You can use @Service instead of @Component for classes that handle logic and does the service

    @Repository can be used for components that reach out to other stuff, like API/Database

5. Make a JDBC project using Spring:

    Create a Maven Spring Project with 2 dependencies:

        1. JDBC API

        2. RDBMS Driver (h2)
    
    Create a Student class for which data needs to be stored in the database.

    Create a "schema.sql" file to congigure/set up the database - only use it to configure the database

    Create a "data.sql" to populate the database initially - Use Insert/other commands here. 

    These are used to create a embedded database like h2. 

    For external databases like MySQL:

        import dependencies by adding them to the pom.xml file

        Add spring.datasource.url, spring.datasource.username, spring.datasource.password, spring.datasource.driver-class-name in the application.properties file in the resources. 

        This will be used to connect to an external database. 

    Create a JDBCTemplate object and autowire it so that Spring manages it. 

    Use .query() and .update() to get or manipulate data in database respectively. 

    .query() takes in a RowMapper lambda function that maps each table colomn to a format which we require and returns a list in this format.




