pipeline {
    agent any

    tools {
        // ... tell Jenkins what java version, maven version or other tools are required ...
        maven 'Apache Maven 3.8.6'
        jdk 'OpenJDK 17'
    }

    options {
        // Configure an overall timeout for the build of ten hours.
        timeout(time: 1, unit: 'HOURS')
        // When we have test-fails e.g. we don't need to run the remaining steps
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
        disableConcurrentBuilds(abortPrevious: true)
    }

    stages {
        stage('⚙️\rInitialization') {
            steps {
                echo "Building branch $env.BRANCH_NAME"
            }
        }

        stage('🧹\rCleanup') {
            steps {
                echo 'Cleaning up the workspace'
                deleteDir()
            }
        }

        stage('⬇️\rCheckout') {
            steps {
                echo "Checking out branch $env.BRANCH_NAME"
                checkout scm
            }
        }

        stage('▶️\rCompile') {
            steps {
                echo 'Compile'
                sh 'mvn -B -e clean compile -DskipTests'
            }
        }

        stage('🧪\rTests') {
            steps {
                echo 'Running tests'
                sh 'mvn -B -fae -Dmaven.test.failure.ignore=true verify'
            }
        }

        stage('🔍\rSonarQube analysis') {
            steps {
                withSonarQubeEnv('Forge SonarQube') {
                    sh 'mvn -B -e sonar:sonar'
                }
            }
        }
    }
 
    post {
        always {
            junit(testResults: '**/surefire-reports/*.xml', allowEmptyResults: true)
            junit(testResults: '**/failsafe-reports/*.xml', allowEmptyResults: true)
            cleanWs notFailBuild: true
        }
    }

}
