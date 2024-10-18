pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    environment {
        MAVEN_OPTS = "-Xms256m -Xmx512m"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/j66cam/Selenium.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                //bat 'mvn test'
                bat "mvn test -Dcucumber.filter.tags=@CheckBox"
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportName : 'Cucumber Report',
                reportDir  : 'target',
                reportFiles: 'cucumber.html',
                keepAll    : true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])
            // Limpia el workspace al final
            cleanWs()
        }
    }
}