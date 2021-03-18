const express = require('express')
const router = express.Router()
const Subscriber = require('../models/subscriber')

router.get('/', async (req, res) => {
    
    try {
        const allSubscribers = await Subscriber.find()
        res.json(allSubscribers)
    } catch (err) {
        res.status(500).json({message: err.message})
    }

})

router.get('/:id', getSubscriber, (req, res) => {
    res.send(req.subscriber)
})

router.post('/', async(req, res) => {
    const sc = new Subscriber({
        name: req.body.name,
        subscribedToChannel: req.body.subscribedToChannel
    })

    try {
        const newSc = await sc.save()
        res.status(201).json(newSc)
    }
    catch {
        res.status(400).json({message: err.message})
    }
})

router.patch('/:id', (req, res) => {

})

router.delete('/:id', (req, res) => {

})


async function getSubscriber(req, res, next) {
    let subscriber
    try {
        subscriber = await Subscriber.findById(req.params.id)
        if(subscriber == null) {
            return res.status(404).json({message: 'Can\'t find subscriber'})
        }
    } catch(err) {
        return res.status(500).json({message: err.message})
    }

    res.subscriber = subscriber
    next()
}

module.exports = router