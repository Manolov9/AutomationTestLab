set ProjectPath=C:\Automation\AutomationTestLab\target
cd %ProjectPath%
java -cp tests.jar org.testng.TestNG C:\Automation\AutomationTestLab\src\main\resources\xml_files\test_internal\TestCase_03_Leveraged.xml
pause