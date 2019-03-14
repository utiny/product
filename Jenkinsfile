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
/*
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
        
        stage('Clone repository') {
    	    checkout scm
	    }
        
        stage('compile') {
	      steps {
	        sh 'mvn clean install'
	      }
	    }
	    
        stage('Build image') {
	       
	        app = docker.build("product")
    	}
    }
}
*/


	/*
    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }*/


