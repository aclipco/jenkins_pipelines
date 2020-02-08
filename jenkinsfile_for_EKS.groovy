node{
  stage("Pull Repo"){
    git 'https://github.com/bkarakas/terraform-iaac-eks-burak.git'
}
  stage("stage1"){
    sh "terraform version"
}
  stage("stage1"){
    echo "hello"
}
  stage("stage1"){
    echo "hello"
}
}