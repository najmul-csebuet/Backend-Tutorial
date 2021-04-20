const express = require('express')
const router = express.Router()

router.get('/', (req, res) => {
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

module.exports = router