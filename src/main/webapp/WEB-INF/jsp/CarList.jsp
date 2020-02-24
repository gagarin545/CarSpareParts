<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список автомобилей</title></head>

  <head>
      <meta charset="UTF-8"/>
      <title>Page Title</title>
      <link rel="profile"href="http://gmpg.org/xfn/11"/>
      <style type="text/css">
          body {font: 92.5%/1.6 Verdana, Tahoma, sans-serif;color: #333333;}
          h1,h2{color: #ff6600;}
          #id_part.block{margin:30px auto;width: 600px;}.block{border:1px solid #ccc;border-radius:4px;box-shadow:0 0 2px #ccc;}
      </style>
  </head>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <body>


  <label for="id_car">
      <select id="id_car" name="car_name">
          <option disabled selected> Марка </option>
        <c:forEach items="${cars}" var="car">
          <option value="/model/${car.id}"> <c:out value="${car.car_name}" /> </option>
        </c:forEach>
      </select>
  </label><br><br>
  <label for="id_model" class="name-model">
      <select id="id_model">
          <option disabled selected> Модель </option>
      </select>
  </label><br><br>
  <label for="id_group" class="name-group">
      <select id="id_group">
          <option disabled selected > Группа </option>
      </select>
  </label><br><br>
  <label for="id_spare" class="name-spare">
      <select id="id_spare">
          <option disabled selected> Запчасть </option>
      </select>
  </label><br><br>


  <div class="ui-button">    <!-- buttons holder -->
      <button onclick="location.href='/car/CarForm'">Добавить производителя</button>
  </div>
  <div id="id_part" class="block" >
      <span></span>
  </div>

  <script>
      $(document).ready(function()
      {
          $('#id_car').change(function() { fillOptions('id_car', 'id_model'); });
          $('#id_model').change(function() { fillOptions('id_model', 'id_group'); });
          $('#id_group').change(function() { fillOptions('id_group', 'id_spare'); });
          $('#id_spare').change(function() { newOptions( 'id_spare', 'id_part'); });
      });
      let spare, model;
      function newOptions(parentId, ddId) {
          var jsonURL = '/' + ddId + "/" + $('#' + parentId + ' :selected').val() + '&' + model ;
          var dd = $('#' + ddId);
          dd.text(' '); //remove(); // Clean old options first.
          $.getJSON(jsonURL, function(opts) {
              if (opts) {
                  $.each(opts, function(key, value) {

                      dd.append($('<a href=""/>').val(value.id_parts).text(value.cost).append(" - ").append(value.photo)).append('<br>');
                  });
              }
              else
                  dd.append($('<span />').text("Please select parent"));
          });
      }
      function fillOptions(parentId, ddId) {
          var dd = $('#' + ddId);
          var jsonURL = '/' + ddId + "/" + $('#' + parentId + ' :selected').val();
          $.getJSON(jsonURL, function(opts) {
              $('>option', dd).remove(); // Clean old options first.
              dd.append($('<option disabled selected/>').val(0).text('Выберите значание'));
              if (opts) {
                  $.each(opts, function(key, value) {
                      switch (ddId) {
                          case "id_model":
                              dd.append($('<option/>').val(value.id_model).text(value.model_name));
                              break;
                          case "id_group":
                              dd.append($('<option/>').val(value.id_group).text(value.group_name));
                              model = ($('#' + parentId + ' :selected').val());
                              break;
                          case "id_spare":
                              dd.append($('<option/>').val(value.id_spare).text(value.spare_name));
                              break;
                      }
                  });
              }
              else
                  dd.append($('<option/>').text("Please select parent"));
          });
      }
  </script>
  </body>
</html>