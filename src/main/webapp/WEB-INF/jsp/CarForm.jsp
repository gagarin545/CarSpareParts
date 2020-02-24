<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <h1>Марка машины</h1>

  <%--@elvariable id="cars" type=""--%>
  <form:form modelAttribute="cars">
  <form:hidden path="id"/>
  <table>
    <tr>
        <td>Производитель :</td>
        <td><form:input path="car_name"/></td>
        <td colspan="1"><input type="submit" value="Save Changes"/></td>
    </tr>
  </table>
  </form:form>
  <script>

  </script>

  </body>
</html>