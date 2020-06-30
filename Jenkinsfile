pipeline
{
    agent any
    stages
    {
        stage("Checkout")
        {
            steps
            {
                //
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