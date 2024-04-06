<!doctype html>
<html lang="en">
<style>
    *{
        margin:0;
        padding:0;
    }
    div , p{
        margin:5px;
    }
    form{
        margin:10px;
        padding:0;
    }
    input{
        margin:5px;
    }
</style>
<head>
    <title>Home</title>
</head>
<body>
<h1>Car List</h1>
    <#list cars as car>
        <div>
            <p>
                <b>${car.brand}</b> ${car.model} | ${car.price}$ |
                <a href="/car/${car.carID}">details...</a>
                <a href="/car/deletecar/${car.carID}">delete</a>
            </p>

        </div>
        <hr>


    </#list>

<h1>Add Car</h1>
<form action="/car/createcar" method="post">
    <span>brand</span>
    <input type="text" name="brand" required><br>
    <span>model</span>
    <input type="text" name="model" required><br>
    <span>year</span>
    <input type="text" name="year" required><br>
    <span>color</span>
    <input type="text" name="color" required><br>
    <span>price</span>
    <input type="text" name="price" required><br>
    <span>amout</span>
    <input type="text" name="amount" required><br>

    <button type="submit">Add</button>
</form>

</body>
</html>