pipeline
{
    agent any
    stages
    {
        stage("Checkout")
        {
            steps
            {
               checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'LocalBranch', localBranch: 'master']], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kartikdutta28/spring-boot-bank.git']]]
            }
        }
        stage("Build")
        {
            steps
            {
                script
                {
                    bat "mvn clean install -Dmaven.skip.test=true"
                }
            }
        }
        stage("Sonar analysis")
        {
            steps
            {
                echo "Executing Sonar"
            }
        }
    }
}