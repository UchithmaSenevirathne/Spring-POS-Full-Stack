let CustPreID = "C00-00";
let cusNo = 1;

let customerDetail = [];

setCusID();

let isUpdateMode = false;
let selectedCustomerId = null;

$("#onActionSave").click(function () {
  if (isUpdateMode) {
    updateCustomer();
  } else {
    saveCustomer();
  }
});

function setCusID() {
  $("#cusID").val(CustPreID + cusNo);
  console.log(Number(cusNo));
}

getAllCustomer();

// $('#btnGetAll').click(function () {
//     getAllCustomer();
// });

function saveCustomer() {
  let customer = {
    id: $("#cusID").val(),
    name: $("#cusName").val(),
    address: $("#cusAddress").val(),
    email: $("#cusEmail").val(),
    contact: $("#cusContact").val(),
  };

  $.ajax({
    url: "http://localhost:8080/POS_Backend/customer",
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify(customer),
    success: function () {
      alert("Customer saved successfully");
      getAllCustomer();
      resetCusForm();
      cusNo++;
      setCusID();
    },
    error: function (err) {
      console.error(err);
      alert("Failed to save customer");
    },
  });
  //   let cusID = $("#cusID").val();
  //   let cusName = $("#cusName").val();
  //   let cusAddress = $("#cusAddress").val();
  //   let cusEmail = $("#cusEmail").val();
  //   let cusContact = $("#cusContact").val();

  //   let newCustomer = Object.assign({}, customerOb);
  //   newCustomer.customerID = cusID;
  //   newCustomer.customerName = cusName;
  //   newCustomer.customerAddress = cusAddress;
  //   newCustomer.customerEmail = cusEmail;
  //   newCustomer.customerContact = cusContact;

  //   if (true) {
  //     customerDetail.push(newCustomer);
  //     console.log(customerDetail);
  //     clearCustomerFeilds();
  //     getAllCustomer();

  //     alert("SAVED SUCCSESS...!");

  //     cusNo++;
  //     setCusID();
  //     console.log(cusNo);
  //   } else {
  //     alert("THIS CUSTOMER ALREADY IN THIS SYSTEM");
  //     clearCustomerFeilds();
  //   }
  //   cusNames();
}

function getAllCustomer() {
  $.ajax({
    url: "http://localhost:8080/POS_Backend/customer",
    method: "GET",
    success: function (data) {
      customerDetail = data;
      let tbody = $("#customerTbody");
      tbody.empty();
      data.forEach((customer) => {
        let row = `<tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.email}</td>
                <td>${customer.contact}</td>
                <td>
                    <button class="btn btn-sm btn-danger" onclick="deleteCustomer('${customer.id}')">Delete</button>
                </td>
            </tr>`;
        tbody.append(row);
        bindCustomerTrEvents();
      });
    },
    error: function (err) {
      console.error(err);
      alert("Failed to load customers");
    },
  });
  //   for (let i = 0; i < customerDetail.length; i++) {
  //     let id = customerDetail[i].customerID;
  //     let name = customerDetail[i].customerName;
  //     let address = customerDetail[i].customerAddress;
  //     let email = customerDetail[i].customerEmail;
  //     let contact = customerDetail[i].customerContact;

  //     let row = `<tr>
  //                     <td>${id}</td>
  //                     <td>${name}</td>
  //                     <td>${address}</td>
  //                     <td>${email}</td>
  //                     <td>${contact}</td>
  //                     <td><button class="delete-btn bg-danger text-white border rounded" onclick="deleteCustomer('${id}', this)">Delete</button></td>
  //                 </tr>`;
  //     $("#tblcustomer").append(row);
  //     bindCustomerTrEvents();
  //   }
  // getCustomers();
}

function bindCustomerTrEvents() {
  $("#customerTbody>tr").click(function (event) {
    let id = $(this).children().eq(0).text();
    let name = $(this).children().eq(1).text();
    let address = $(this).children().eq(2).text();
    let email = $(this).children().eq(3).text();
    let contact = $(this).children().eq(4).text();

    $("#cusID").val(id);
    $("#cusName").val(name);
    $("#cusAddress").val(address);
    $("#cusEmail").val(email);
    $("#cusContact").val(contact);

    selectedCustomerId = id;
    isUpdateMode = true;
    $("#onActionSave")
      .text("UPDATE CUSTOMER")
      .removeClass("saveCus")
      .addClass("updateCus");
  });
}

