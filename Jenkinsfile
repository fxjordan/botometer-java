pipeline {
  agent any
  triggers{
    bitbucketPush()
  }
  tools {
    jdk "jdk-8"
  }
  stages {
    stage('Build') {
      steps {
        withMaven() {
          sh 'mvn -B clean deploy -Dmaven.test.failure.ignore=true'
        }
      }
    }
  }
}