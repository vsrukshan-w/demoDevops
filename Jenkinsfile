pipeline {
    agent any

    stages {
        stage('Stop and Remove Existing Container') {
            steps {
                script {
                    bat 'docker stop demo-devops'
                    bat 'docker rm demo-devops'
                }
            }
        }

        stage('Remove Existing Docker Image') {
            steps {
                script {
                    bat 'docker rmi demo-devops'
                }
            }
        }

        stage('Build New Docker Image') {
            steps {
                script {
                    bat 'docker build -t demo-devops .'
                }
            }
        }

        stage('Run New Container') {
            steps {
                script {
                    bat 'docker run -d -p 8080:8080 --name demo-devops demo-devops'
                }
            }
        }
    }
}
