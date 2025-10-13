
pipeline{
    agent {
        label 'mac'
    }
    stages{
        stage("Unit Test"){
            steps{
                script {
                    sh 'mvn test'
                }
            }
        }
        stage("Sonar Analysis"){
                    steps{
                        echo "Sonar Analysis"
                    }
        }
        stage("Build Docker Image"){
                    steps{
                        script {
                            sh 'docker build -t myapp:1.0 .'
                        }
                    }
         }
    }
    
}
