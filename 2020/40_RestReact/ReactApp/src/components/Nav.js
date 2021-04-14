import React, { useContext } from 'react'
import { PersonContext } from './person/context/PersonContext'

const Nav = () => {
    const [persons, setPersons] = useContext(PersonContext)
    return (
        <nav>
            <h3>Seznam oseb: {persons.length}</h3>
        </nav>
    )
}

export default Nav
