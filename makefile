clean:
	find src/ -type f -name "*.class" -delete

local:
	javac -cp ".:./jars/gson-2.8.5.jar:src" -sourcepath src src/Main/*java
	java -cp ".:./jars/gson-2.8.5.jar:src" Main.Manager http://localhost:3000

live: 	
	javac -cp ".:./jars/gson-2.8.5.jar:src" -sourcepath src src/Main/*java
	java -cp ".:./jars/gson-2.8.5.jar:src" Main.Manager https://post-server.herokuapp.com