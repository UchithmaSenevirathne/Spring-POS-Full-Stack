let itPreID = "I00-00";
let itNo = 1;

let itemDetail = [];

setItemID();

let isUpdateModeItem = false;
let selectedItemId = null;

$("#onActionSaveItem").click(function () {
  if (isUpdateModeItem) {
    updateItem();
  } else {
    saveItem();
  }
});

function setItemID() {
  $("#itemID").val(itPreID + itNo);
  console.log(Number(itNo));
}

getAllItem();

// $('#btnGetAllItem').click(function () {
//     getAllItem();
// });

function saveItem() {
  let item = {
    id: $("#itemID").val(),
    name: $("#itemName").val(),
    description: $("#description").val(),
    unit_price: $("#uPrice").val(),
  };

  $.ajax({
    url: "http://localhost:8080/POS_Backend/item",
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify(item),
    success: function () {
      alert("Item saved successfully");
      getAllItem();
      resetItemForm();
      itNo++;
      setItemID();
    },
    error: function (err) {
      console.error(err);
      alert("Failed to save item");
    },
  });
  // let iId=$('#itemID').val();
  // let name=$('#itemName').val();
  // let description=$('#description').val();
  // let unitPrice=$('#uPrice').val();

  // let newItem=Object.assign({},ItemOb);
  // newItem.itemID=iId;
  // newItem.itemName=name;
  // newItem.itemDescription=description;
  // newItem.itemUnitPrice=unitPrice;

  // if (true){
  //     itemDetails.push(newItem);
  //     getAllItem();
  //     clearItemFeilds();

  //     itNo++;
  //     setItemID();
  //     console.log(itNo);

  // }else{
  //     alert("THIS ITEM ALREADY IN THIS SYSTEM");
  //     clearItemFeilds();
  // }

  // itemNames();
}

function getAllItem() {
  $.ajax({
    url: "http://localhost:8080/POS_Backend/item",
    method: "GET",
    success: function (data) {
      itemDetail = data;
      let tbody = $("#itemTbody");
      tbody.empty();
      data.forEach((item) => {
        let row = `<tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                    <td>${item.unit_price}</td>
                    <td>
                        <button class="btn btn-sm btn-danger" onclick="deleteItem('${item.id}')">Delete</button>
                    </td>
                </tr>`;
        tbody.append(row);
        bindItemTrEvents();
      });
    },
    error: function (err) {
      console.error(err);
      alert("Failed to load item");
    },
  });
  // $('#itemTbody').empty();
  // for (let i = 0; i < itemDetails.length; i++) {
  //     let id = itemDetails[i].itemID;
  //     let name = itemDetails[i].itemName;
  //     let desc = itemDetails[i].itemDescription;
  //     let up = itemDetails[i].itemUnitPrice;

  //     let itemRow = `<tr>
  //                 <td>${id}</td>
  //                 <td>${name}</td>
  //                 <td>${desc}</td>
  //                 <td>${up}</td>
  //                 <td><button class="delete-btn bg-danger text-white border rounded" onclick="deleteItem('${id}', this)">Delete</button></td>
  //             </tr>`

  //     $('#tblItem').append(itemRow);
  //     bindItemTrEvents();
  // }
//   getItems();
}

function bindItemTrEvents() {
  $("#itemTbody>tr").click(function (event) {
    let id = $(this).children().eq(0).text();
    let name = $(this).children().eq(1).text();
    let desc = $(this).children().eq(2).text();
    let uP = $(this).children().eq(3).text();

    $("#itemID").val(id);
    $("#itemName").val(name);
    $("#description").val(desc);
    $("#uPrice").val(uP);

    selectedItemId = id;
    isUpdateModeItem = true;
    $("#onActionSaveItem")
      .text("UPDATE ITEM")
      .removeClass("saveItem")
      .addClass("updateItem");
  });
}

