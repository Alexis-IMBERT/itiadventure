all : delete prog

delete :
	rm -rf classes

prog :
	javac -classpath classes -sourcepath src -d classes src/fr/main.java
