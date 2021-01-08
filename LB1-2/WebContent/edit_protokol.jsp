
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit protokol</title>
</head>
<body>
<h3>Edit protokol</h3>
<form method="post">
<input type="hidden" value="${priyom.id}" name="id" />
<label>Name</label><br>
<input name="skarga" value="${priyom.skarga}" /><br><br>
<label>Protokol</label><br>
<input name="diagnos" value="${priyom.diagnos}" /><br><br>

</form>
</body>
</html>