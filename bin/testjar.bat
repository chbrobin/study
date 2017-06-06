rem -Xbootclasspath:完全取代系统Java classpath.最好不用。
rem -Xbootclasspath/a: 在系统class加载后加载。一般用这个。
rem -Xbootclasspath/p: 在系统class加载前加载,注意使用，和系统类冲突就不好了.

rem win32 java -Xbootclasspath/a: some.jar;some2.jar; -jar test.jar
rem unix    java -Xbootclasspath/a: some.jar:some2.jar: -jar test.jar
rem win32系统每个jar用分号隔开，unix系统下用冒号隔开
java -jar -Xbootclasspath/a:../lib/commons-lang-2.5.jar;../lib/commons-lang-2.5.jar ../target/study-1.0-SNAPSHOT.jar "pers chbrobin study"