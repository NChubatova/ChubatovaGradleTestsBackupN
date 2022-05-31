for (($i = 0); $i -lt 25; $i++)
{
 $m='UnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTest' + $i;
 (Get-Content .\src\test\java\my\mytest1.java) -Replace 'mytest1', $m | Set-Content .\src\test\java\my\mytest$i.java
}