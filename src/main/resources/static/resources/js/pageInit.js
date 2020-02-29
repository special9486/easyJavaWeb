function init() {
  $.get("/commons/topNavi.html", function(data) {
    $(document.body).prepend(data);
  });
}