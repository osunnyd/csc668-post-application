clean:
	find src/ -type f -name "*.class" -delete

local:
	# Compile Project
	javac -cp src src/Main/*.java; javac -cp src src/Requests/Http/*.java;

	# Run Project
	java -cp src Main.Manager http://localhost:3000