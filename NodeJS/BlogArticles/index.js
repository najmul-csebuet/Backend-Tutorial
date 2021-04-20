 const express = require('express')
 const app = express()
 const mongoose = require('mongoose')
 const articleRouter = require('./routes/articles')
 require('dotenv').config()

 app.set('view engine', 'ejs')

 app.use('/articles', articleRouter)

 app.get('/', (req, res) => {
    const articles = [
        {
            title: "Test Article",
            createdAt: new Date(),
            description: 'Test Description'
        },
        {
            title: "Test Article 2",
            createdAt: new Date(),
            description: 'Test Description'
        }
    ]

    res.render('articles/index', { 'articles': articles })
})

 mongoose.connect(process.env.DB_CONNECTION_STRING, {useNewUrlParser: true, useUnifiedTopology: true}, () => {
     console.log("Connected to database")
 })

 app.listen(process.env.PORT, () => {
     console.log("Server started at http://localhost:3000")
 })