pipeline {
  agent any
  stages {
    stage('Stage1') {
      parallel {
        stage('Stage1') {
          steps {
            echo 'hello'
          }
        }

        stage('stage4') {
          steps {
            echo 'Hello stage 4'
          }
        }

      }
    }

    stage('Stage2') {
      steps {
        sleep 5
      }
    }

    stage('Stage3') {
      steps {
        echo 'Hello Word'
      }
    }

  }
}