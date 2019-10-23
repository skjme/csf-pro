const fs = require('fs')

let rs = fs.createReadStream('./test.md',{highWaterMark:4})
let data = ''
rs.setEncoding('utf-8')
rs.on('data',(chunk) => {
    console.log(chunk);
    data += chunk
})

rs.on('end',(params) => {
    console.log(data);
})