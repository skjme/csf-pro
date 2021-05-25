const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/test', { useNewUrlParser: true});

const db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function(){

});


const kittySchema =  new mongoose.Schema({
    name: String
});

kittySchema.methods.speak = function () {
    const greeting = this.name
      ? "Meow name is " + this.name
      : "I don't have a name";
    console.log(greeting);
  }


const Kitten = mongoose.model('Kitten', kittySchema);

const slience =  new Kitten({ name: 'Silence'});
console.log(slience.name);
slience.speak();


// save to mongodb 
// slience.save(function(err, slience) {
//     if(err){ 
//         return console.error(err);
//     }

//     slience.speak();
// });

// query mongodb
Kitten.find(function(err, kittens){
    if(err){return console.error(err);}
    console.log(kittens);
});

Kitten.find({name:'Silence'}, function(err, kittens){
    if(err){return console.error(err);}
    console.log(kittens);
});

