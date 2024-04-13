<!doctype html>
<html lang="en">
<head>
    <title>Car Info</title>
</head>
<body>
    <div class="carInfoBox">
        <h1>Car-Info</h1>
        <div class="title">
            <b>Brand</b>
            <b>Model</b>
            <b>Price</b>
        </div>
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
            <a href="/car/buycar/${car.carID}">buy</a>
            <a href="/" title="home">home</a>
        </div>



    </div>

</body>
</html>