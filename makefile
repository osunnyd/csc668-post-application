clean:
	find src/Main -type f -name "*.class" -delete
	find src/Http -type f -name "*.class" -delete
	find src/UserInterface -type f -name "*.class" -delete

local:
	# Compile Project
	javac -cp src src/Main/*.java; javac -cp src src/Http/*.java;

	# Run Project
	java -cp src Main.Manager http://localhost:3000