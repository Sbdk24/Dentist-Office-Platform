# Dentist-Office-Platform
A booking and medical information storage system for a dentist office with Java and MySQL

## Dentist Office Appointment Program

### Code Usage

#### Introduction to the Code

The program is operates with a MySQL database, utilizing MySQL Workbench as the database management system. Due to time constraints, the system lacks the following functionalities (and others as well), which should be added and corrected if there are future iterations:

1. Patient Validation: Ensuring that only one entry per patient exists to prevent duplicate data.
2. Validation of valid patient data: Notifying about errors when filling out forms and requesting correction.
3. Appointments: No additions, deletions, or modifications are made.

However, the code does the following:
1. Authentication and display of different views depending on the user.
2. Patients: Adding, deleting, modifying, and viewing medical history.

Finally, the program was run and developed on Windows. To use this code, the following installations are required, which were performed on Windows:
1. Java JDK: [Download Here](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
2. MySQL Community Edition: [Download Here](https://dev.mysql.com/downloads/installer/)
3. MySQL WorkBench: [Download Here](https://dev.mysql.com/downloads/workbench/)

Installation settings for the downloads are the default selections; there is no special configuration needed. Simply accept all prompts until the installation is complete.

To use MySQL, we utilized the Full Setup. Once everything is installed, follow the steps below:

- [x] Ensure MySQL Workbench is opened.

#### Importing the Database

1. Open MySQL Workbench and log in to the MySQL instance where you want to perform the import. Use the password `rHQKUcA3XE` or the one you have chosen.
2. Access the Import Tool by selecting "Server" > "Data Import" from the top menu bar, leading you to the import screen.
3. Select "Import from Dump Project Folder".
4. Choose the Target Database.
   
If the target database already exists, simply select it from the dropdown list in "Default Target Schema". To create a new database:
- Create a New Database by clicking the "New..." button next to the "Default Target Schema" dropdown menu. Enter the name of the new database in the dialog box that appears and confirm. The new database will be created and automatically selected as the destination for the import.

We named the Schema "consultorio".

Once the database is set up, adjust the code as necessary to run it from NetBeans. First, with the Consultorio.zip file within the downloaded folder, click inside NetBeans on File.

#### Project Setup

For this program, you'll need a `mysql-connector-j-8.3.0.jar` which is not present in this repository, it can be found at MySQLWorkbrench to insert your connection.

If during the Workbench and MySQL installation, different usernames and passwords were configured, modify the values in the appropriate fields within the `Conexion` class under the `modelo` package in NetBeans.

Finally, to use the program, go to the `userAutentication` package and in the `Main` class, click Run Project.

### Using the Program

#### User Authentication

From the `Main` class within `userAutentication`, you can execute the program. Upon execution, you will see the Login GUI, where there are two user options:
- Dentist
- Receptionist

Credentials:
- Dentist:
    - Username: usuario123
    - Password: contrasenaSecreta
- Receptionist:
    - Username: otroUsuario
    - Password: otraContrasena

After logging in, the Menu GUI opens, which is the same for both users. Here's how to use the program according to different use cases:

#### Use Cases

- **(UC-01) Patient Registration**: From the Receptionist user in the patient view, fill out the form to register a patient. The program requires entering the telephone number but can function without providing an email. After saving the user, it notifies that the data has been saved, and upon pressing OK, the form is cleared.

- **(UC-03) Modification of Basic Patient Data**: From the Receptionist user in the patient view, search for a user by filling out the Name field. If there are multiple users with the same name, the system will choose one arbitrarily. After a search, the values of each field are automatically loaded and editable. If the user deletes the Telephone Number field, modification will not work. After making modifications and pressing Modify, the user is notified, and upon pressing OK, the form is cleared.

- **(UC-02) Patient Deletion**: From the Dentist user in the patient view (after searching), pressing the Delete button automatically removes the patient.

- **(UC-04) Medical Data Modifications**: For Dentist users, only the Name field is editable. The dentist can access the patient's medical history after searching for a patient in the system. The Save button is for new patients, so press Save only for them. The Modify button is for previous patients, so enter new information in the fields if applicable.

As mentioned in the introduction, the appointment subsystem was not completed on time. Therefore, the following use cases are not implemented:
- **(UC-05)**
- **(UC-06)**
- **(UC-07)**

```
