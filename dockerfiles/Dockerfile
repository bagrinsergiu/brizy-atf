FROM nginx:stable-alpine

WORKDIR /project

RUN rm -rf /usr/share/nginx/html/*

COPY ./web-test/target/allure-report /usr/share/nginx/html
COPY ./dockerfiles/docker-image/nginx.conf /etc/nginx/conf.d/default.conf
