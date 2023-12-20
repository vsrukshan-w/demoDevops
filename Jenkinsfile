pipeline {
    agent any

    stages {


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
