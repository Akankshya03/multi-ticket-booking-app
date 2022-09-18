pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                sh "git clone https://github.com/Akankshya03/multi-ticket-booking-app.git"
            }
        }
        
         stage("package"){
            steps{
            sh "mvn clean package -DskipTests"
            }
        }
    }
 }