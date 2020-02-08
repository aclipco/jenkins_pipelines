node {
   properties(
     [properties([parameters([
       choice(choices: ['golden_ami', 'tower', 'elk ', 'nagiosxi', 'gitlab', 'volt', 'nexus'], description: 'What tool  would you  like to build', name: 'TOOL_TO _PROVISION'),
     choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Choose a region', name: 'AMI_REGION')])])

   stage("Pull Repo"){
     git 'https://github.com/farrukh90/packer'
    }
   stage("Build Image"){
     sh "packer version"
     //sh "packer build --var region=${AMI_REGION} tools/${TOOL_TO_PROVISION}".json
    }
   stage("Send Notification to slack"){
     slackSend channel: 'nagios_alerts', message: "${TOOL_TO_PROVISION} build"
    }
   stage("Send Email"){
        mail bcc: '', 
        body: "Hello, Your AMI is ready in ${AMI_REGION} Thanks",
        cc: '',
        from: '',
        replyTo: '',
        subject: "${TOOL_TO_PROVISION} has been built",
        to: 'anastasiaclipco@gmail.com'
    }
}