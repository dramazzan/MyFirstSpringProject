<!doctype html>
<html lang="en">
<head>
    <title>CreateCar</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/addcar.css">
</head>
<body>
<div class="addCarBox">
    <div class="navigation">
        <h1>Add Car</h1>
        <div class="linkBox">
            <a href="/car/carlist">cars</a>
            <a href="/" title="home">home</a>
        </div>

    </div>

    <form action="/car/create" method="post" enctype="multipart/form-data">
        <div>
            <span>brand</span>
            <input type="text" name="brand" placeholder="enter brand" required>
        </div>
        <div>
            <span>model</span>
            <input type="text" name="model" placeholder="enter model" required>
        </div>
        <div>
            <span>year</span>
            <input type="number" name="year" placeholder="enter year" required>
        </div>
        <div>
            <span>color</span>
            <input type="text" name="color" placeholder="enter color" required>
        </div>
        <div>
            <span>price</span>
            <input type="number" name="price" placeholder="enter price" required>
        </div>
        <div>
            <span>amout</span>
            <input type="number" name="amount" placeholder="enter amount" required>
        </div>
        <div class="addImageBox">
            <span>image</span>
            <div>
                <input type="file" name="file1">
                <input type="file" name="file2">
                <input type="file" name="file3">
            </div>

        </div>

        <button type="submit">Add</button>
    </form>

</div>
</body>
</html>