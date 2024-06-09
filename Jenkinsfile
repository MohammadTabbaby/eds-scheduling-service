pipeline {
    agent any

    environment {
        DOCKER_PATH = "C:\\Program Files\\Docker\\cli-plugins"
        PATH = "${DOCKER_PATH}:${PATH}"
        KUBERNETES_NAMESPACE = 'default'  // Change this to your desired namespace
        KUBERNETES_DEPLOYMENT = 'backend'
        DOCKER_IMAGE = 'mohammadtabbaby/backend'
        DOCKER_TAG = 'latest'
        KUBECONFIG = 'C:\\Users\\MohamedTabbabi\\.kube\\config'  // Update this path to your actual kubeconfig path
        SERVICE_YAML_FILE = 'backend-service.yaml' // Path to your NodePort service YAML file
        DEPLOYMENT_YAML_FILE = 'deployment.yaml' // Path to your deployment YAML file
        DATABASE_YAML_FILE = 'database-deployment.yaml' // Path to your database deployment YAML file
    }

    stages {
        stage('Set Up Environment') {
            steps {
                script {
                    // Ensure paths and tools are accessible
                    echo "Setting up environment..."
                    bat "echo 'Setting up Docker path: ${DOCKER_PATH}'"
                    bat "echo 'Setting up KUBECONFIG: ${KUBECONFIG}'"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build and tag the Docker image
                    echo "Building Docker image..."
                    bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Push the Docker image to the registry
                    echo "Pushing Docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        bat """
                        docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%
                        docker push ${DOCKER_IMAGE}:${DOCKER_TAG}
                        """
                    }
                }
            }
        }

        stage('Verify Docker Image') {
            steps {
                script {
                    // Verify the Docker image exists
                    echo "Verifying and pulling Docker image..."
                    bat """
                    docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}
                    docker images ${DOCKER_IMAGE}:${DOCKER_TAG}
                    """
                }
            }
        }

        stage('Deploy Docker Image to Kubernetes : Creating LoadBalancer Service') {
            steps {
                // Apply the NodePort service YAML file
                bat "kubectl apply -f ${SERVICE_YAML_FILE}"
            }
        }

        stage('Deploy Docker Image to Kubernetes : Applying Deployment YAML') {
            steps {
                // Apply the deployment YAML file
                bat "kubectl apply -f ${DEPLOYMENT_YAML_FILE}"
            }
        }

        stage('Deploy Database to Kubernetes') {
            steps {
                script {
                    echo "Deploying database to Kubernetes..."
                    bat "kubectl apply -f ${DATABASE_YAML_FILE}"
                }
            }
        }
    }

    post {
        always {
            // Cleanup or additional actions after the pipeline runs
            echo "Pipeline completed"
        }
    }
}
