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
                    powershell './gradlew clean build --no-daemon'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Testing Spring boot app...'
                    powershell './gradlew clean test --no-daemon'
                }
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }

        stage('SonarQube Analyze') {
            steps {
                script {
                    withSonarQubeEnv('sonarqube-server') {
                        powershell './gradlew sonarqube --no-daemon'
                    }
                }
            }
        }

    }
}
