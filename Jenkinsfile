pipeline {
    agent any  
    
    stages { 
    
    	stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        
        stage('compile') {
	      steps {
	        sh '/usr/local/Cellar/maven/3.6.0/libexec/mvn clean install'
	      }
	    }
    }
}