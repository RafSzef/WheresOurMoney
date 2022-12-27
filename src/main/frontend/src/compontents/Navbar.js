import React from "react";
import logo from "../logo.svg";

export default function Navbar() {
    return (
        <nav>
            <img src={logo} className="App-logo" alt="logo"/>
            <h3 className="nav--logo_text">WheresOurMoney</h3>
            <ul>
                <li>Accounts</li>
                <li>Categories</li>
                <li>Users</li>
            </ul>
            <button className="nav--login_button">Login</button>
        </nav>)
}