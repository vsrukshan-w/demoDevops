pipeline {
    agent any

    stages {
        stage('Stop Existing Container') {
            steps {
                script {
                    bat 'docker stop $(docker ps -aq --filter "name=^demo-devops")'
                    bat 'docker rm $(docker ps -aq --filter "name=^demo-devops")'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("demo-devops:latest", windowsOptions: '--memory=8GB')
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    bat 'docker run -p 8080:8080 demo-devops:latest'
                }
            }
        }
    }
}
