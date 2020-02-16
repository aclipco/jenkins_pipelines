node {
stage("pull repo"){
      git 'https://github.com/aclipco/docker_images.git'
    }
stage("Build Image"){
      sh "docker build -t 431846644568.dkr.ecr.us-east-1.amazonaws.com/terraformimages1:packer:0.1.5 -f Packer_1.5.0/Dockerfile ."
    }
stage("Login to ECR"){
    sh '''$(aws ecr get-login --no-include-email --region us-east-1)'''
    }
stage("Push Image"){
        sh "docker images"
        sh "docker push 431846644568.dkr.ecr.us-east-1.amazonaws.com/terraformimages1"
    }
stage("Notification"){
    sh "echo hello"

    }
}
