pipeline {
    agent any

    triggers {
        cron('H H */2 * *')   // every 2 days
    }

    options {
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                sh '''
                    export PATH=$PATH:/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/Maven-3.9/bin
                    xvfb-run -a mvn clean test
                '''
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed — this is where email/Slack alerts will plug in later.'
        }
        success {
            echo 'All tests passed ✅'
        }
    }
}