function updateItem() {
  let item = {
    id: $("#itemID").val(),
    name: $("#itemName").val(),
    description: $("#description").val(),
    unit_price: $("#uPrice").val(),
  };

  $.ajax({
    url: "http://localhost:8080/POS_Backend/item",
    method: "PUT",
    contentType: "application/json",
    data: JSON.stringify(item),
    success: function () {
      alert("Item updated successfully");
      getAllItem();
      resetItemForm();
      isUpdateModeItem = false;
      selectedItemId = null;
      $("#onActionSaveItem")
        .text("ADD ITEM")
        .removeClass("updateItem")
        .addClass("saveItem");
    },
    error: function (err) {
      console.error(err);
      alert("Failed to update item");
    },
  });

  // let iId=$('#itemID').val();
  // let name=$('#itemName').val();
  // let description=$('#description').val();
  // let unitPrice=$('#uPrice').val();

  // let itemConsent=confirm("DO YOU WANT UPDATE THIS ITEM");

  // if (itemConsent){
  //     for (let i = 0; i < itemDetails.length; i++) {
  //         if (itemDetails[i].itemID == selectedItemId){
  //             itemDetails[i].itemID=iId;
  //             itemDetails[i].itemName=name;
  //             itemDetails[i].itemDescription=description;
  //             itemDetails[i].itemUnitPrice=unitPrice;

  //             getAllItem();
  //             clearItemFeilds();
  //             alert("ITEM UPDATED SUCCSESS");
  //             break;
  //         }
  //     }
  //     isUpdateModeItem = false;
  //     selectedItemId = null;
  //     $('#onActionSaveItem').text('ADD ITEM').removeClass('update').addClass('save');

  // }else {
  //     clearItemFeilds();
  // }

  setItemID();
}

function deleteItem(id) {
  $.ajax({
    url: `http://localhost:8080/POS_Backend/item?id=${id}`,
    method: "DELETE",
    success: function () {
      alert("Item deleted successfully");
      getAllItem();
      resetItemForm();
    },
    error: function (err) {
      console.error(err);
      alert("Failed to delete item");
    },
  });
  // let consent=confirm("DO U WANT DELETE THIS ITEM");

  // if(consent){
  //     for (let i = 0; i < itemDetails.length; i++) {
  //         if (itemDetails[i].itemID==itemID){
  //             itemDetails.splice(i,1);
  //             getAllItem();
  //             clearItemFeilds()

  //             alert("ITEM DELETED SUCCSESS...!");
  //             break;
  //         }
  //     }
  // }else{
  //     clearItemFeilds();
  // }

  setItemID();
}

// function clearItemFeilds() {
//     $("#itemID,#itemName,#description,#uPrice").val("");
//     $('#itemID').focus();
// }

function resetItemForm() {
  $("#itemID").val("");
  $("#itemName").val("");
  $("#description").val("");
  $("#uPrice").val("");
  $("#onActionSaveItem").text("ADD ITEM");
  $("#onActionSaveItem").off("click").on("click", saveItem);
}

$("#searchItem").on("input", function () {
  filterItems();
});

function filterItems() {
  $("#itemTbody").empty();
  let searchValue = $("#searchItem").val().toLowerCase();
  for (let i = 0; i < itemDetail.length; i++) {
    if (
      itemDetail[i].id.toLowerCase().includes(searchValue) ||
      itemDetail[i].name.toLowerCase().includes(searchValue) ||
      itemDetail[i].description.toLowerCase().includes(searchValue)
    ) {
      let id = itemDetail[i].id;
      let name = itemDetail[i].name;
      let desc = itemDetail[i].description;
      let up = itemDetail[i].unit_price;

      let row = `<tr>
                        <td>${id}</td>
                        <td>${name}</td>
                        <td>${desc}</td>
                        <td>${up}</td>
                        <td><button class="delete-btn bg-danger text-white border rounded" onclick="deleteItem('${id}', this)">Delete</button></td>
                    </tr>`;

      $("#tblItem").append(row);
      bindItemTrEvents();
    }
  }
}

// $('#btnSearchItem').click(function () {
//     $('#itemTbody').empty();
//     for (let i = 0; i <itemDetails.length ; i++) {
//         if (itemDetails[i].itemID.toLowerCase().includes($('#searchItem').val()) ||
//             itemDetails[i].itemName.toLowerCase().includes($('#searchItem').val()) ||
//             itemDetails[i].itemDescription.toLowerCase().includes($('#searchItem').val()) ){

//             let id=itemDetails[i].itemID;
//             let name=itemDetails[i].itemName;
//             let desc=itemDetails[i].itemDescription;
//             let up=itemDetails[i].itemUnitPrice;

//             let row=`<tr>
//                         <td>${id}</td>
//                         <td>${name}</td>
//                         <td>${desc}</td>
//                         <td>${up}</td>
//                         <td><button class="delete-btn bg-danger text-white border rounded" onclick="deleteItem('${id}', this)">Delete</button></td>
//                     </tr>`

//             $("#tblItem").append(row);
//             bindItemTrEvents();

//             break;
//         }
//     }
// });
