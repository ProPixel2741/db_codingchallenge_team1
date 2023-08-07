import React from "react";
import Form from "react-bootstrap/Form"
import { Button } from "@mui/material";
import { useState } from "react";

export const SignUpPage = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        let user = {};
        user.username = username;
        user.password = password;
        console.log(user);
        // handle login validation
        if (true) {
            window.location.href="http://localhost:3000/dashboard";
        } else {
            window.location.href="http://localhost:3000/";
        }
    }

    return (
        <>
        <h1>Bond Dashboard</h1>
        <br/>
        <h2>Sign Up</h2>
        <h2></h2>
        <Form className="form">
            <Form.Group>
                <Form.Label>Username: </Form.Label>
                <Form.Control type="text" value={username} onChange={handleUsernameChange}/>
            </Form.Group>
            <Form.Group>
                <Form.Label>Password:&nbsp;&nbsp;</Form.Label>
                <Form.Control type="text" value={password} onChange={handlePasswordChange}/>
            </Form.Group>
            <br/>
            <Button type="submit" onClick={handleSubmit} variant="contained">Sign Up</Button>
        </Form>
        </>
    )
}