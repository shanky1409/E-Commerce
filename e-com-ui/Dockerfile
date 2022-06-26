# # FROM node:16 as build-stage

# # WORKDIR /app

# # # RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -

# # RUN set -x \
# #     && apt-get update \
# #     && apt-get install -y && \
# #     apt-get install -y nodejs \
# #     npm


# # COPY package*.json /app/
# # RUN npm ci

# # COPY ./ /app/
# # ARG configuration=production

# # RUN npm run build -- --output-path=./dist/out --configuration $configuration

# # # Stage 1, based on Nginx, to have only the compiled app, ready for production with Nginx
# # FROM nginx
# # # COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf
# # COPY --from=build-stage /app/dist/out/ /usr/share/nginx/html
# # RUN chmod -R 777 /var/cache/nginx /var/run /var/log/nginx




# FROM node:alpine as node
# RUN mkdir /app
# WORKDIR /app
# # RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
# COPY package.json /app
# RUN npm install
# COPY ./ /app/
# RUN npm run build --output-path=./dist/out --prod
# # COPY . /app
# CMD ["npm", "start"]

# FROM nginx:alpine
# COPY --from=node /app/dist/out/ /usr/share/nginx/html
# RUN chmod -R 777 /var/cache/nginx /var/run /var/log/nginx




#### Stage 1: Build the angular application
FROM node as build
 
# Configure the main working directory inside the docker image. 
# This is the base directory used in any further RUN, COPY, and ENTRYPOINT 
# commands.
WORKDIR /app
 
# Copy the package.json as well as the package-lock.json and install 
# the dependencies. This is a separate step so the dependencies 
# will be cached unless changes to one of those two files 
# are made.
COPY package*.json ./
RUN npm install
 
# Copy the main application
COPY . ./
ENV NODE_OPTIONS=--openssl-legacy-provider
# Arguments
ARG configuration=production
 
# Build the application
RUN npm run build -- --outputPath=./dist/out --configuration $configuration
 
#### Stage 2, use the compiled app, ready for production with Nginx
FROM nginx
 
# Copy the angular build from Stage 1
COPY --from=build /app/dist/out/ /usr/share/nginx/html
 
# Copy our custom nginx config
COPY /nginx-custom.conf /etc/nginx/conf.d/default.conf
 
 
# Expose port 80 to the Docker host, so we can access it 
# from the outside.
EXPOSE 80
 
ENTRYPOINT ["nginx","-g","daemon off;"]