pipeline {
    agent any

    stages {
        stage('Stop Existing Container') {
            steps {
                script {
                    bat 'docker ps -q --filter "name=^demo-devops" | ForEach-Object { docker stop $_ }'
                    bat 'docker ps -aq --filter "status=exited" --filter "name=^demo-devops" | ForEach-Object { docker rm $_ }'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("demo-devops:latest", windowsOptions: '--memory=2GB')
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
