
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var form = document.getElementById("logout-form");
	document.getElementById("link-submit").addEventListener("click",
			function() {
				form.submit();
			});
</script>

<script>
	function showDeleteIcon(box) {
		var chboxs = document.getElementsByName("delids");
		var vis = "none";
		for (var i = 0; i < chboxs.length; i++) {
			if (chboxs[i].checked) {
				vis = "block";
				break;
			}
		}
		document.getElementById(box).style.display = vis;
	}
</script>