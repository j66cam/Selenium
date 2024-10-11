pipeline {
    agent any

    tools {
        maven 'Maven3' // Asegúrate de que Jenkins tenga configurado Maven
        jdk 'JDK21'   // Asegúrate de que Jenkins tenga configurado JDK
    }

    environment {
        MAVEN_OPTS = "-Xms256m -Xmx512m"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio desde Git
                git branch: 'master', url: 'https://github.com/j66cam/Selenium.git'
            }
        }

        stage('Build') {
            steps {
                // Limpiar y compilar el proyecto
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Ejecutar las pruebas de Cucumber
                bat 'mvn test'
            }
        }

        /* stage('Report') {
            steps {
                // Generar el reporte de Cucumber
                bat 'mvn surefire-report:report'
            }
             post {
                always {
                    // Publicar reportes en Jenkins (adaptar si usas otro plugin)
                    publishHTML(target: [
                        reportName : 'Cucumber Report',
                        reportDir  : 'target/surefire-reports',
                        reportFiles: 'index.html',
                        keepAll    : true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: false
                    ])
                }
            }
        } */
    }

    post {
        always {
            // Limpiar workspace al final
            cleanWs()
        }
    }
}