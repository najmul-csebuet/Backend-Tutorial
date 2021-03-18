const Joi = require('joi')
const express = require('express')

const app = express()

app.use(express.json())

const courses = [
    {id: 1, name: 'A'},
    {id: 2, name: 'B'},
    {id: 3, name: 'C'},
]

app.get('/', (req, res) => {
    res.send('Bismillah!!')
})

app.post('/api/courses', (req, res) => {

    const result = validateCourse(req)
    //const { error } = validateCourse(req)
    console.log(result)

    //if(!req.body.name || req.body.name.length < 3) {
    if(result.error) {
        // 400 bad req
        res.status(400).send(result.error.details[0].message)
        return
    }

    const course = {
        id: courses.length + 1,
        name: req.body.name
    }

    courses.push(course)
    res.status(201).send(course)
})

app.get('/api/courses', (req, res) => {
    res.send(courses)
})

app.get('/api/courses/:id', (req, res) => {
    const course = courses.find(c => c.id === parseInt(req.params.id))
    if(!course) {
        res.status(404).send("Course not found.")
        return
    }

    res.status(200).send(course)
})



app.put('/api/courses/:id', (req, res) => {
    const course = courses.find(c => c.id === parseInt(req.params.id))
    if(!course) {
        res.status(404).send("Course not found.")
        return
    }

    const result = validateCourse(req)
    if(result.error) {
        res.status(400).send(result.error.details[0].message)
        return
    }

    course.name = req.body.name
    res.status(200).send(course)
})


app.delete('/api/course/:id', (req, res) => {
    const course = courses.find(c => c.id === parseInt(req.params.id))
    if(!course) {
        res.status(404).send("Course not found.")
        return
    }

    const index = courses.indexOf(course)
    courses.splice(index, 1)

    res.send(course)
})

function validateCourse(req) {
    console.log(req)
    const schema = Joi.object({
        name: Joi.string().min(3).required()
    })

    const result = schema.validate({name: req.body.name})
    return result
}

const port = process.env.PORT || 3000
app.listen(port, () => console.log(`Listening http://localhost:${port}...`))

// axios.defaults.headers.common['Authorization'] = 'Bearer ' + localStorage.getItem('jwtToken');
// axios.get('http://localhost:3030/users', {
//             headers: { 
//                 'Content-Type': 'application/json',
//                 'Accept': 'application/vnd.libro-restricted-v2+json',
//                 'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTgwNzQ3OTEsImlhdCI6MTYxNTM5OTk5MSwiaXNzIjoibGlicm8uYXBwIiwidXNlciI6eyJlbWFpbCI6Im1pY2hhZWxAcmVzdG9tb250cmVhbC5jYSJ9fQ.3RMqBf4SH9aPWmhk_66OLSCQLXUbo7d4fMYS6yiZHaI',
//             }
//         }).then((data)=>{
//                  console.log('data comming',data);
//                 dispatch(getUsersData(data));
//             }).catch((error)=>{
//               console.log('error comming',error);
//                 dispatch(errorgetUsersData(error));
//             });

// axios.get('https://api-dev.libroreserve.com/restricted/store/tickets'
// ,{
//     'Content-Type': 'application/json',
//     'Accept': 'application/vnd.libro-restricted-v2+json',
//     'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTgwNzQ3OTEsImlhdCI6MTYxNTM5OTk5MSwiaXNzIjoibGlicm8uYXBwIiwidXNlciI6eyJlbWFpbCI6Im1pY2hhZWxAcmVzdG9tb250cmVhbC5jYSJ9fQ.3RMqBf4SH9aPWmhk_66OLSCQLXUbo7d4fMYS6yiZHaI',
// })
// .then(res => res.data)
// .then(res => {
//     cb({
//     success: true,
//     data: deserialize(res, { transformKeys: "camelCase" }).data,
//     });
// })
// .catch(err => {
//     logger.ExceptionLog(err);
//     let { message } = err;
//     if (err.response.data.error) {
//     message = err.response.data.error;
//     }
//     socket.emit('misc-error', message);
// })