FROM tomcat:9-jdk8
EXPOSE 8080
ADD target/news-portal.war /usr/local/tomcat/webapps/news-portal.war
ENTRYPOINT ["catalina.sh", "run"]

FROM postgres

ADD main/resources/database/news_db_dump.sql /docker-entrypoint-initdb.d