set mpp=C:\Users\Admin\eclipse-workspace\NBAVerification
cd %mpp%
set classpath=%mpp%\bin;%mpp%\lib\*
java org.testng.TestNG %mpp%\searchf.xml
pause