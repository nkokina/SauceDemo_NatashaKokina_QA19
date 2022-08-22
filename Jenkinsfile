pipeline {
    agent any

    triggers {
        cron('5 * * * *')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }


    parameters {
         string(defaultValue:'smokeTest.xml', name: 'SUITE_NAME')

         choice(name: 'BROWSER', choices: ['Chrome', 'Opera'], description: 'browser')

         gitParameter(branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH')
   }

  stages {
        stage('Run tests') {
            steps {

                 choices: "${params.BROWSER}",
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}",

                 url: 'https://github.com/nkokina/SauceDemo_NatashaKokina_QA19.git'

                // Run Maven on a Unix agent.
               bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"

            script {
               def browsers = ['chrome', 'opera']
                   for (int i = 0; i < browsers.size(); ++i) {
                     echo "Testing the ${browsers[i]} browser"
                     }
               }
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }

    }
}