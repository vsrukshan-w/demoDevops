pipeline {
    agent any

    stages {
        stage('Stop and Remove Existing Container') {
            steps {
                script {
                    def isContainerRunning = bat(script: 'docker inspect -f {{.State.Running}} demo-devops', returnStatus: true) == 0

                    if (isContainerRunning) {
                        echo 'Stopping and removing existing container...'
                        bat 'docker stop demo-devops'
                        bat 'docker rm demo-devops'
                    } else {
                        echo 'No existing container found.'
                    }
                }
            }
        }

        stage('Remove Existing Docker Image') {
            steps {
                script {
                    def isImageExists = bat(script: 'docker inspect -f {{.Id}} demo-devops', returnStatus: true) == 0

                    if (isImageExists) {
                        echo 'Removing existing image...'
                        bat 'docker rmi demo-devops'
                    } else {
                        echo 'No existing image found.'
                    }
                }
            }
        }

        stage('Build New Docker Image and Run Container') {
            steps {
                script {
                    echo 'Building new Docker image...'
                    bat 'docker build -t demo-devops .'

                    echo 'Running new container...'
                    bat 'docker run -d -p 8080:8080 --name demo-devops demo-devops'
                }
            }
        }
    }
}
