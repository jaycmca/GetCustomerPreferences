# GetCustomerPreferences
Spring Boot GET Rest API example
1. What we’ll build
We will build Customer Preferences RESTFul APIs for a Simple Customer Preferences Management System using Spring Boot 2 JPA and MySQL. Following are three REST APIs (Controller handler methods) are created for Customer.

 1.1 GET http://localhost:8080/customer/v1/get-customer-preferences/{id} 
 
 1.2 GET http://localhost:8080/customer/v1/get-customer-preferences?emailId={emailId}&phoneNumber={phoneNumber}
  
2. Tools and Technologies Used
Spring Boot - 2.0.5.RELEASE
JDK - 11
Spring Framework - 5.0.8 RELEASE
Hibernate - 5.2.17.Final
JPA
Maven - 3.2+
IDE - Eclipse or Spring Tool Suite (STS)

**3. Creating and Importing a Project**
There are many ways to create a Spring Boot application. The simplest way is to use Spring Initializr at http://start.spring.io/, which is an online Spring Boot application generator.
![image](https://user-images.githubusercontent.com/89606757/131078515-bc3cc9b3-5bbe-4444-9ea4-f7e8ae9444fd.png)

Look at the above diagram, we have specified the following details:
Generate: Maven Project
Java Version: 11
Spring Boot:2.0.5
Group: customer.preferences
Artifact: customerPreferences
Name: customerPreferences
Description: Rest API for a Customer Preferences management
Package Name : com.sample.microservice.get.customer.preferences
Packaging: jar (This is the default value)
Dependencies: Web, JPA, MySQL, DevTools
Once, all the details are entered, click on Generate Project button will generate a spring boot project and downloads it. Next, Unzip the downloaded zip file and import it into your favorite IDE.

**4. Running Application**
This spring boot application has an entry point Java class called SpringBootCrudRestApplication.java with the public static void main(String[] args) method, which you can run to start the application.
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
@SpringBootApplication is a convenience annotation that adds all of the following:
@Configuration tags the class as a source of bean definitions for the application context.
@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
@ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.
The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.

**5. Testing REST APIs via Postman Client**

  1. get customer preferences using created id

  ![image](https://user-images.githubusercontent.com/89606757/131079742-52ca300e-0558-4172-8745-aceb04eeae3a.png)

  
  2. get customer preferences using email id and phone number

  ![image](https://user-images.githubusercontent.com/89606757/131079637-3adef5de-284c-4999-9221-0ff726f4d1ad.png)


