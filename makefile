all: compile

compile: Main.java
	javac -d target -sourcepath . Main.java Enums/*.java Interfaces/*.java Classes/*.java

run:
	@java -cp target: Main

runw:
	@java -cp target; Main