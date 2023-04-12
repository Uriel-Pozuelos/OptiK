//3 insertOne
db.movies.insertOne({title: "The Godfather", description: "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", genre: "Crime", year: 1972})

db.movies.insertOne({title: "The Godfather: Part II", description: "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.", genre: "Crime", year: 1974})

db.movies.insertOne({title: "The Dark Knight", description: "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.", genre: "Action", year: 2008})

//1 insertMany with 6 movies

db.movies.insertMany([{title:"avengers", description:"marvel movie", genre:"superhero", year:2012}, {title:"avengers: age of ultron", description:"marvel movie", genre:"superhero", year:2015}, {title:"avengers: infinity war", description:"marvel movie", genre:"superhero", year:2018}, {title:"avengers: endgame", description:"marvel movie", genre:"superhero", year:2019}, {title:"avengers: endgame", description:"marvel movie", genre:"superhero", year:2019}, {title:"avengers: endgame", description:"marvel movie", genre:"superhero", year:2019}])

//6 insert
db.movies.insert({title:"harry potter", description:"harry potter movie", genre:"fantasy", year:2001})
db.movies.insert({title:"harry potter and the chamber of secrets", description:"harry potter movie", genre:"fantasy", year:2002})
db.movies.insert({title:"harry potter and the prisoner of azkaban", description:"harry potter movie", genre:"fantasy", year:2004})
db.movies.insert({title:"harry potter and the goblet of fire", description:"harry potter movie", genre:"fantasy", year:2005})
db.movies.insert({title:"harry potter and the order of the phoenix", description:"harry potter movie", genre:"fantasy", year:2007})
db.movies.insert({title:"harry potter and the half-blood prince", description:"harry potter movie", genre:"fantasy", year:2009})

//update db.movies.insert({title:"harry potter and the chamber of secrets", description:"harry potter movie", genre:"fantasy", year:2002})

db.movies.update({title:"harry potter and the chamber of secrets"}, {$set:{year:2003}})

//hacer un proyecion de los campos title y year de los documentos de la colección movies

db.movies.find({}, {title:1, year:1})

db.movies.find({}, {year:1, description:1})

db.movies.find({}, {title:1, description:1})

//replaceOne con upset

db.movies.replaceOne({title:"harry potter and the chamber of secrets", year: 2003}, {title:"harry potter and the chamber of secrets", description:"harry potter movie", genre:"fantasy", year:2002}, {upsert:true})

db.movies.replaceOne({title:"avengers: endgame", year:2019}, {title:"avengers: endgame", description:"final marvel movie", genre:"superhero", year:2019}, {upsert:true})

db.movies.replaceOne({year:2002, title:"harry potter and the chamber of secrets"}, {title:"harry potter and the chamber of secrets", description:"harry potter movie", genre:"fantasy", year:2004}, {upsert:true})

//replaceOne sin upset

db.movies.replaceOne({genre:"fantasy", year:2004}, {title:"harry potter and the chamber of secrets", description:"harry potter movie", genre:"fantasy and magic", year:2004})

db.movies.replaceOne({year:2008, title:"The Dark Knight"}, {title:"The Dark Knight", description:"The Dark Knight movie", genre:"Action and Superhero", year:2008})

db.movies.replaceOne({title:"The Godfather", year:1972}, {title:"The Godfather", description:"The Godfather movie", genre:"Crime", year:1972})

//update

db.movies.update({title:"harry potter and the chamber of secrets", genre:'fantasy and magic'}, {$set:{year:2003, title:"harry potter and the chamber of secrets", description:"the second harry potter movie", genre:"fantasy"}})

db.movies.update({title:"harry potter and the prisoner of azkaban", genre:'fantasy'}, {$set:{year:2004, title:"harry potter and the prisoner of azkaban", description:"the third harry potter movie", genre:"fantasy"}})

db.movies.update({title:"harry potter and the goblet of fire", genre:'fantasy'}, {$set:{year:2005, title:"harry potter and the goblet of fire", description:"the fourth harry potter movie", genre:"fantasy"}})

//update with multi

