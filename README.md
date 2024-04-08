# Testing

This repo discusses about Testing and explicitly Unit Testing in Java using JUnit and Mockito

Testing.pptx gives a high level overview regarding the below topics:
1. What is Testing?
2. Why Testing?
3. Different types of testing
4. What is a Unit Test?
5. Traditional Testing vs Testing Frameworks
6. Writing Unit Test Cases in JUnit 5
   - Assertions
   - Nested Classes
   - JUnit LifeCycle Annotations
   - JUnit Additional Tags
7. Mockito - Mock Dependencies
8. Important Mockito concepts

# Session Folder

## JUnitLifeCycleAnnotationsTest:

The class aims to use JUnit 5 lifecycle annotations such as @BeforeEach, @AfterEach, @BeforeAll, and @AfterAll to execute setup and teardown activities on the code before and after the tests. The class further exploits the @Nested annotation to test for subgroups of the described MathUtils class. Test cases, including testAddition1, testAddition2, testSubtraction1, testSubtraction2, testSharedVariable, are used to test MathUtils .

## LambdaExpressions:

The class uses lambda expressions of Java, lambda expressions are used in Java to focus on the functional portion of programming. Java lambda expressions are used to define the expression of instances of a functional interface. It uses the lambda expression in iteration over a list and the use of Collections.sort() to method-wise sort the list.

## MathUtils:

The class for mathematical operations contains named functions such as addition, subtraction, multiplication, and division. The arithmetic exceptions can also be caught/divided in code by defined methods such as divide() and divideWithoutArithmeticException() . The main method is to test the code.
A main method is included for testing purposes.

## MathUtilsTest:

- This class contains unit tests for the MathUtils class, showcasing various functionalities of JUnit 5.
  It demonstrates different assertions (assertEquals, assertArrayEquals, assertIterableEquals) and exception handling (assertThrows) using @Test annotations.
  Additionally, it utilizes other JUnit annotations such as @Disabled, @Nested, @Tag, and @DisplayName to organize and label tests.

# Mockito folder

## Book:

  Represents a book entity with properties like title, author, ISBN, and price.
  Provides constructors and getter/setter methods for accessing and modifying book details.
  InventoryManager:

## InventoryManager:

  Includes methods to add, remove, update books, and check book availability.
  Utilizes a List to store books in stock.

## Order:

  Represents an order containing a list of ordered books.
  Provides methods to get and set the order ID and the list of ordered books.
  
## OrderProcessor:

  Processes orders by checking book availability in the inventory and removing them if available.
  Utilizes an InventoryManager instance to perform inventory-related operations.

## OrderProcessorTest:

 - Test class for the OrderProcessor class.
 - Uses JUnit annotations such as @BeforeEach, @Test, and @DisplayName for setup, test methods, and display names, respectively.
 - Utilizes Mockito for mocking dependencies (InventoryManager) to isolate the unit under test.
 - Demonstrates stubbing behavior using when().thenReturn() to simulate different scenarios (availability and unavailability of books).
 - Verifies method invocations using Mockito's verify() method, ensuring that the expected methods are called with the correct arguments and number of times.
 - Shows the usage of spies (spy()) to partially mock the InventoryManager and control its behavior in specific test cases.

## Running Mockito based test cases in Eclipse
### Steps
 - Click on New and select project (not Java Project)
 - Create a Maven Project, find it in the Maven section(it gives more flexibility to use more packages than Java Project), click next.
 - Select the folder where you want the location to be. (Let it be default, later you can move the content wherever you want), click next.
 - Select the below shown catalog:
   
![image](https://github.com/Dinesh0727/OOP-Testing/assets/87797118/5bcc5969-eee5-4031-9277-6b74f8909a87)

 - The group id which will be the package name and artifact name is the project name. Leave the package section blank [preferably].
 - Click Finish and then you are done creating a maven project. Wait for some time after the creation there will be src/main/java and src/test/java folders.
 - Write the code such that all the class files will be in main folder and test files in test folder
 - pom.xml is the heart of the maven project. It contains the versions and other details of the dependencies and plugins in xml format, you can add the missing dependencies here. (Check the 
   file for reference in mockito folder)
 - Right Click on the Project name and Click on "Run As" select first "Maven Build" command (Shift + Alt + X). It will take a while in the first run and some errors might show, which by 
   adding some new dependencies or importing some packages might clear them.
 - You can see the build results in the console.
   
   ![image](https://github.com/Dinesh0727/OOP-Testing/assets/87797118/7cccf3cc-9199-4903-b006-7f56fa86950f)

   

