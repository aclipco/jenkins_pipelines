node {
   properties([parameters([choice(choices: ['us-east-1', 'us_east-2', 'us-west-1', 'us-west-2'], description: 'Please select a region', name: 'AMI_REGION')])])

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