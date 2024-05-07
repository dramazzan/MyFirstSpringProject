<!doctype html>
<html lang="en">
<head>
    <title>Car Info</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/cardata.css">
</head>
<body>
<div class="carInfoBox">
    <div class="navigate">
        <h1>Car-Info</h1>
        <div class="controller">
            <a href="/car/carlist" title="cars">cars</a>
            <a href="/" title="home">home</a>
        </div>
    </div>


    <div class="carInfo">

        <div class="imageBox">
            <#list images as img>
                <img src="/images/${img.id}" alt="${img.name}">
            </#list>
        </div>

        <div class="carData">
            <div>
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
            <div class="buyButton">
                <a href="/car/buycar/${car.carID}">buy</a>
            </div>
        </div>




    </div>



</div>

</body>
</html>