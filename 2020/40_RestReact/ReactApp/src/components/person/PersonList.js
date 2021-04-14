import React, { useContext, useEffect } from 'react'
import { PersonContext } from './context/PersonContext'
import Person from './Person'
import { personApi } from '../../services/Axios'

const PersonList = () => {
    const [persons, setPersons] = useContext(PersonContext)

    useEffect(() => {
        const fetchPersons = async () => {
            const response = await personApi.get("/osebe")
            setPersons(response.data)
        }
        fetchPersons()
    }, [])

    return (
        <div>
            {persons.map(person =>
                <Person key={person.email} email={person.email} name={person.ime} surname={person.priimek} />
            )}
        </div>
    )
}

export default PersonList
