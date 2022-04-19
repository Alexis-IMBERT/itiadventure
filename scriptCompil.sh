
rm -rf classes/*
rm -rf classestest/*
javac -classpath ./classes -sourcepath ./src -d ./classes -Xlint $(find ./src/ -name *.java)
javac -classpath ./classes:./classestest:/usr/share/java/junit4.jar:/usr/share/java/hamcrest-library.jar -sourcepath ./srctest:./src -d ./classestest ./srctest/fr/AllTests.java
