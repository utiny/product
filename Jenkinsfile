/*
pipeline {
    agent { dockerfile true }
     
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
	       
	        app = docker.build("product")
    	}
    }
}*/

node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

	stage('compile') {
      steps {
        sh 'mvn clean install'
      }
    }
	    
    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        /*app = docker.build("ernesen/icp-tech-talks")*/
		app = docker.build("product")
    }

    stage('Test image') {
        /* Ideally, we would run a test framework against our image.
         * For this example, we're using a Volkswagen-type approach ;-) */

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

	/*
    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }*/
}

