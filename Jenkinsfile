pipeline {
  agent { label 'katalon-ecs-only' }

  options {
    timestamps()
  }

  stages {
    stage('Checkout Source') {
      steps {
        checkout scm
      }
    }

    stage('Verify Repo') {
      steps {
        sh '''
          set -e
          echo "NODE_NAME=$NODE_NAME"
          echo "NODE_LABELS=$NODE_LABELS"
          hostname
          whoami
          pwd

          ls -la
          find . -maxdepth 3 -type f | sort

          test -f "katalon_test_clean/katalon_test_clean.prj"
          test -f "katalon_test_clean/Test Suites/Smoke.ts"
        '''
      }
    }

    stage('Verify Katalon Runtime') {
      steps {
        sh '''
          set -e
          command -v katalonc
          katalonc -version || true
        '''
      }
    }

    stage('Run Katalon Smoke Test') {
      steps {
        dir('katalon_test_clean') {
          withCredentials([
            string(credentialsId: 'katalon-api-key', variable: 'KATALON_API_KEY')
          ]) {
            sh '''
              set -e
              katalonc -noSplash \
                -runMode=console \
                -projectPath="katalon_test_clean.prj" \
                -testSuitePath="Test Suites/Smoke" \
                -executionProfile="default" \
                -browserType="Chrome" \
                -apiKey="$KATALON_API_KEY" \
                -retry=0
            '''
          }
        }
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: '**/Reports/**', allowEmptyArchive: true
      junit testResults: '**/*.xml', allowEmptyResults: true
    }
  }
}
