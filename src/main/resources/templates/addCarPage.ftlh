<!doctype html>
<html lang="en">
<head>
    <title>CreateCar</title>
</head>
<body>
<div class="addCarBox">
    <h1>Add Car</h1>
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
            <input type="file" name="file1">
            <input type="file" name="file2">
            <input type="file" name="file3">
        </div>

        <button type="submit">Add</button>
    </form>
    <a href="/" title="home">home</a>
</div>
</body>
</html>