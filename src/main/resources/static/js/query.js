const compiled = _.template(
  "<div>" +
      "<ul class='list-group'>" +
          "<li class='list-group-item'>" +
              "<h3>" +
              "<%= event %>" +
              "</h3>" +
          "</li>" +
      "</ul>" +
  "</div>"
);

function refresh() {
  console.clear();
  $('#status').html("");
  const url = '/store?key=' + document.id;
  fetch(url)
    .then(function(res) {
      return res.json();
    })
    .then(function(items) {
      _.each(items, function(item) {
        html = compiled({'event': item});
        $('#status').append(html);
      })
    })
}

$(document).ready(function() {
    setInterval(refresh, 3000);
})