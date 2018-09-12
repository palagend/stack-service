node(){
  timestamps {
    stage('Preparation') {
        checkout scm
   }
    stage('Build'){
        sh 'cmd/build.sh'
    }
    stage('Deploy'){
        sh 'cmd/deploy.sh'
    }
  }
}