pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git "https://github.com/Akankshya03/multi-ticket-booking-app.git"
            }
        }
        
         stage("package"){
            steps{
            sh "mvn clean package -DskipTests"
            }
        }
    }
 }