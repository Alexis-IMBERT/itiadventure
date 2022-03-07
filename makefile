all : clean prog tests

clean :
	rm -rf classes
	rm -rf classestest

prog :
	javac -classpath ./classes -sourcepath ./src -d ./classes $({find ./src/ -name *.java})

tests :
	javac -classpath ./classes:./classestest:/usr/share/java/junit4.jar:/usr/share/java/hamcrest-library.jar -sourcepath ./srctest:./src -d ./classestest ./srctest/fr/AllTests.java