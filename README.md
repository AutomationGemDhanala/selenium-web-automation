## student-marks-evaluation

####Project description <br />
* Create a csv file with a minimum of 2000 records with below column names <br />
    - Firstname <br />
    - Lastname <br />
    - Subject1 (values <=100, random numbers) <br />
    - Subject 2(values <=100 , random numbers)<br />
    - Subject3(values <=100, random numbers)<br />
    - Subject4(values <=100, random numbers)<br />
    - Subject5(values <=100 , random numbers)<br />
* Parse the above csv file<br />
    - Calculate the average for each student<br />
    - Create a new column name average<br />
* Rewrite the csv file with average value

####Running the project in local <br />
##### Pre-requisites
- java installed in your system [check with : 'java --version']
- maven is configured in your system [check with : 'mvn --version']

##### Run test locally with below steps
* Clone the project to local - 'git clone https://github.com/venkateswarlu-dhanala/student-marks-evaluation.git'
* Run the command for first time - 'mvn clean install -DskipTests'
* Run the command for test execution - 'mvn test'
