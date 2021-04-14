import React, { useState, createContext } from 'react'

export const PersonContext = createContext()

export const PersonProvider = props => {
    const [persons, setPersons] = useState([
        {
            email: "test@gmail.com",
            name: "testIme",
            surname: "testPriimek"
        }
    ])

    return (
        <PersonContext.Provider value={[persons, setPersons]}>
            {props.children}
        </PersonContext.Provider>
    )
}
