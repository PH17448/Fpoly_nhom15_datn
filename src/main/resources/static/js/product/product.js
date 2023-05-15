function showConfirmModalDialog(id, name) {
  $("#productName").text(name);
  $("#yesOption").attr("href", "/admin/product/delete/" + id);
  $("#confirmationId").modal("show");
}

function showConfirmModalDialogDeleteAllbyId() {
  $("#confirmationDeleteIds").modal("show");
}

function deleteAll() {
  document.getElementById("formDeleteAllByIds").submit();
}

function toggle(source) {
  checkboxes = document.getElementsByName("productIds");
  for (var i = 0, n = checkboxes.length; i < n; i++) {
    checkboxes[i].checked = source.checked;
  }
}

$("#multiple-select-field").select2({
  theme: "bootstrap-5",
  width: $(this).data("width")
    ? $(this).data("width")
    : $(this).hasClass("w-100")
    ? "100%"
    : "style",
  placeholder: $(this).data("placeholder"),
  closeOnSelect: false,
});
