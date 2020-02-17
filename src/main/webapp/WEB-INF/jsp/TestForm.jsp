<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="ru.service.CarService" %>
<%@ page import="ru.entity.MakeCarEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Parcel for ${parcel.car_name}</title></head>
  <body>
  <h1>Parcel for ${parcel.car_name}</h1>
  <%
      @Autowired
      CarService carService;

      List<MakeCarEntity> cars = carService.carsList();
      cars.forEach(x-> {
          try {
              out.println(x.getCar_name());
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
  %>

  </body>
</html>