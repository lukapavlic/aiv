import React, { useState, useContext } from 'react'
import { PersonContext } from './context/PersonContext'
import { personApi } from '../../services/Axios'

const AddPerson = () => {
    const [email, setEmail] = useState('')
    const [name, setName] = useState('')
    const [surname, setSurname] = useState('')
    const [persons, setPersons] = useContext(PersonContext)

    const updateEmail = e => {
        setEmail(e.target.value)
    }

    const updateName = e => {
        setName(e.target.value)
    }

    const updateSurname = e => {
        setSurname(e.target.value)
    }

    const addPerson = e => {
        e.preventDefault()
        personApi.post(`/osebe`, `{ "email": "${email}", "ime": "${name}", "priimek": "${surname}" }`).then(() => {
            personApi.get("/osebe").then(response => {
                setPersons(response.data)
            })
        })
    }

    return (
        <form onSubmit={addPerson}>
            Email: <input type="text" name="email" placeholder="Email" value={email} onChange={updateEmail} /><br/>
            Ime: <input type="text" name="name" placeholder="Name" value={name} onChange={updateName} /><br/>
            Priimek: <input type="text" name="surname" placeholder="Surname" value={surname} onChange={updateSurname} /><br/>
            <button>Dodaj osebo</button>
        </form>
    )
}

export default AddPerson
