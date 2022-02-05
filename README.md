## selenium-web-automation

#### Project description
* Search the below products from Amazon website and retrieve the top two product by cost ascending order
    - Bluetooth headset
    - 34 inch LED monitor
    - USB c dock
    - Smart watch
* Get the product name, description, ratings/review, and it's cost
* Sort by the product cost descending order, and print top products into csv file
    - "Name","Description","Rating","Cost"
* Each product with their top two product are in csv with comma separated format

###############################################################################
#### *Interesting factor of the project : Same project run on both TestNG framework & Junit framework for cucumber*
###############################################################################

#### Running the project in local
* ##### Pre-requisites
    - java installed in your system [check with : 'java --version']
    - maven is configured in your system [check with : 'mvn --version']

* ##### Run test locally with below steps
    - Clone the project to local - 'git clone https://github.com/venkateswarlu-dhanala/selenium-web-automation.git'
    - Run the command for first time - 'mvn clean install -DskipTests'
  
  * ###### *Run 'TestNG' test for same functionality*
    - Run the command for test execution - 'mvn test'
    - Report will be generated in 'src/main/resources/testng' folder for TestNG framework 
  
  * ###### *Run 'TestNG' test for same functionality*
    - Run the command for test execution - 'mvn test -Dtest-type=junitTest'
    - Report will be generated in 'src/test/resources' folder for Junit Cucumber framework

#### *Thank you for visiting and Happy learning - Venkateswarlu Dhanala*
