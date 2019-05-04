# web-board

git clone https://github.com/bitebright/web-board.git

Backend endpoint: http://206.189.86.67:8080

Note that you need to have mysql running on your machine

## How to run: Front end - iOS
1. After cloning, open Web-board.xcworkspace file located in frontend folder with xcode.
2. If you want to connect to your local server, open CommonWorker.swift and change baseUrl to http://localhost:8080.
3. Choose the simulator of your choice or connect to your physical device, then click run.

## How to run: Back end - spring boot
1. After cloning, run database.sql to create database on mysql.
2. Open SpringToolSuite or Eclipse.
3. Choose workspace at web-board folder.
4. File -> Import -> Existing Maven Project -> Navigate to the backend
5. Change mysql password in application.properties file in src/main/resources
6. Choose backend project and run as spring boot application.

## API requests
Set header's Content-Type as application/json

### Posts
1. Get Posts: 
    - Url: http://206.189.86.67:8080/posts 
    - HttpMethod: POST
    - Body: { "numberPerPage": 10,	"pageNumber": 1 }
2. Add Post: 
    - Url: http://206.189.86.67:8080/posts/add 
    - HttpMethod: POST
    - Body: { "content": "test4", "createdBy": "bright" }

### Comments
1. Get Comments: 
    - Url: http://206.189.86.67:8080/comments/bypost/{postId}
    - HttpMethod: GET
2. Add Comment: 
    - Url: http://206.189.86.67:8080/comments/add 
    - HttpMethod: POST
    - Body: { "postId": 1, "content": "test4", "createdBy": "bright" }
