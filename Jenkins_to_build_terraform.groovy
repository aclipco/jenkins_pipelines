node {
stage("pull repo"){
      git 'git@github.com:aclipco/docker_images.git'
    }
stage("Build Image"){
      sh "docker build -t . "
    }
stage("Login to ECR"){
    sh '''$(aws ecr get-login --no-include-email --region us-east-1)'''
    }
    stage("Image Tag"){
sh '''docker push 431846644568.dkr.ecr.us-east-1.amazonaws.com/terraformimages1'''

}

stage("Push Image"){
    sh "docker push 431846644568.dkr.ecr.us-east-1.amazonaws.com/terraformimages1"

    }
stage("Notification"){
    sh "echo hello"

    }
}