#!/usr/bin/env bash
# Remove any potential class files
find src/Main -type f -name "*.class" -delete
find src/Requests/Http -type f -name "*.class" -delete


# Compile Project
javac -cp src src/*.java

# Run Project
java -cp src Main.Manager localhost:3000

# Test Argument $1, $2 would be the arguments passed into the command line
