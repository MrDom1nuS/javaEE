
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit violation</title>
</head>
<body>
<h3>Edit violation</h3>
<form method="post">
<input type="hidden" value="${pacient.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${pacient.name}" /><br><br>
<label>Violation</label><br>
<input name="skarga" value="${pacient.skarga}" /><br><br>
<input type="submit" value="Send" />

</form>
</body>
</html>