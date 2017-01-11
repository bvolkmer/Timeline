node('androidSDK') {
  stage('Build') {
    checkout scm
    sh './gradlew clean assemble'
  }
  stage('Check') {
    parallel(
      'jUnit': {
        sh './gradlew test'
        junit '**/build/test-results/**/*.xml'
      },
      'androidLint': {
        sh './gradlew lint'
        androidLint canComputeNew: false, defaultEncoding: '', healthy: '0', pattern: '**/lint-results*.xml', unHealthy: '10'
      },
      'detekt': {
        sh './gradlew detekt'
      }
    )
  }
  stage('Connected Check') {
  sh 'echo "To be configured"'
    parallel(
      'api24': {
        sh 'echo "To be configured"'
      },
      'api25': {
        sh 'echo "To be configured"'
      }
    )
  }
}