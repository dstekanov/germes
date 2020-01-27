FROM mysql:5.7
LABEL Author="Dmytro Stekanov", Version=0.1

ENV MYSQL_USER=germes \
       MYSQL_PASSWORD=germes \
       MYSQL_DATABASE=germes
