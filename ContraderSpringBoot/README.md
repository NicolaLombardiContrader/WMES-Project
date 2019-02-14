# Capital Reporting App

### Setup

Run

    gradle bootRun
    

### DEPLOY TO BLUEMIX (DE)

    cf api https://api.eu-de.bluemix.net
    cf login --sso -o "alessiosaltarin@it.ibm.com" -s Dev
    cf push
    
    
### DEPLOY TO 9 NETWORK

Application Server Console:

    http://9.137.251.187:9990 
    
Application Server App URL:

    http://9.137.251.187:8080/capitalreporting
    
Oracle 12C:

    jdbc:oracle:thin:@9.137.251.186:1521:CRDEV  
    
Start JBoss:

    sudo nohup bin/standalone.sh &
    
Shutdown JBoss:

    sudo bin/jboss-cli.sh --connect --command=:shutdown         
    
Strong shudown:
    pidof java
    kill -9 [pid]
    pidof standalone
    kill [pid]       
    
Restart JBoss:

    sudo bin/jboss-cli.sh --connect --command=:reload    
    
#### SEE LOGS
    
    cf logs CapitalReporting
    
### COGNOS BI URL

    http://9.137.251.185:9300/bi
    