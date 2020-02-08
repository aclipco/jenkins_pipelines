node {
   properties([parameters([choice(choices: ['us-east-1', 'us_east-2', 'us-west-1', 'us-west-2'], description: 'Please select a region', name: 'AMI_REGION')])])

   stage("Pull Repo"){
     git 'https://github.com/farrukh90/packer'
    }
   stage("Build Image"){
     sh "packer version"
     sh "packer build --var region=${AMI_REGION} tools/jenkins_example.json"
    }
   stage("Send Notification to slack"){
     slackSend channel: 'nagios_alerts', message: 'ami build'
    }
   stage("Pull Repo"){
     mail bcc: '', body: '''Hello,
     Your AMI has been build''', cc: '', from: '', replyTo: '', subject: 'AMI has been build', to: 'a.clipco@gmail.com'
    }
}