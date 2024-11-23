pipeline {
    agent any
    stages {
        stage ('GetProject') {
            steps {
                git branch: 'main', url: 'https://github.com/SimonCuddihy/simonspetitions.git'
            }
        }
        stage ('build') {
            steps {
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'mvn compiler:compile'
            }
        }
        stage ('Exec') {
            steps {
                sh 'mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=9090"'
            }
        }
    }
}