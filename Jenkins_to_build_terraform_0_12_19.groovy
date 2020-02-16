node {
stage("pull repo"){
      git 'https://github.com/aclipco/docker_images.git'
    }
stage("Build Image"){
      sh "docker build -t 431846644568.dkr.ecr.us-east-1.amazonaws.com/terraformimages1:0.12.19 -f Terraform_0.12.19/Dockerfile ."
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
