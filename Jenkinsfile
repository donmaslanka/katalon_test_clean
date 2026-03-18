pipeline {
    agent { label 'ec2-agent-01' }

    environment {
        KATALON_API_KEY = credentials('katalon-api-key')
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Katalon Tests') {
            steps {
                sh '''
                katalonc \
                -runMode=console \
                -projectPath="$WORKSPACE/katalon_test_clean.prj" \
                -testSuitePath="Test Suites/Smoke" \
                -browserType="Chrome" \
                -apiKey="$KATALON_API_KEY" \
                -orgID="2333388" \
                -retry=0
                '''
            }
        }

    }
}
