#java -jar proguard\proguard-base-5.3.1.jar @HW01.1.pro

-injars       target/HW01.1.jar
-outjars      target/HW01.1-out.jar

-libraryjars  <java.home>/lib/rt.jar #contains all of the compiled class files for the base Java Runtime environment
-printmapping pgmapout.map
-dontwarn

-keep public class ru.otus.hw011.Main {public static void main(java.lang.String[]);}