### Assessment Objective
- Develop a CRUD-based Employee Management REST API using Spring Boot (Maven) following Test-Driven Development (TDD) principles.
- The project must integrate with SonarQube for code quality checks and Jenkins for automated CI execution (unit tests, code coverage, and Sonar analysis).
- Create following endpoints
  - POST /api/employees  : To add a new employee
  - GET /api/employees   : To fetch all employees
  - GET /api/employees/{id} : Get employee by id
  - DELETE /api/employees/{id} : Delete employee by id

- Write Test for controller layer 
- Write Test for service layer

- Write Jenkinsfile which covers following stage:
  - Executing Unit Test
  - Executing Code coverage
  - SonarQube analysis

---

- Evaluation  Criteria
  
    - **Code Quality**	    No critical Sonar issues
    - **Coverage**	        ≥ 80% line coverage
    - **TDD**	            Tests precede implementation
    - **CI/CD**	            Jenkins pipeline executes all stages successfully
    - **REST**	            All endpoints respond with correct HTTP codes
