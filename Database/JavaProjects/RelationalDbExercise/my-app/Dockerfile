# Stage 1
FROM node:14-alpine as build-step
#RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build --prod
# Stage 2
FROM nginx:1.17.1-alpine
COPY --from=build-step /app/dist/my-app /usr/share/nginx/html

# docker build -t ang/test .
# docker run -d -it -p 80:80/tcp --name angtest ang/test:latest
# http://localhost:80