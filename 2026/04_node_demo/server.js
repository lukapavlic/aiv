const express = require('express');
var bodyParser = require('body-parser');
const app = express();
const port = 5050;

app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({ extended: true })); 

app.get('/', (req, res) => {
  console.log('GET!')
  res.send(`
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>Keep It Simple &amp; Stupid</title>
      </head>
      <body>
        <h1>Keep It Simple &amp; Stupid</h1>
        Zdravo, ${req.query.name}!
      </body>
    </html>
  `)
});

app.post('/', (req, res) => {
  console.log('POST!')
  console.log(req.body)

  let a=parseInt(req.body.a)
  let b=parseInt(req.body.b)

  res.send(`
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>Keep It Simple &amp; Stupid</title>
      </head>
      <body>
        <h1>Keep It Simple &amp; Stupid</h1>
        ${a} + ${b} = ${a+b}
      </body>
    </html>
  `)
});

app.listen(port, function() {
  console.log(`Port: ${port}!`)
});
