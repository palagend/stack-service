node("${env.NODE_DEFINED}"){
  timestamps {
    stage('Preparation') {
        checkout scm
   }
    stage('Build'){
        sh 'ci/jenkins-build.sh'
    }
    stage('Deploy'){
        sh 'ci/rancher-deploy.sh'
    }
  }
}