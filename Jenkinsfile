pipeline {
    agent any
    triggers { 
      githubPush() 
   }
    environment {
        DOCKER_IMAGE_NAME = 'shahharsh25/calculator'
        GITHUB_REPO_URL = 'https://github.com/harsh-shah25/SPE_miniProject.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }
        
        stage('Build Jar File') {
            steps {
                script {
                    // Build Docker image
                    sh 'mvn clean package'
                }
            }
        }

        stage('Test Java project') {
            steps {
                script {
                    // Build Docker image
                    sh 'mvn test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    docker.withRegistry('', 'DockerhubCred') {
                    sh "docker push ${DOCKER_IMAGE_NAME}"
                    }
                 }
            }
        }
        
        stage('Run Ansible Playbook') { 
            steps {
                script {
                    withEnv(["ANSIBLE_HOST_KEY_CHECKING=False"]) {   
                        ansiblePlaybook(
                            playbook: 'deploy.yaml',
                            inventory: 'inventory'
                        )
                    }
                }
            }
        }
 }

 post {
        success {
            mail to: '2502harshvikasshah@gmail.com',
                 subject: "Application Deployment SUCCESS: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build was successful!"
        }
        failure {
            mail to: '2502harshvikasshah@gmail.com',
                 subject: "Application Deployment FAILURE: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build failed."
        }
        always {
            cleanWs()
        }
      }
    }
