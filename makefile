all : delete tests

delete :
	rm -rf classes
	rm -rf classestest

prog :
	javac -classpath classes -sourcepath src -d classes 

tests :
	javac -classpath classes:classestest -sourcepath src:srctest -d classestest


java -classpath classes:classestest:/usr/share/junit4.jar