db.movies.update({year:2004, genre:'fantasy'}, {$set:{year:2003, title:"harry potter and the prisoner of azkaban", description:"the third harry potter movie", genre:"fantasy"}}, {multi:true})

db.movies.update({year:2005, genre:'fantasy'}, {$set:{year:2004, title:"harry potter and the goblet of fire", description:"the fourth harry potter movie", genre:"fantasy"}}, {multi:true})

db.movies.update({year:2007, genre:'fantasy'}, {$set:{year:2006, title:"harry potter and the order of the phoenix", description:"the fifth harry potter movie", genre:"fantasy"}}, {multi:true})

// hacer las inserciones anteriores pero con 4 documentos embedidos
// hacer un insertOne con 4 documentos embedidos
db.movies.insertOne({
title: "harry potter",
description: "harry potter movie",
genre: "fantasy",
year: 2001,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
})

// hacer un insertMany con 4 documentos embedidos
db.movies.insertMany([
{
title: "harry potter and the chamber of secrets",
description: "harry potter movie",
genre: "fantasy",
year: 2002,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
},
{
title: "harry potter and the prisoner of azkaban",
description: "harry potter movie",
genre: "fantasy",
year: 2004,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
},
{
title: "harry potter and the goblet of fire",
description: "harry potter movie",
genre: "fantasy",
year: 2005,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
},
{
title: "harry potter and the order of the phoenix",
description: "harry potter movie",
genre: "fantasy",
year: 2007,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
},
{
title: "harry potter and the half-blood prince",
description: "harry potter movie",
genre: "fantasy",
year: 2009,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
},
{
title: "harry potter and the deathly hallows: part 1",
description: "harry potter movie",
genre: "fantasy",
year: 2010,
repart: {
reparto: [
{
actor: "Daniel Radcliffe",
personaje: "Harry Potter",
friends: [
{ actor: "Emma Watson", personaje: "Hermione Granger" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Rupert Grint",
personaje: "Ron Weasley",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Emma Watson", personaje: "Hermione Granger" }
]
},
{
actor: "Emma Watson",
personaje: "Hermione Granger",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
},
{
actor: "Richard Harris",
personaje: "Albus Dumbledore",
friends: [
{ actor: "Daniel Radcliffe", personaje: "Harry Potter" },
{ actor: "Rupert Grint", personaje: "Ron Weasley" }
]
}
],
directores: [
{ director: "Chris Columbus" },
{ director: "Alfonso Cuarón" },
{ director: "Mike Newell" },
{ director: "David Yates" }
],
guionistas: [
{ guionista: "J.K. Rowling" },
{ guionista: "Steve Kloves" }
],
productores: [
{ productor: "David Heyman" },
{ productor: "David Barron" },
{ productor: "Mark Radcliffe" }
]
}
}]
);

//consulta para ver lo producido por david heyman

db.movies.find({"repart.productores.productor":"David Heyman"},{title:1, \_id:0, "repart.productores.productor":1});

db.movies.find({"year":2005}, {title:1, \_id:1, "repart.directores.director":1});

//consulta para ver los actores que han trabajado con daniel radcliffe

db.movies.find({"repart.reparto.friends.actor":"Daniel Radcliffe"},{title:1, \_id:0, "repart.reparto.friends.actor":1, "repart.reparto.friends.personaje":1});

//convertir los year en ISODate

db.movies.find({year:{$type:Int32}}).forEach(function(doc){doc.year=new ISODate(doc.year);db.movies.save(doc);});

//un insertMany con 4 documentos con ordered
de peliculas de dc animadas

db.movies.insertMany([
{
title: "Batman: The Animated Series",
equipo: {
equipoNormal:["Alfred","Robin"],
ligaJusticia:["flash", "Aquaman"]
},
enemigos:{
enemigosNormales:["Joker","Penguin"],
ligaEnemigos:["Lex Luthor","Darkseid"]
},
comics:{
normal:["Batman","Robin"],
liga:["Flash","Aquaman"]
},
batiObjetos:["Batarang","Batmóvil"]
},
{
title: "Batman Beyond",
equipo: {
equipoNormal:["Alfred","Robin"],
ligaJusticia:["flash", "Aquaman"]
},
enemigos:{
enemigosNormales:["Joker","Penguin"],
ligaEnemigos:["Lex Luthor","Darkseid"]
},
batiObjetos:["Bat-Signal","Utility Belt"]
},
{
title: "The Dark Knight",
equipo: {
equipoNormal:["Alfred","Robin"],
ligaJusticia:["flash", "Aquaman"]
},
enemigo:{
enemigosNormales:["Two-Face","Bane"],
ligaEnemigos:["The Joker","Harley Quinn"]
},
comics: [],
batiObjetos:["Grappling Hook","Bat-Pod"]
},
{
title: "Batman & Robin",
equipo: {
equipoNormal:["Alfred","Robin"],
ligaJusticia:["flash", "Aquaman"]
},
enemigos:{
enemigosNormales:["Mr. Freeze","Poison Ivy"],
ligaEnemigos:["The Riddler","Catwoman"]
},
comics:{
normal:["Batman","Robin"],
liga:["Flash","Aquaman"]
},
batiobjetos:["Bat-Signal","Utility Belt"]
}
], { ordered: true })


# json largo


[
  {
    "title": "Avengers: Endgame",
    "description": "The Avengers must come together to undo the devastating effects of Thanos' snap.",
    "genre": "Action",
    "year": 2019,
    "repart": {
      "reparto": [
        {
          "actor": "Robert Downey Jr.",
          "personaje": "Tony Stark / Iron Man",
          "friends": [
            { "actor": "Chris Evans", "personaje": "Steve Rogers / Captain America" },
            { "actor": "Scarlett Johansson", "personaje": "Natasha Romanoff / Black Widow" }
          ]
        },
        {
          "actor": "Chris Evans",
          "personaje": "Steve Rogers / Captain America",
          "friends": [
            { "actor": "Robert Downey Jr.", "personaje": "Tony Stark / Iron Man" },
            { "actor": "Mark Ruffalo", "personaje": "Bruce Banner / Hulk" }
          ]
        }
      ],
      "directores": [
        { "director": "Anthony Russo" },
        { "director": "Joe Russo" }
      ],
      "guionistas": [
        { "guionista": "Christopher Markus" },
        { "guionista": "Stephen McFeely" }
      ],
      "productores": [
        { "productor": "Kevin Feige" }
      ]
    }
  },
  {
    "title": "Detective Pikachu",
    "description": "In a world where people collect Pokémon to do battle, a boy comes across an intelligent talking Pikachu who seeks to be a detective.",
    "genre": "Action",
    "year": 2019,
    "repart": {
      "reparto": [
        {
          "actor": "Ryan Reynolds",
          "personaje": "Detective Pikachu (voice)",
          "friends": [
            { "actor": "Justice Smith", "personaje": "Tim Goodman" },
            { "actor": "Kathryn Newton", "personaje": "Lucy Stevens" }
          ]
        },
        {
          "actor": "Ken Watanabe",
          "personaje": "Detective Yoshida",
          "friends": [
            { "actor": "Justice Smith", "personaje": "Tim Goodman" },
            { "actor": "Kathryn Newton", "personaje": "Lucy Stevens" }
          ]
        }
      ],
      "directores": [
        { "director": "Rob Letterman" }
      ],
      "guionistas": [
        { "guionista": "Dan Hernandez" },
        { "guionista": "Benji Samit" }
      ],
      "productores": [
        { "productor": "Mary Parent" },
        { "productor": "Cale Boyter" },
        { "productor": "Hidenaga Katakami" }
      ]
    }
  },{
"title": "Frozen",
"description": "Disney animated musical movie",
"genre": "musical",
"year": 2013,
"repart": {
"reparto": [
{
"actor": "Kristen Bell",
"personaje": "Anna",
"friends": [
{"actor": "Idina Menzel", "personaje": "Elsa"},
{"actor": "Jonathan Groff", "personaje": "Kristoff"},
{"actor": "Josh Gad", "personaje": "Olaf"}
]
},
{
"actor": "Idina Menzel",
"personaje": "Elsa",
"friends": [
{"actor": "Kristen Bell", "personaje": "Anna"},
{"actor": "Jonathan Groff", "personaje": "Kristoff"},
{"actor": "Josh Gad", "personaje": "Olaf"}
]
},
{
"actor": "Jonathan Groff",
"personaje": "Kristoff",
"friends": [
{"actor": "Kristen Bell", "personaje": "Anna"},
{"actor": "Idina Menzel", "personaje": "Elsa"},
{"actor": "Josh Gad", "personaje": "Olaf"}
]
},
{
"actor": "Josh Gad",
"personaje": "Olaf",
"friends": [
{"actor": "Kristen Bell", "personaje": "Anna"},
{"actor": "Idina Menzel", "personaje": "Elsa"},
{"actor": "Jonathan Groff", "personaje": "Kristoff"}
]
}
],
"directores": [
{"director": "Chris Buck"},
{"director": "Jennifer Lee"}
],
"guionistas": [
{"guionista": "Jennifer Lee"},
{"guionista": "Chris Buck"},
{"guionista": "Shane Morris"}
],
"productores": [
{"productor": "Peter Del Vecho"}
]
}
},{
"title": "Iron Man",
"description": "Marvel superhero movie",
"genre": "action",
"year": 2008,
"repart": {
"reparto": [
{
"actor": "Robert Downey Jr.",
"personaje": "Tony Stark / Iron Man",
"friends": [
{"actor": "Gwyneth Paltrow", "personaje": "Pepper Potts"},
{"actor": "Terrence Howard", "personaje": "Jim Rhodes / War Machine"}
]
},
{
"actor": "Gwyneth Paltrow",
"personaje": "Pepper Potts",
"friends": [
{"actor": "Robert Downey Jr.", "personaje": "Tony Stark / Iron Man"},
{"actor": "Terrence Howard", "personaje": "Jim Rhodes / War Machine"}
]
},
{
"actor": "Terrence Howard",
"personaje": "Jim Rhodes / War Machine",
"friends": [
{"actor": "Robert Downey Jr.", "personaje": "Tony Stark / Iron Man"},
{"actor": "Gwyneth Paltrow", "personaje": "Pepper Potts"}
]
},
{
"actor": "Jeff Bridges",
"personaje": "Obadiah Stane",
"friends": []
}
],
"directores": [
{"director": "Jon Favreau"}
],
"guionistas": [
{"guionista": "Mark Fergus"},
{"guionista": "Hawk Ostby"},
{"guionista": "Art Marcum"},
{"guionista": "Matt Holloway"}
],
"productores": [
{"productor": "Avi Arad"},
{"productor": "Kevin Feige"}
]
}
},{
"title": "The Lion King",
"description": "Disney animated movie",
"genre": "adventure",
"year": 1994,
"repart": {
"reparto": [
{
"actor": "Matthew Broderick",
"personaje": "Adult Simba",
"friends": [
{"actor": "Nathan Lane", "personaje": "Timon"},
{"actor": "Ernie Sabella", "personaje": "Pumbaa"}
]
},
{
"actor": "Jeremy Irons",
"personaje": "Scar",
"friends": [
{"actor": "Whoopi Goldberg", "personaje": "Shenzi"},
{"actor": "Cheech Marin", "personaje": "Banzai"},
{"actor": "Jim Cummings", "personaje": "Ed"}
]
},
{
"actor": "James Earl Jones",
"personaje": "Mufasa",
"friends": []
},
{
"actor": "Jonathan Taylor Thomas",
"personaje": "Young Simba",
"friends": [
{"actor": "Nathan Lane", "personaje": "Timon"},
{"actor": "Ernie Sabella", "personaje": "Pumbaa"}
]
}
],
"directores": [
{"director": "Roger Allers"},
{"director": "Rob Minkoff"}
],
"guionistas": [
{"guionista": "Irene Mecchi"},
{"guionista": "Jonathan Roberts"},
{"guionista": "Linda Woolverton"}
],
"productores": [
{"productor": "Don Hahn"}
]
}
},{
"title": "The Avengers",
"description": "Marvel superhero movie",
"genre": "action",
"year": 2012,
"repart": {
"reparto": [
{
"actor": "Robert Downey Jr.",
"personaje": "Tony Stark / Iron Man",
"friends": [
{"actor": "Chris Evans", "personaje": "Steve Rogers / Captain America"},
{"actor": "Chris Hemsworth", "personaje": "Thor"},
{"actor": "Mark Ruffalo", "personaje": "Bruce Banner / The Hulk"},
{"actor": "Scarlett Johansson", "personaje": "Natasha Romanoff / Black Widow"},
{"actor": "Jeremy Renner", "personaje": "Clint Barton / Hawkeye"}
]
},
{
"actor": "Tom Hiddleston",
"personaje": "Loki",
"friends": []
},
{
"actor": "Samuel L. Jackson",
"personaje": "Nick Fury",
"friends": []
}
],
"directores": [
{"director": "Joss Whedon"}
],
"guionistas": [
{"guionista": "Joss Whedon"},
{"guionista": "Zak Penn"}
],
"productores": [
{"productor": "Kevin Feige"}
]
}
},{
"title": "Pokémon: The First Movie - Mewtwo Strikes Back",
"description": "Animated Pokémon movie",
"genre": "action",
"year": 1998,
"repart": {
"reparto": [
{
"actor": "Rikako Aikawa",
"personaje": "Mewtwo",
"friends": []
},
{
"actor": "Ikue Ōtani",
"personaje": "Pikachu",
"friends": [
{"actor": "Veronica Taylor", "personaje": "Ash Ketchum"},
{"actor": "Rachael Lillis", "personaje": "Misty"},
{"actor": "Eric Stuart", "personaje": "Brock"}
]
},
{
"actor": "Philip Bartlett",
"personaje": "Mew",
"friends": []
}
],
"directores": [
{"director": "Kunihiko Yuyama"}
],
"guionistas": [
{"guionista": "Takeshi Shudo"},
{"guionista": "Norman J. Grossfeld"}
],
"productores": [
{"productor": "Chōji Yoshikawa"}
]
}
},{
"title": "Spirited Away",
"description": "Japanese animated movie",
"genre": "fantasy",
"year": 2001,
"repart": {
"reparto": [
{
"actor": "Rumi Hiiragi",
"personaje": "Chihiro Ogino",
"friends": []
},
{
"actor": "Miyu Irino",
"personaje": "Haku",
"friends": []
},
{
"actor": "Mari Natsuki",
"personaje": "Yubaba / Zeniba",
"friends": []
},
{
"actor": "Tatsuya Gashuin",
"personaje": "No-Face",
"friends": []
}
],
"directores": [
{"director": "Hayao Miyazaki"}
],
"guionistas": [
{"guionista": "Hayao Miyazaki"}
],
"productores": [
{"productor": "Toshio Suzuki"}
]
}
},{
"title": "The LEGO Movie",
"description": "Animated movie featuring LEGO figures",
"genre": "comedy",
"year": 2014,
"repart": {
"reparto": [
{
"actor": "Chris Pratt",
"personaje": "Emmet Brickowski",
"friends": [
{"actor": "Elizabeth Banks", "personaje": "Wyldstyle"},
{"actor": "Will Arnett", "personaje": "Batman"},
{"actor": "Alison Brie", "personaje": "Unikitty"}
]
},
{
"actor": "Morgan Freeman",
"personaje": "Vitruvius",
"friends": []
},
{
"actor": "Liam Neeson",
"personaje": "Bad Cop / Good Cop",
"friends": []
},
{
"actor": "Charlie Day",
"personaje": "Benny",
"friends": []
}
],
"directores": [
{"director": "Phil Lord"},
{"director": "Chris Miller"}
],
"guionistas": [
{"guionista": "Phil Lord"},
{"guionista": "Chris Miller"}
],
"productores": [
{"productor": "Dan Lin"},
{"productor": "Roy Lee"}
]
}
}
]