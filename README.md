# germes
IT-Simulator Project:
 - part 1 http://it-simulator.com/#/article/1/3
 - part 2 https://it-simulator.com/#/article/312/313

### Run MySQL: 
http://it-simulator.com/#/article/1/189

Build from dockerfile:
    
    docker build -t germes/mysql -f mysql.dockerfile --no-cache=true .
    
Run:

    docker run -e MYSQL_ROOT_PASSWORD=secret_pw -p 3307:3306 --name=germes_db --memory=512M --cpus=1 -v c:/data:/var/lib/mysql germes/mysql
    
    docker exec -it germes /bin/sh

