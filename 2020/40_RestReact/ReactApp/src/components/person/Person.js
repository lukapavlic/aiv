import React, { useState, useContext } from 'react'
import { PersonContext } from './context/PersonContext'
import { personApi } from '../../services/Axios'

const Person = ({ email, name, surname }) => {
    const [emailNew, setEmail] = useState(email)
    const [nameNew, setName] = useState(name)
    const [surnameNew, setSurname] = useState(surname)
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

    const updatePerson = e => {
        e.preventDefault()
        personApi.put(`/osebe/${email}`, `{ "email": "${emailNew}", "ime": "${nameNew}", "priimek": "${surnameNew}" }`).then(() => {
            personApi.get("/osebe").then(response => {
                setPersons(response.data)
            })
        })
    }

    const deletePerson = () => {
        personApi.delete(`/osebe/${emailNew}`).then(() => {
            personApi.get("/osebe").then(response => {
                setPersons(response.data)
            })
        })
    }

    return (
        <>
            <form onSubmit={updatePerson}>
                Email: <input type="text" name="email" placeholder="Email" value={emailNew} onChange={updateEmail} />
                Ime: <input type="text" name="name" placeholder="Name" value={nameNew} onChange={updateName} />
                Priimek: <input type="text" name="surname" placeholder="Surname" value={surnameNew} onChange={updateSurname} />
                <button>Posodobi</button>
                <button onClick={deletePerson}>Izbriši</button>
            </form>
        </>
    )
}

export default Person
