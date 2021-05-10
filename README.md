# File Explorer Web App Backend

This project serves as the backend designed to work with File Explorer Web Application [frontend](https://github.com/namiranianp/fewa-front-end) in order to show files on a files system (mac/linux/windows) in the browser. 

# Running the server

If you wish to run the server, the first step is [installing PostGreSQL](https://www.postgresql.org/download/).

# Rest API

The REST API to the example app is described below.

## Add Seed Directory to System
```
GET /path/setseed/?dir={path}
```
where path is the seed directroy path.

## Get Files In a Directory
```
GET /path/getfiles/?dir={path}
```
where path is the target directory path.

## Add a Tag To a File
```
GET /tag/add/?tagName={tag}&filePath={path}
```
where tag is the name of tag and path is the path of the file.

## Remove a Tag from a file
```
GET /tag/remove/?tagName={tag}&filePath={path}
```
where tag is the name of tag and path is the path of the file.

## Display a Tag from a file
```
GET /tag/display/?tagName={tag}
```
where tag is the name of tag.

## Get File Content
```
GET /file/preview/?file={path}
```
where path is the file location.

## Search By File Name
```
GET /search/name/?file={filename}
```
where filename is the search query.

## Search By Tag Name
```
GET /search/tag/?tag={tag}
```
where tag is the search query.

## Delete File
```
GET /delete/?filePath={path}
```
where path is the file location.


