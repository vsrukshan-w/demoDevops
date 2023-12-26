pipeline {
    agent any

    stages {

        stage('checkout') {
            steps {
                echo 'Getting latest source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    echo 'Building Spring boot app...'
                    powershell './gradlew clean build'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Testing Spring boot app...'
                    powershell './gradlew clean test'
                }
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }

    }
}
