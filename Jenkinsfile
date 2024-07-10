pipeline {
    agent any

    environment {
        DOCKER_PATH = 'C:\\Program Files\\Docker\\cli-plugins'
        PATH = "${DOCKER_PATH};${PATH}"
        KUBERNETES_NAMESPACE = 'scheduling'
        KUBERNETES_DEPLOYMENT = 'backend'
        DOCKER_IMAGE = 'mohammadtabbaby/schedulingservice'
        DOCKER_TAG = 'latest'
        KUBECONFIG = 'C:\\Users\\MohamedTabbabi\\.kube\\config'
    }

    stages {
        stage('Set Up Environment') {
            steps {
                script {
                    echo "Setting up environment..."
                    bat "echo 'Setting up Docker path: ${DOCKER_PATH}'"
                    bat "echo 'Setting up KUBECONFIG: ${KUBECONFIG}'"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker image..."
                    bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
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
                    echo "Verifying and pulling Docker image..."
                    bat """
                    docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}
                    docker images ${DOCKER_IMAGE}:${DOCKER_TAG}
                    """
                }
            }
        }

        stage('Deploy with Kubectl') {
            steps {
                script {
                    bat '''
                    kubectl config view
                    kubectl config use-context docker-desktop
                    kubectl cluster-info
                    kubectl get nodes
                    kubectl get namespace scheduling || kubectl create namespace scheduling
                    kubectl apply -f docker/configMap.yml -n scheduling
                    kubectl apply -f docker/mysqldep.yml -n scheduling
                    kubectl apply -f docker/persistent.yaml -n scheduling
                    kubectl apply -f deployment.yaml -n scheduling
                    '''
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline completed"
        }
    }
}
