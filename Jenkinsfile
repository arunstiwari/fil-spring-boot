
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
    }
    
}
