Spring-boot-ai-backend --
Ollama deepseek ai project exciting project. 😊 follow these steps:

Set Up Ollama Locally: Download and install Ollama from https://ollama.com/download/windows
cmd- ollama run deepseek-r1:7b 
enter
check ki ollama download huaa ya nhi
http://localhost:11434/
Ollama is running

Create a Spring Boot Project: using Spring Initializr. Add the necessary dependencies for Spring Web, Thymeleaf, and Ollama Spring Reactive Web2.
Configure Application Properties: Update your application.properties include Ollama
spring.ai.ollama.chat.options.model=deepseek-r1:latest
from https://docs.spring.io/spring-ai/reference/api/chatclient.html this website spring.io

Create Service and Controller Classes: Implement the service class to handle AI interactions and the controller class to manage HTTP requests.
http://localhost:8081/api/v1/ai
http://localhost:8081/api/v1/ai?query=question puch sakte h yha

Build the Chat UI: Create a chat form as the user interface to interact with your AI model.

Test the Application: Run your Spring Boot application and test the chat functionality to ensure everything is working correctly.