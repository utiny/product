pipeline {
    agent { dockerfile true }
    def app
     
    stages { 
    
    	stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        
        stage('Clone repository') {
    	    checkout scm
	    }
        
        stage('compile') {
	      steps {
	        sh '/usr/local/Cellar/maven/3.6.0/libexec/bin/mvn clean install'
	      }
	    }
	    
        stage('Build image') {
	        /* This builds the actual image; synonymous to
	         * docker build on the command line */
	
	        app = docker.build("product")
    	}
    }
}