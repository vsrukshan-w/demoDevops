pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    bat './gradlew clean build'
                }
            }
        }

        stage('Create Docker image') {
            steps {
                script {
                    bat 'docker build -t demo-devops:latest .'
                }
            }
        }

        stage('Deploy Docker container Locally') {
            steps {
                script {
                    bat 'docker run -p 8080:8080 demo-devops:latest'
                }
            }
        }
    }
}
