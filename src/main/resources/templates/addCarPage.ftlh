<!doctype html>
<html lang="en">
<head>
    <title>CreateCar</title>
</head>
<body>
<div class="addCarBox">
    <h1>Add Car</h1>
    <form action="/car/createcar" method="post">
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
            <input type="text" name="year" placeholder="enter year" required>
        </div>
        <div>
            <span>color</span>
            <input type="text" name="color" placeholder="enter color" required>
        </div>
        <div>
            <span>price</span>
            <input type="text" name="price"  placeholder="enter price" required>
        </div>
       <div>
           <span>amout</span>
           <input type="text" name="amount" placeholder="enter amount" required>
       </div>

        <button type="submit">Add</button>
    </form>
    <a href="/" title="home">home</a>
</div>
</body>
</html>