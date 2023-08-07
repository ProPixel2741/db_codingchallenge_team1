import React from "react";
import Form from "react-bootstrap/Form"
import { Button, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { login } from "../../services/AuthenticationService";

export const LoginPage = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const [isBadPassword, setIsBadPassword] = useState(false);

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
        
        login(user).then(response => {
            console.log(response.data)
            navigate('/dashboard', {state: {username: user.username, token: response.data.token}})
        }).catch(function (error) {
            console.log(error.response.status);
            setIsBadPassword(true);
            
        })
        // if (true) {
        //     window.location.href="http://localhost:3000/dashboard";
        // } else {
        //     window.location.href="http://localhost:3000/";
        // }
    }

    return (
        <>
        <h1>Bond Dashboard</h1>
        <br/>
        <h2>Login</h2>
        <h2></h2>
        <body>Enter username and password or sign up <a href="/signup">here</a>.</body>
        <Form className="form">
            <Form.Group>
                <TextField required id="username" label="Username" variant="standard" value={username} onChange={handleUsernameChange}/>
            </Form.Group>
            <Form.Group>
                <TextField required id="password" error={isBadPassword} helperText={isBadPassword ? "Incorrect Password": ""} label="Password" type="password" variant="standard" value={password} onChange={handlePasswordChange}/>
            </Form.Group>
            <br/>
            <Button variant="contained" disabled={!username || !password} onClick={handleSubmit}>Login</Button>
            {/* <Button type="submit" onClick={handleSubmit} variant="contained">Login</Button> */}
        </Form>
        </>
    )
}