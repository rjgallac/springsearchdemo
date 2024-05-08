https://howtodoinjava.com/spring-data/elasticsearch-with-spring-boot-data/



docker run --name elasticsearch-container -d -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" -e "xpack.security.enabled=false" \
docker.elastic.co/elasticsearch/elasticsearch:8.10.4

http://localhost:9200/_aliases

http://localhost:9200/_stats/indexing/?pretty=true

http://localhost:9200/employees/_stats?pretty=true

http://localhost:9200/employees/_search?q=cv:php

run this to generate lots of random data
http://localhost:8080/employee

run this to query all those cvs that contain JAVA keyword
http://localhost:8080/employee/all
