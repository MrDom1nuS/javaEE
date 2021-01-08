
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit car</title>
</head>
<body>
<h3>Edit car</h3>
<form method="post">
<input type="hidden" value="${doctor.id}" name="id" />
<label>Car</label><br>
<input name="name" value="${doctor.name}" /><br><br>
<label>Model</label><br>
<input name="special" value="${doctor.special}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>