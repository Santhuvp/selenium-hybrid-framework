pipeline {
    agent any

    tools { maven 'Maven-3.9' }

    options {
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }

    parameters {
        choice(name: 'ENV',   choices: ['qa', 'staging', 'uat'],       description: 'Target environment')
        choice(name: 'SUITE', choices: ['smoke', 'regression'],        description: 'Test suite')
        booleanParam(name: 'HEADLESS', defaultValue: true,             description: 'Run browser headless')
    }

    stages {
        stage('Test') {
            steps {
                sh '''
                    mvn -B clean test \
                      -Denv=${ENV} \
                      -DsuiteXmlFile=${SUITE}.xml \
                      -Dheadless=${HEADLESS} \
                      -Dremote.url=http://selenium-chrome:4444 \
                      -Dmaven.test.failure.ignore=true
                '''
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
        unsuccessful {
            archiveArtifacts artifacts: 'target/surefire-reports/**, **/screenshots/**', allowEmptyArchive: true
        }
        cleanup { cleanWs() }
    }
}