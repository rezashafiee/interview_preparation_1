pipeline {
  agent {
    node {
        label 'Main'
        customWorkspace '/home/ubuntu/Jenkins/Workspace'
    }
  }
  environment {
    ANDROID_HOME = '/home/ubuntu/Android/sdk'
    PATH = "${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:$PATH"
  }
  options {
    // Stop the build early in case of compile or test failures
    skipStagesAfterUnstable()
  }
  stages {

    // Put your stages here
    /* stage('Detect build type') {
      steps {
        script {
          if (env.BRANCH_NAME == 'develop' || env.CHANGE_TARGET == 'develop') {
            env.BUILD_TYPE = 'debug'
          } else if (env.BRANCH_NAME == 'master' || env.CHANGE_TARGET == 'master') {
            env.BUILD_TYPE = 'release'
          }
        }
      }
    }

    stage('Compile') {
      steps {
        // Compile the app and its dependencies
        sh './gradlew compile${BUILD_TYPE}Sources'
      }
    }

    stage('Build') {
      steps {
        // Compile the app and its dependencies
        sh './gradlew assemble${BUILD_TYPE}'
        sh './gradlew generatePomFileForLibraryPublication'
      }
    } */

    stage('init') {
        steps {
            script {
              sh 'bundle update'
            }
          }
    }

    stage('Run tests') {
      steps {
        script {
          sh 'bundle exec fastlane test'
        }
      }
    }

  }
}