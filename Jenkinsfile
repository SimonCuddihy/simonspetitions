pipeline {
    agent any
    stages {
        stage('GetProject') {
            steps {
                git branch: 'main', url: 'https://github.com/SimonCuddihy/simonspetitions.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
                                 artifacts: '**/target/*.war'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker build -f Dockerfile -t myapp .'
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 9090:8080 --detach myapp:latest'
            }
        }
    }
}
