@echo off
echo Running example %1
java -cp examples.jar com.objectplanet.chart.examples.%1
if not errorlevel 1 goto end
echo Running java failed...
echo '
echo '
echo '
echo The program could not be started. You need to download and install java from www.javasoft.com
goto end
:end