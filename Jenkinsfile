pipeline {
    agent any
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: 'master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Techihub99/SpringbootDockerPipelineApp.git']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t thrishank99/springboot-javatechi-docker .'
                }
            }
        
        }
       stage('Push image to Hub'){
            steps{
                script{
                
                   withCredentials([usernamePassword(credentialsId: 'javatechidockerhub', passwordVariable: 'javatechidockerhub', usernameVariable: 'thrishank99')]) {
                   bat "docker login -u ${env.thrishank99} -p ${env.javatechidockerhub}"
}
                  bat 'docker push thrishank99/springboot-javatechi-docker'
                }
            }
        }
        stage('build & SonarQube Analysis'){
            steps{
              withSonarQubeEnv('sonarqubescannernew'){
              bat 'mvn clean package sonar:sonar'
            }
}
        }     
   }
}