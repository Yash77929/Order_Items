const api = "http://localhost:8082/orders";

function getOrders() {
  fetch(api)
    .then(res => res.json())
    .then(data => {
      const div = document.getElementById("orders");
      div.innerHTML = "";
      if (data.length === 0) {
        div.innerHTML = "<i>No orders found.</i>";
        return;
      }
      data.forEach(order => {
        div.innerHTML += `<div class="order">[${order.id}] ${order.itemName} - ₹${order.price}</div>`;
      });
    });
}

function addOrder() {
  const name = document.getElementById("itemName").value;
  const price = parseFloat(document.getElementById("price").value);
  if (!name || isNaN(price)) {
    alert("Please enter a valid name and price.");
    return;
  }
  fetch(api, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ itemName: name, price: price })
  })
    .then(() => {
      alert("Order added successfully!");
      getOrders();
    });
}

function updateOrder() {
  const id = document.getElementById("updateId").value;
  const name = document.getElementById("updateItemName").value;
  const price = parseFloat(document.getElementById("updatePrice").value);
  if (!id || !name || isNaN(price)) {
    alert("Please fill all fields to update an order.");
    return;
  }

  fetch(`${api}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ itemName: name, price: price })
  })
    .then(response => {
      if (response.ok) {
        alert("Order updated successfully!");
        getOrders();
      } else {
        alert("Order not found.");
      }
    });
}

function deleteOrder() {
  const id = document.getElementById("deleteId").value;
  if (!id) {
    alert("Please enter a valid Order ID.");
    return;
  }

  fetch(`${api}/${id}`, { method: "DELETE" })
    .then(response => {
      if (response.ok) {
        alert("Order deleted successfully.");
        getOrders();
      } else {
        alert("Order not found.");
      }
    });
}

function deleteAll() {
  if (confirm("Are you sure you want to delete all orders?")) {
    fetch(api, { method: "DELETE" })
      .then(() => {
        alert("All orders deleted.");
        getOrders();
      });
  }
}

// Load all orders on page load
getOrders();
