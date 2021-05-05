### STAGE 1: Build ###
FROM node:12.7-alpine AS build
#RUN npm install -g yarn
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
ENV PATH="./node_modules/.bin:$PATH"
COPY . ./
RUN ng build --prod
### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/nginx.conf
#COPY ../../main/resources/public /usr/share/nginx/html



#COPY .npmrc package.json yarn.lock ./
#RUN yarn install

#COPY docker/nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/clearpay /usr/share/nginx/html
