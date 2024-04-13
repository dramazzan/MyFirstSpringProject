<!doctype html>
<html lang="en">

<head>
    <title>Home</title>
</head>
<body>
<div class="carListBox">
    <h1>Car List</h1>
    <div class="title">
        <b>Brand</b>
        <b>Model</b>
        <b>Price</b>
    </div>
    <#list cars as car>
        <div class="carBox">
            <div class="carInfo">
                <span>
                    ${car.brand}
                </span>
                <span>
                    ${car.model}
                </span>
                <span>
                    ${car.price}$
                </span>
            </div>
            <div class="controller">
                <a href="/car/${car.carID}" title="details">details</a>
                <a href="/car/confirm/${car.carID}" title="delete">delete</a>
            </div>


        </div>
    </#list>
    <a href="/" title="home">home</a>

</div>


</body>
</html>