const Promise = require('bluebird');
const fs = require('fs');
Promise.promisifyAll(fs);// fs.statAsync()


// Promise.all
var files = [];
for (var i = 0; i < 100; ++i) {
    files.push(fs.writeFileAsync("/Users/ask123/Desktop/promise-test/file-" + i + ".txt", i + "", "utf-8"));
}
// console.log(files);

Promise.all(files).then(function() {
    console.log("all the files were created");
});