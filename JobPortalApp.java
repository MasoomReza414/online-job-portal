import java.util.*;

public class JobPortalApp {

    // Job Class
    public static class Job {
        private String title;
        private String description;
        private String company;
        private String location;

        // Constructor
        public Job(String title, String description, String company, String location) {
            this.title = title;
            this.description = description;
            this.company = company;
            this.location = location;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getCompany() {
            return company;
        }

        public String getLocation() {
            return location;
        }

        @Override
        public String toString() {
            return "Job [Title=" + title + ", Description=" + description + ", Company=" + company + ", Location=" + location + "]";
        }
    }

    // User Class
    public static class User {
        private String name;
        private String email;
        private String userType;  // Either "seeker" or "employer"

        // Constructor
        public User(String name, String email, String userType) {
            this.name = name;
            this.email = email;
            this.userType = userType;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getUserType() {
            return userType;
        }

        @Override
        public String toString() {
            return "User [Name=" + name + ", Email=" + email + ", UserType=" + userType + "]";
        }
    }

    // JobPortal Class
    public static class JobPortal {
        private Map<String, User> users;        // email -> User
        private List<Job> jobListings;          // List of jobs posted by employers

        public JobPortal() {
            users = new HashMap<>();
            jobListings = new ArrayList<>();
        }

        // Register a user
        public void registerUser(String name, String email, String userType) {
            if (!users.containsKey(email)) {
                users.put(email, new User(name, email, userType));
                System.out.println("User registered successfully!");
            } else {
                System.out.println("User with this email already exists.");
            }
        }

        // Post a job
        public void postJob(String email, String title, String description, String company, String location) {
            User user = users.get(email);
            if (user != null && "employer".equals(user.getUserType())) {
                Job job = new Job(title, description, company, location);
                jobListings.add(job);
                System.out.println("Job posted successfully!");
            } else {
                System.out.println("Only employers can post jobs.");
            }
        }

        // View all jobs
        public void viewJobs() {
            if (jobListings.isEmpty()) {
                System.out.println("No jobs available.");
            } else {
                for (Job job : jobListings) {
                    System.out.println(job);
                }
            }
        }

        // Apply for a job
        public void applyForJob(String email, String jobTitle) {
            User user = users.get(email);
            if (user != null && "seeker".equals(user.getUserType())) {
                boolean found = false;
                for (Job job : jobListings) {
                    if (job.getTitle().equalsIgnoreCase(jobTitle)) {
                        found = true;
                        System.out.println(user.getName() + " applied for the job: " + jobTitle);
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Job not found.");
                }
            } else {
                System.out.println("Only job seekers can apply for jobs.");
            }
        }
    }

    // Main Class (entry point)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JobPortal portal = new JobPortal();

        while (true) {
            System.out.println("\nWelcome to the Job Portal");
            System.out.println("1. Register");
            System.out.println("2. Post a Job");
            System.out.println("3. View Jobs");
            System.out.println("4. Apply for a Job");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Register a user
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter user type (seeker/employer): ");
                    String userType = scanner.nextLine();
                    portal.registerUser(name, email, userType);
                    break;

                case 2:
                    // Post a job (only employers can do this)
                    System.out.print("Enter your email: ");
                    String employerEmail = scanner.nextLine();
                    System.out.print("Enter job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.print("Enter job description: ");
                    String jobDescription = scanner.nextLine();
                    System.out.print("Enter company name: ");
                    String company = scanner.nextLine();
                    System.out.print("Enter job location: ");
                    String location = scanner.nextLine();
                    portal.postJob(employerEmail, jobTitle, jobDescription, company, location);
                    break;

                case 3:
                    // View all jobs
                    portal.viewJobs();
                    break;

                case 4:
                    // Apply for a job (only seekers can do this)
                    System.out.print("Enter your email: ");
                    String seekerEmail = scanner.nextLine();
                    System.out.print("Enter job title to apply for: ");
                    String jobToApply = scanner.nextLine();
                    portal.applyForJob(seekerEmail, jobToApply);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

