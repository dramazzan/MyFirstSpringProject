<!doctype html>
<html lang="en">

<head>
    <title>Car List</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/carliststyle.css">
</head>

<body>
<div class="carListBox">
    <div class="navigate">
        <h1>Car List</h1>
        <div>
            <a href="/addcarpage">add</a>
            <a href="/" title="home">home</a>
        </div>
    </div>
    <table>
        <thead>
        <tr>
            <th>Brand</th>
            <th>Model</th>
            <th>Year</th>
            <th>Color</th>
            <th>Amount</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list cars as car>
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.color}</td>
                <td>${car.amount}</td>
                <td>${car.price}$</td>
                <td class="controller">
                    <a href="/car/${car.carID}" title="details">details</a>
                    <a href="/car/confirm/${car.carID}" title="delete">delete</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>

</html>
