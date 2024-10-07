$(document).ready(function() {
    const itemCodeRegex = /^(I00-)[0-9]{3}$/;
    const itemNameRegex = /^[A-Za-z ]{3,}$/;
    const itemUpRegex= /^[0-9]{2,}([.][0-9]{2})?$/;

    $("#itemID,#itemName,#uPrice").keydown(function (e) {
        if (e.keyCode==9){//key=="Tab"
            e.preventDefault();
        }
    });
    
    $("#itemID").keydown(function (e) {
        if (e.key=="Enter"  && itemCodeRegex.test($('#itemID').val())){
            $(this).attr("style", "border-color: white !important;");
            $('#itemName').focus();
        }
    });
    
    $("#itemID").keyup(function (e) {
        if (itemCodeRegex.test($('#itemID').val())){
            $(this).attr("style", "border-color: white !important;");
        }else{
            $(this).attr("style", "border-color: red !important;");
        }
    });
    
    $("#itemName").keydown(function (e) {
        if (e.key=="Enter"  && itemNameRegex.test($('#itemName').val())){
            $(this).attr("style", "border-color: white !important;");
            $('#description').focus();
        }
    });
    
    $("#itemName").keyup(function (e) {
        if (itemNameRegex.test($('#itemName').val())){
            $(this).attr("style", "border-color: white !important;");
        }else{
            $(this).attr("style", "border-color: red !important;");
        }
    });
    $("#uPrice").keydown(function (e) {
        if (e.key=="Enter"  && itemUpRegex.test($('#uPrice').val())){
            $(this).attr("style", "border-color: white !important;");
            saveItem();
        }
    });
    
    $("#uPrice").keyup(function (e) {
        if (itemUpRegex.test($('#uPrice').val())){
            $(this).attr("style", "border-color: white !important;");
        }else{
            $(this).attr("style", "border-color: red !important;");
        }
    });
    
})