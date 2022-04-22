@Library('ceiba-jenkins-library') _
pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK13_Centos' //Verisión preinstalada en la Configuración del Master
  }


  //Aquí comienzan los “items” del Pipeline
  stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout scm
      }
  }


   stage('Clean') {
    	steps{
    	echo "------------>Clean<------------"
    		sh 'chmod +x ./microservicio/gradlew'
			sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
    	}
    }
    
   stage('Compile & Unit Tests') {
      steps{
        	echo "------------>Compile & Unit Tests<------------"
	  	sh 'chmod +x ./microservicio/gradlew'
		sh './microservicio/gradlew --b ./microservicio/build.gradle test'
	
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.julian.castro.compurenting', 
        sonarName:'ceiba-compurenting(julian.castro)', 
        sonarPathProperties:'./sonar-project.properties')

      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
	  sh 'gradle --b ./microservicio/build.gradle build -x test'
      }
    }  
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
	junit 'microservicio/dominio/build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
	mail(to: 'julian.castro@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}")

    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}