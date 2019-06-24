<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.06.2019
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>

  <title>XML parsers</title>
</head>
<body>
<div class="main">
  <main>
    <form name="testForm" action="result" method="GET">
      <label for="parser">Choose parsing type: </label>
      <select id="parser" name="parser">
        <option value="sax">SAX</option>
        <option value="dom">DOM</option>
        <option value="stax">StAX</option>
      </select>
      <hr/>
      <input class="button" type="submit" name="testButton" value="TRY PARSE">
    </form>
  </main>

</div>
</body>
</html>