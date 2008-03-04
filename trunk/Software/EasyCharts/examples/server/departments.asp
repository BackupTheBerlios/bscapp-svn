<%@ LANGUAGE="VBSCRIPT" %>

<%	'## this function prints out the count for each department separated by comma (for the applet samples)
	function PrintDepartmentCount(ByRef employeeRS)
		If employeeRS.EOF Then
			exit Function
		End If
		
		While Not employeeRS.EOF
			Response.Write employeeRS("DepartmentCount")
			employeeRS.MoveNext
			if not employeeRS.eof then
				Response.Write ","
			end if
		Wend
		employeeRS.MoveFirst
	end function
	
	'## this function prints out each department name separated by comma (for the applet labels)
	function PrintDepartmentLabels(ByRef employeeRS)
		If employeeRS.EOF Then
			exit Function
		End If
		
		While Not employeeRS.EOF
			Response.Write employeeRS("Department")
			employeeRS.MoveNext
			if not employeeRS.eof then
				Response.Write ","
			end if
		Wend
		employeeRS.MoveFirst
	end function


	set DbConn=server.createobject("adodb.connection")
	cnpath="DBQ=" & server.mappath("employees.mdb")
	'Response.Write cnpath
	DbConn.Open "DRIVER={Microsoft Access Driver (*.mdb)}; " & cnpath 

	'## Let's say we have one table with employees. One of the columns
	'## is the department name, and the table name is employee
	
	'## The following lines gets the number of employees for each department
	Sql = "SELECT COUNT(*) AS DepartmentCount, Department FROM Employee GROUP BY Department ORDER BY Department"
	Set employeeRS = DbConn.Execute(Sql)
	
%>
	
<html>
<body text="#000000" bgcolor="#FFFFFF">

<applet 
	code="com.objectplanet.chart.BarChartApplet"
	archive="chart.jar"
	height=200 width=640 viewastext id=Applet5>
<param name="sampleValues" value="<%call PrintDepartmentCount(employeeRS)%>">
<param name="sampleLabels" value="<%call PrintDepartmentLabels(employeeRS)%>">
<param name="sampleLabelsOn" value=true>
<param name="valueLabelsOn" value=true>
<param name="title" value="Departments">
<param name="legendOn" value=true>
<param name="multiColorOn" value=true>
<param name="titleOn" value=true>
<param name="valueLinesOn" value=true>
</applet> 

</body>
</html>

<%	employeeRS.Close
	Set employeeRS = Nothing
	DbConn.Close
	Set DbConn = Nothing %>