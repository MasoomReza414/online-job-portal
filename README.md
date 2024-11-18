# online-job-portal
Online Job Portal
This is a simple Job Portal application built using Java. It allows users to register as either Employers or Job Seekers. Employers can post job listings, and Job Seekers can apply for jobs. The application runs in the console and is designed for educational purposes. It demonstrates basic concepts like user registration, job posting, and job applications.

Features
User Registration: Users can register as either an Employer or a Job Seeker.
Login: Registered users can log in using their username and password.
Job Posting: Employers can post new job listings with details such as job title, description, company, and location.
Job Viewing: Job Seekers can view all available job listings.
Job Application: Job Seekers can apply for jobs directly from the available listings.
Requirements
Java (Version 8 or higher) installed on your machine.
A terminal or command line interface to run the application.
Getting Started
Follow these steps to set up and run the project locally:

1. Clone the Repository
If you're using Git, you can clone this repository to your local machine using the following command:

bash
Copy code
git clone https://github.com/yourusername/job-portal.git
2. Compile the Java Code
Navigate to the directory where the project files are located. Then compile the Java files:

bash
Copy code
javac JobPortal.java
This will generate the .class files for each of the classes in the project.

3. Run the Application
After compiling, you can run the application with the following command:

bash
Copy code
java JobPortal
4. Using the Application
Once the program is running, you'll be presented with a menu of options:

Register User: Allows a new user to register as either an Employer or Job Seeker.
Login: Allows registered users to log in with their username and password.
Post Job (For Employers): Allows an Employer to post a new job listing.
View Jobs (For Job Seekers): Displays all available job listings.
Apply for Job (For Job Seekers): Allows a Job Seeker to apply for a job by entering the job ID.
Exit: Exits the application.
Example Workflow
Register as a Job Seeker with a username and password.
Log in as the registered Job Seeker.
Register as an Employer and log in with the Employer credentials.
Post a new job.
View available jobs as the Job Seeker.
Apply for a job by entering the job ID.
Code Overview
Classes in the Project
Job.java: Represents a job listing with attributes such as title, description, company, and location. Each job has a unique ID.

User.java: Represents a user (either an Employer or a Job Seeker). It includes functionality for user registration, login, and applying for jobs.

JobPortal.java: The main class that drives the application. It handles the user interface and manages the job listings and user interactions. This class contains:

Methods for registering users, logging in, posting jobs, viewing jobs, and applying for jobs.
A simple text-based user interface in the terminal.
Limitations
No Persistence: Data is not saved permanently. If you close the application, all data (users and job listings) will be lost.
No Validation: There is minimal validation of inputs. For example, users can register with the same username multiple times without any warnings.
No Password Security: Passwords are stored in plain text. For production use, you should hash and securely store passwords (e.g., using bcrypt).
Future Enhancements
Database Integration: Connect the application to a database (e.g., MySQL or SQLite) to persist user and job data.
Password Security: Implement password hashing and secure login methods to protect user credentials.
User Interface (UI): Develop a graphical user interface (GUI) or web-based UI for a better user experience using JavaFX or a web framework like Spring Boot.
Role-Based Access Control: Add more advanced role-based access where Employers can only post jobs and Job Seekers can only apply for them.
Contributing
If you have suggestions or improvements, feel free to fork the repository and submit a pull request. Contributions are welcome!

How to Contribute
Fork the repository.
Clone your fork to your local machine.
Create a new branch for your changes.
Make your changes and commit them.
Push your changes to your forked repository.
Open a pull request to the main repository.
