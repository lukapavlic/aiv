import Axios from "axios"

export const personApi = Axios.create({
    baseURL: process.env.REACT_APP_PERSON,
    timeout: 30000,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});