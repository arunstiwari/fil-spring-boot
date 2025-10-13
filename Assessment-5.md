### Objectives
- Apply Test-Driven Development (TDD) principles to build a RESTful API for Employee and Department management.

- Implement unit tests, achieve minimum 80% code coverage.

- Create a Jenkins pipeline (Jenkinsfile) to automate:
   - Build 
   - Unit Test 
   - Code Coverage 
   - Static Code Analysis with SonarQube 
   - Docker Image Build & Push

- Write Kubernetes manifests to deploy the application with:
  - Minimum 2 replicas 
  - Service to expose the pods internally 
  - Ingress for external access

### Evaluation Criteria
- Code Quality No critical Sonar issues
-   Coverage ≥ 80% line coverage 
- TDD Tests precede implementation 
- CI/CD Jenkins pipeline executes all stages successfully 
- REST All endpoints respond with correct HTTP codes
- Service Layered Architecture Principles
- Validation of attributes
- Exception Handling
### Notes: 
- Use Spring Boot + Maven + H2 Database