<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список автомобилей</title></head>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <body>
  <h3>Список автомобилей</h3>

  <label for="id_car">
      <select id="id_car" name="car_name">
        <c:forEach items="${cars}" var="car">
          <option value="/model/${car.id}"> <c:out value="${car.car_name}" /> </option>
        </c:forEach>
      </select>
  </label><br>
  <label for="id_model" class="name-model">
      <select id="id_model">
          <option disabled selected> Марка </option>
      </select>
  </label><br>
  <label for="id_group" class="name-group">
      <select id="id_group">
          <option disabled selected > Группа </option>
      </select>
  </label><br>
  <label for="id_spare" class="name-spare">
      <select id="id_spare">
          <option disabled selected>Запчасть </option>
      </select>
  </label>


  <div>    <!-- buttons holder -->
      <button onclick="location.href='/car/CarForm'">Добавить производителя</button>
  </div>
  <span></span>
  <script>
      $(document).ready(function()
      {
          $('#id_car').change(function() { fillOptions('id_car', 'id_model'); });
          $('#id_model').change(function() { fillOptions('id_model', 'id_group'); });
          $('#id_group').change(function() { fillOptions('id_group', 'id_spare'); });
          $('#id_spare').change(function() { fillOptions( 'id_spare', 'id_part'); });
       //   $('#id_spare').change(function() { newOptions( 'id_spare'); });
      });
      function newOptions(parentId) {

      }
      function fillOptions(parentId, ddId) {
          var dd = $('#' + ddId);
          var jsonURL = '/' + ddId + "/" + $('#' + parentId + ' :selected').val();
          let spare, model;

          $.getJSON(jsonURL, function(opts) {
            //  alert(`opts[0]`.d);
              $('>option', dd).remove(); // Clean old options first.
              if (opts) {
                  $.each(opts, function(key, value) {
                      switch (ddId) {
                          case "id_model":
                              dd.append($('<option/>').val(value.id_model).text(value.model_name));
                              break;
                          case "id_group":
                              dd.append($('<option/>').val(value.id_group).text(value.group_name));
                              model = ($('#' + parentId + ' :selected').val());
                              $("span").text(model);
                              break;
                          case "id_spare":
                              dd.append($('<option/>').val(value.id_spare).text(value.spare_name));
                              break;
                          case "is_part":
                              $("span").text($('#' + parentId + ' :selected').val());
                              break;
                      }
                  });
              }
              else {
                  dd.append($('<option/>').text("Please select parent"));
              }
          });
          $("span").text(model);
      }
  </script>
  </body>
</html>