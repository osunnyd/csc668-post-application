clean:
	find src/Main -type f -name "*.class" -delete
	find src/UserInterface -type f -name "*.class" -delete
	find src/Requests -type f -name "*.class" -delete
	find src/PointofSale -type f -name "*.class" -delete


local:
	# Compile Project
	javac -cp src src/Main/*.java; javac -cp src src/Requests/Http/*.java;

	# Run Project
	java -cp src Main.Manager http://localhost:3000