for (($i = 0); $i -lt 25000; $i++)
{
 $m='UnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTest' + $i;
 (Get-Content .\src\test\java\my\mytest.java) -Replace 'mytest', $m  | Set-Content .\src\test\java\my\UnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTest$i.java
}