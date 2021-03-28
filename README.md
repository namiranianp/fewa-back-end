# File Explorer Web App Backend

This project serves as the backend designed to work with File Explorer Web Application [frontend](https://github.com/namiranianp/fewa-front-end) in order to show files on a files system (mac/linux/windows) in the browser. 

# Running the server

If you wish to run the server, the first step is [installing PostGreSQL](https://www.postgresql.org/download/).

# Rest API

The REST API to the example app is described below.

## Add Seed Directory to System
```
POST /seed/?dir={path}
```
where path is the seed directroy path.

## Add a Tag to a file
```
POST /tag/add/?tagName={tag}&filePath={path}
```
where tag is the name of tag and path is the path of the file.

## Remove a Tag from a file
```
DELETE /tag/remove/?tagName={tag}&filePath={path}
```
where tag is the name of tag and path is the path of the file.

## Get File Content
```
GET /file/?file={path}
```
where path is the file location.
