for (($i = 0); $i -lt 3; $i++)
{
 $m='UnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTest' + $i;
 (Get-Content .\src\test\java\my\mytest.java) -Replace 'mytest1', $m | Set-Content .\src\test\java\my\UnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTest$i.java
}