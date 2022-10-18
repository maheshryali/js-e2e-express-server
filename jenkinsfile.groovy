pipeline {
    agent { label 'jse2c' }
    triggers { pollSCM '* * * * *'}
    parameters {
        choice(name: 'npm', choices: ['install', 'run build', ], description: '')
    }
    stages{
        stage('vcs'){
            steps{
                git branch: 'main',
                       url: 'https://github.com/maheshryali/js-e2e-express-server.git'
            }
        }
        stage('npm'){
            steps{
                   sh "npm ${params.npm}"
            }
        }
        }
        
}