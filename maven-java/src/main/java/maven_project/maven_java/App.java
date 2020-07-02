package maven_project.maven_java;

/*
 * Importance of Maven in framework development:-
 * 
 * Maven is a Java tool, so you must have Java installed in order to proceed.
 * 
 * Maven is a software project management, the project u r working on.
 * Used to manage and maintain the project.
 * It also acts a build management tool for java frameworks.
 * 
 * Why Maven?
 * 
 * 1) central repository to get dependencies: https://mvnrepository.com/ (Java Build path jars dependency adding should be avoided)(maven will automatically connect with mavenrepository.com and download all the jars)
 * 			<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
			<dependency>
			    <groupId>org.seleniumhq.selenium</groupId>
			    <artifactId>selenium-java</artifactId>
			    <version>3.141.59</version>
			</dependency>
	The src/main/java directory contains the project source code, the src/test/java directory contains the test source, and the pom.xml file is the project's Project Object Model, or POM.

 * 2) maintaining common structure across the organization
 * 3) Flexibility in integrity with CI Tools (A build management tool (like maven) is must required to integrate with CI Tools (like jenkins))
 * 4) Plugins for test framework execution
 * 
 * The POM
   The pom.xml file is the core of a project's configuration in Maven. It is a single configuration file that contains the majority of information required to build a project in just the way you want. The POM is huge and can be daunting in its complexity, but it is not necessary to understand all of the intricacies just yet to use it effectively. This project's POM is:
 * 
 * 
 * Maven Phases:-
 
	Although hardly a comprehensive list, these are the most common default lifecycle phases executed.
	
	validate: validate the project is correct and all necessary information is available
	(Important) compile: compile the source code of the project (Benifitial when running through jenkins to see error logs)
	
	(Important) test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
	test command will first check in local project, if it not present in local then it will connect to mavenrepository to download dependencies.
	 
	package: take the compiled code and package it in its distributable format, such as a JAR.
	integration-test: process and deploy the package if necessary into an environment where integration tests can be run
	verify: run any checks to verify the package is valid and meets quality criteria
	install: install the package into the local repository, for use as a dependency in other projects locally
	deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.
	There are two other Maven lifecycles of note beyond the default list above. They are
	
	(Important) clean: cleans up artifacts created by prior builds
	site: generates site documentation for this project
	
	
	Maven terminologies:-
	GroupId: this will identify your project uniquely across all projects.
	ArtifactId: is the sub project of the group id. ArtifactId is a file, usually a JAR, that gets deployed to maven repository
 	ArtifactId is basically the Project name.
 	
 	Maven project: type: maven-archetype-quickstart should be used.
 	
 	MAVEN-SURE FIRE PLUGIN IS USED TO RUN ALL THE TESTCASES FROM MAVEN PROJECT
 	
 	test/java must have filenames as abcTest.java must be end with *Test.java
 */

/*Integrate TestNg with Maven:-
 * 
 * https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html
 * 
 * Using Suite XML Files
	Another alternative is to use TestNG suite XML files. This allows flexible configuration of the tests to be run. These files are created in the normal way, and then added to the Surefire Plugin configuration:
 * sure-fire plugin is used to run all the tests with maven
 * 
 * to integrate/run testng with maven, surefire-plugin
 * 
 * add <configuration> tag to surefireplugin, in pom.xml
 * 
 *  
 *  <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.0.0-M5</version>
	          <configuration>
		          <suiteXmlFiles>
		            <suiteXmlFile>testng.xml</suiteXmlFile>
		          </suiteXmlFiles>
	          </configuration>
        </plugin>
 */

/* Switching the tests with maven profiling:-
 * 
 * if we have two testng.xml files one having smoke tests and one having all regression tests
 * 
<profiles>
	<profile>
		<id>regression</id>
		<build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <!-- 3) -->
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.0.0-M5</version>
	          <configuration>
		          <suiteXmlFiles>
		            <suiteXmlFile>testng.xml</suiteXmlFile>
		          </suiteXmlFiles>
	          </configuration>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
	</profile>
	<profile>
		<id>smoke</id>
		<build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <!-- 3) -->
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.0.0-M5</version>
	          <configuration>
		          <suiteXmlFiles>
		            <suiteXmlFile>testng.xml</suiteXmlFile>
		          </suiteXmlFiles>
	          </configuration>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
  
	</profile>
</profiles>

TO RUN :-
mvn test -P smoke
mvn test -P regression

 * 
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

