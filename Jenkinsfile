pipeline{
    agent any
    stages{
        stage("clone"){
            steps{
            retry(3){
               bat "git clone https://github.com/Akankshya03/multi-ticket-booking-app.git"
               }
            }
        }
      
        
         stage("package"){
            steps{
            bat "mvn clean package -DskipTests"
            }
        }
       
        }
   
}