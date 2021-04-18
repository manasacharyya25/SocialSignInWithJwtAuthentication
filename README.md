# SocialSignInWithJwtAuthentication

![image](https://user-images.githubusercontent.com/42498389/115154295-c1641680-a097-11eb-8655-23ddeac874d6.png)


# About
A Web Application that let's you authenticate using <stron>Social Sign In (Google Sign-In)</strong> and access Secure Resource from Backend Server.

Developed using Angular for Frontend Application and Spring Boot + Spring Security with JWT Authentication for Backend Server.

# Usage

## Prerequisites
<ul>
  <li>Java 8</li>
  <li>Node</li>
  <li>Angular CLI</li>
</ul>

### Build and Deploy Project

<ul>
  <strong>To Run The Frontend Application, steps to follow: </strong>
  <br />
  <br />
  
  <li>In <a href="https://github.com/manasacharyya25/SocialSignInWithJwtAuthentication/tree/main/angular-frontend/frontend-app" >angular-frontend/frontend-app</a> directory, execute </li>
  
  ```
      npm init
      npm start
  ```
  This will start the frontend Angular App in http://localost:4200
  <br />
</ul>



<ul>
  <strong>To Run the Backend Server, steps to follow:</strong>
  <br />
  <br />
  
<li>In <a href="https://github.com/manasacharyya25/SocialSignInWithJwtAuthentication/tree/main/spring-boot-backend/SSIwithJWT">spring-boot-backend/SSIwithJWT</a> directory, execute </li>
  
  ```
    gradlew build
    gradlew bootRun
 ```
 This will start Backend Spring Boot Application in http://localhost:8080
 <br />
 </ul>
 
 
 ### Test The Application From Browser
 
 <ul>
  <li> Navigate to http://localhost:4200 and click on <strong>Login With Google</strong> Button. Login to Google in the popup window.</li>

![image](https://user-images.githubusercontent.com/42498389/115154265-9a0d4980-a097-11eb-8876-1383741a6623.png)

<li>Upon Successful Login, you are redirected to Profile Page and Provided with Profile Details and Your <strong>JWT Token</strong></li>

![image](https://user-images.githubusercontent.com/42498389/115154327-e35d9900-a097-11eb-9065-8f8776531372.png)


<li>Using This JWT Token, a Request can be made to access Secure Resource from Backend Server. Click on <strong>Access Secure Resource</strong>.An Alert pops up displaying Secure Content served by the Backend.</li>
  
  ![image](https://user-images.githubusercontent.com/42498389/115154383-2586da80-a098-11eb-9d4b-c0989d492c01.png)



## Author

<strong>Manas Acharyya</strong>

  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.linkedin.com/in/manasacharyya25" target="_blank">linkedin.com/in/manasacharyya25</a></p>


 
  
