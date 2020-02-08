node {
   stage("Pull Repo"){
     echo "hello"
    }
   stage("Build Image"){
     sh "packer version"
    }
   stage("Send Notification to slack"){
     echo "hello"
    }
   stage("Pull Repo"){
     echo "hello"
    }
}