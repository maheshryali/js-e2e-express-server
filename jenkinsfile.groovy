pipeline {
    agent { label 'jse2c' }
    triggers {pollscm '* * * * *'}
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
            sh "npm ${params.npm}"
        }
        }
        
}