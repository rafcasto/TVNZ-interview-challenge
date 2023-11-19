pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'openjdk:21-jdk-oracle' // Use the desired Node.js version or any other base image
                    //registryCredentialsId 'docker-hub-credentials' // Jenkins credentials for Docker Hub
                    args '-v /var/run/docker.sock:/var/run/docker.sock:rw -u root' // Run the Docker container as root user
                }
            }
            steps {
                // Clone your repository or perform any necessary setup steps
                // before building the Docker image
                // For example:
                // git 'https://github.com/your/repository.git'

                // Build the Storybook Docker image
                sh './mvnw clean install'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'openjdk:21-jdk-oracle' // Use the desired Node.js version or any other base image
                    //registryCredentialsId 'docker-hub-credentials' // Jenkins credentials for Docker Hub
                    args '-v /var/run/docker.sock:/var/run/docker.sock:rw -u root' // Run the Docker container as root user
                }
            }
            steps {
                sh "./mvnw verify -Dcucumber.filter.tags='@overseas'"

            }
        }
    }
}