function updateCustomer() {
  let customer = {
    id: $("#cusID").val(),
    name: $("#cusName").val(),
    address: $("#cusAddress").val(),
    email: $("#cusEmail").val(),
    contact: $("#cusContact").val(),
  };

  $.ajax({
    url: "http://localhost:8080/POS_Backend/customer",
    method: "PUT",
    contentType: "application/json",
    data: JSON.stringify(customer),
    success: function () {
      alert("Customer updated successfully");
      getAllCustomer();
      resetCusForm();
      isUpdateMode = false;
      selectedCustomerId = null;
      $("#onActionSave")
        .text("REGISTER CUSTOMER")
        .removeClass("updateCus")
        .addClass("saveCus");
    },
    error: function (err) {
      console.error(err);
      alert("Failed to update customer");
    },
  });
  // let cusID = $("#cusID").val();
  // let cusName = $("#cusName").val();
  // let cusAddress = $("#cusAddress").val();
  // let cusEmail = $("#cusEmail").val();
  // let cusContact = $("#cusContact").val();

  // let consent = confirm("DO U WANT UPDATE THIS CUSTOMER");

  // if (consent) {
  //   for (let i = 0; i < customerDetail.length; i++) {
  //     if (customerDetail[i].customerID == selectedCustomerId) {
  //       customerDetail[i].customerID = cusID;
  //       customerDetail[i].customerName = cusName;
  //       customerDetail[i].customerAddress = cusAddress;
  //       customerDetail[i].customerEmail = cusEmail;
  //       customerDetail[i].customerContact = cusContact;

  //       getAllCustomer();
  //       clearCustomerFeilds();
  //       alert("UPDATED SUCCSESS...!");

  //       break;
  //     }
  //   }
  //   isUpdateMode = false;
  //   selectedCustomerId = null;
  //   $("#onActionSave")
  //     .text("REGISTER CUSTOMER")
  //     .removeClass("update")
  //     .addClass("save");
  // } else {
  //   clearCustomerFeilds();
  // }
  setCusID();
  // cusNames();
}

function deleteCustomer(id) {
  $.ajax({
    url: `http://localhost:8080/POS_Backend/customer?id=${id}`,
    method: 'DELETE',
    success: function() {
        alert('Customer deleted successfully');
        getAllCustomer();
        resetCusForm();
    },
    error: function(err) {
        console.error(err);
        alert('Failed to delete customer');
    }
});
  // let consent = confirm("DO U WANT DELETE THIS CUSTOMER");

  // if (consent) {
  //   for (let i = 0; i < customerDetail.length; i++) {
  //     if (customerDetail[i].customerID == customerID) {
  //       customerDetail.splice(i, 1);
  //       getAllCustomer();
  //       clearCustomerFeilds();

  //       alert("DELETED SUCCSESS...!");
  //       break;
  //     }
  //   }
  // } else {
  //   clearCustomerFeilds();
  // }

  setCusID();
  // cusNames()
}

function resetCusForm() {
  $('#cusID').val('');
  $('#cusName').val('');
  $('#cusAddress').val('');
  $('#cusEmail').val('');
  $('#cusContact').val('');
  $('#onActionSave').text('REGISTER CUSTOMER');
  $('#onActionSave').off('click').on('click', saveCustomer);
}

// function clearCustomerFeilds() {
//   $("#cusID,#cusName,#cusAddress,#cusEmail,#cusContact").val("");
//   $("#cusID").focus();
// }


$("#searchCus").on("input", function () {
  filterCustomers();
});


function filterCustomers() {
  // $("#customerTbody").empty();
  // let searchValue = $("#searchCus").val().toLowerCase();
  // let filteredCustomers = customerDetail.filter(customer => 
  //   customer.customerID.toLowerCase().includes(searchValue) ||
  //   customer.customerName.toLowerCase().includes(searchValue) ||
  //   customer.customerAddress.toLowerCase().includes(searchValue) ||
  //   customer.customerEmail.toLowerCase().includes(searchValue) ||
  //   customer.customerContact.toLowerCase().includes(searchValue)
  // );
  // renderCustomerTable(filteredCustomers);
  $("#customerTbody").empty();
  let searchValue = $("#searchCus").val().toLowerCase();
  console.log(customerDetail);
  for (let i = 0; i < customerDetail.length; i++) {
    if (
      customerDetail[i].id.toLowerCase().includes(searchValue) ||
      customerDetail[i].name.toLowerCase().includes(searchValue) ||
      customerDetail[i].address.toLowerCase().includes(searchValue) ||
      customerDetail[i].email.toLowerCase().includes(searchValue) ||
      customerDetail[i].contact.toLowerCase().includes(searchValue)
    ) {
      let id = customerDetail[i].id;
      let name = customerDetail[i].name;
      let address = customerDetail[i].address;
      let email = customerDetail[i].email;
      let contact = customerDetail[i].contact;

      let row = `<tr>
                        <td>${id}</td>
                        <td>${name}</td>
                        <td>${address}</td>
                        <td>${email}</td>
                        <td>${contact}</td>
                        <td><button class="delete-btn bg-danger text-white border rounded" onclick="deleteCustomer('${id}', this)">Delete</button></td>
                    </tr>`;

      $("#customerTbody").append(row);
      bindCustomerTrEvents();
    }
  }
}

function renderCustomerTable(customers) {
  $("#customerTbody").empty();
  customers.forEach(customer => {
    let row = `<tr>
                <td>${customer.customerID}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customerAddress}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerContact}</td>
                <td><button class="delete-btn bg-danger text-white border rounded" onclick="deleteCustomer('${customer.customerID}', this)">Delete</button></td>
              </tr>`;
    $("#customerTbody").append(row);
  });
  bindCustomerTrEvents();
}
