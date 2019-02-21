#!/bin/bash
# Remove any potential class files
find src/Main -type f -name "*.class" -delete

# Compile Project
javac -cp src src/Main/*.java

# Run Project
java -cp src Main.Manager src/InputFiles/products.txt src/InputFiles/transactions.txt

# Test Argument $1, $2 would be the arguments passed into the command line
