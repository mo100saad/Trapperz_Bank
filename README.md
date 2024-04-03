# Trapperz_Bank
Trapperz Bank is a sophisticated virtual banking software developed in Java, employing the Swing library for its graphical user interface. This elaborate system simulates a real-world banking environment, enabling users to perform a range of operations such as creating and managing customer accounts. Central to the application is the Bank class, which orchestrates client and account management, including adding and removing clients, showcasing the application of object-oriented programming principles like encapsulation, inheritance, and polymorphism.

A key feature of the software is its robust client management system, through the Client class, where each client is uniquely identified and capable of holding multiple accounts. Financial transactions within these accounts are facilitated by the Account class, supporting credit (deposit) and debit (withdrawal) functions.

Critical to the software's functionality is the implementation of File Input/Output operations, enabling the persistence of bank data. This feature ensures that client information can be stored and retrieved upon application restarts, maintaining data integrity and continuity. This persistence is crucial for simulating a realistic banking experience where user data persists across sessions.

Administrative features are encapsulated within the AdminUser class, which secures administrative access through authentication, further enhancing the software’s security measures. The user interface is divided into several frames (ClientFrame, NewClientFrame, FindClientFrame, AccountFrame, WelcomeFrame, AboutFrame), each dedicated to specific banking tasks such as client account creation, management, and data retrieval.

The application is initiated through the Trapperz_Bank main class, which loads the WelcomeFrame as the entry point, inviting users to engage with the banking system. Trapperz Bank stands as a comprehensive demonstration of advanced Java programming and design patterns, enriched with a file-based data persistence mechanism to ensure a seamless and continuous banking experience.

## Run Locally
- test
- Extract the ZIP File: Unzip the downloaded project file to your desired location on your computer.
- Install Java Development Kit (JDK): Ensure you have Java JDK installed on your machine. If not, download and install it from the official Oracle website or adopt OpenJDK.
- Install NetBeans IDE: Download and install NetBeans IDE from the official website if you haven't already. NetBeans is required for running Java Swing projects.
- Open NetBeans IDE: Launch NetBeans IDE on your computer.
+ Open the Project:
  + Select "File" > "Open Project" from the NetBeans menu.
  + Navigate to the directory where you extracted the ZIP file.
  + Select the project folder (look for the folder with the NetBeans project icon) and click "Open Project".
- Resolve Dependencies (if any): Check if there are any unresolved dependencies or libraries and resolve them by adding the necessary JAR files to the project's library path.
+ Build the Project:
  + Right-click on the project name in the "Projects" window.
  + Select "Build" to compile the project. Ensure there are no compilation errors.
- Run the Project:
  + Right-click on the project name again in the "Projects" window.
  + Select "Run" to execute the application.
+ Interact with the Application: The application's welcome screen should appear, allowing you to interact with the virtual banking system.
