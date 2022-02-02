@MarksEvaluation
Feature: Student marks evaluation based on their subject marks

  Scenario Outline: Calculate the student marks average based on their subjects
    Given Assume we have list of students data in "<csvFile>" file
    When Generate "<noOfStudents>" students data in "<csvFile>" for average calculation
    Then Validate average calculated and stored in "<csvFile>" file

    Examples:
      | noOfStudents | csvFile                                       |
      | 2000         | src/test/resources/StudentMarksEvaluation.csv |
