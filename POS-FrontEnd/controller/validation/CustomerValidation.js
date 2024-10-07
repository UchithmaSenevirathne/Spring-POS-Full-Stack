$(document).ready(function() {
    let cusIdRegex = /^(C00-)[0-9]{3}$/;
    let cusNameRegex = /^[A-Za-z\s]+$/;
    let cusAddressRegex = /^[A-Za-z\s]+$/;
    let cusEmailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let cusContactRegex = /^\d{10}$/;

    $("#cusID, #cusName, #cusAddress, #cusEmail, #cusContact").keydown(function(e) {
        if (e.keyCode == 9) { // Tab key
            e.preventDefault();
        }
    });

    $("#cusID").keydown(function(e) {
        if (e.key == "Enter" && cusIdRegex.test($('#cusID').val())) {
            $(this).attr("style", "border-color: white !important;");
            $('#cusName').focus();
        }
    });

    $("#cusID").keyup(function(e) {
        if (cusIdRegex.test($('#cusID').val())) {
            $(this).attr("style", "border-color: white !important;");
        } else {
            $(this).attr("style", "border-color: red !important;");
        }
    });

    $("#cusName").keydown(function(e) {
        if (e.key == "Enter" && cusNameRegex.test($('#cusName').val())) {
            $(this).attr("style", "border-color: white !important;");
            $('#cusAddress').focus();
        }
    });

    $("#cusName").keyup(function(e) {
        if (cusNameRegex.test($('#cusName').val())) {
            $(this).attr("style", "border-color: white !important;");
        } else {
            $(this).attr("style", "border-color: red !important;");
        }
    });

    $("#cusAddress").keydown(function(e) {
        if (e.key == "Enter" && cusAddressRegex.test($('#cusAddress').val())) {
            $(this).attr("style", "border-color: white !important;");
            $('#cusEmail').focus();
        }
    });

    $("#cusAddress").keyup(function(e) {
        if (cusAddressRegex.test($('#cusAddress').val())) {
            $(this).attr("style", "border-color: white !important;");
        } else {
            $(this).attr("style", "border-color: red !important;");
        }
    });

    $("#cusEmail").keydown(function(e) {
        if (e.key == "Enter" && cusEmailRegex.test($('#cusEmail').val())) {
            $(this).attr("style", "border-color: white !important;");
            $('#cusContact').focus();
        }
    });

    $("#cusEmail").keyup(function(e) {
        if (cusEmailRegex.test($('#cusEmail').val())) {
            $(this).attr("style", "border-color: white !important;");
        } else {
            $(this).attr("style", "border-color: red !important;");
        }
    });

    $("#cusContact").keydown(function(e) {
        if (e.key == "Enter" && cusContactRegex.test($('#cusContact').val())) {
            $(this).attr("style", "border-color: white !important;");
            saveCustomer();
        }
    });

    $("#cusContact").keyup(function(e) {
        if (cusContactRegex.test($('#cusContact').val())) {
            $(this).attr("style", "border-color: white !important;");
        } else {
            $(this).attr("style", "border-color: red !important;");
        }
    });

});
